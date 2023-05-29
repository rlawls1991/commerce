package com.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtTokenFilter : OncePerRequestFilter() {

    @Autowired
    private lateinit var userService: UserDetailServiceImpl

    @Value("\${jwt.secret}")
    private lateinit var jwtSecret: String

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        val token = extractToken(request)

        if (token != null && validateToken(token)) {
            val claims: Claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).body
            val userDetails: UserDetails = userService.loadUserByUsername(claims.subject)

            val authentication = UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.authorities
            )

            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }

    private fun extractToken(request: HttpServletRequest): String? {
        return request.getHeader("Authorization") ?: return null
    }

    private fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }
}
