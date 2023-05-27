package com.commerce.domain.user

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        val username: String,

        val password: String,

        var remainingLeave: Double = 15.0,

        val regDt: LocalDate = LocalDate.now(),

        var chgDt: LocalDate = LocalDate.now(),

        @Enumerated(EnumType.STRING)
        var userRole: UserRole = UserRole.USER
)