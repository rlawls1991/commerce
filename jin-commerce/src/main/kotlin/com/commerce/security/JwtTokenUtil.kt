package com.security


import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenUtil {
    @Value("\${jwt.secret}")
    private lateinit var jwtSecret: String

    private val expirationTime: Long = 3600L

    fun generateToken(userDetails: UserDetails): String {
        val claims: Map<String, Any> = mapOf(Claims.SUBJECT to userDetails.username)
        val createdDate = Date()
        val expirationDate = calculateExpirationDate(createdDate)

        return Jwts.builder()
            .setClaims(HashMap(claims)) // 여기를 수정
            .setIssuedAt(createdDate)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS512, this.jwtSecret)
            .compact()
    }

    private fun calculateExpirationDate(createdDate: Date): Date {
        return Date(createdDate.time + expirationTime * 1000)
    }

    fun getAuthenticatedUserRole(): String? {
        val authentication = SecurityContextHolder.getContext().authentication
        if (authentication != null && authentication.isAuthenticated) {
            val authorities = authentication.authorities
            if (authorities.isNotEmpty()) {
                return authorities.first().authority
            }
        }

        return null
    }

    fun getAuthenticatedUserName(): String? {
        val authentication = SecurityContextHolder.getContext().authentication
        if (authentication != null && authentication.isAuthenticated) {
            val principal = authentication.principal
            if (principal is UserDetails) {
                return principal.username
            }
        }
        return null
    }
}