package com.commerce.domain.user

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userNo: Long? = null, //`user_no` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '사용자 user_no',

    val username: String, // `username` VARCHAR(20) NOT NULL COMMENT '유저이름',

    val password: String, // `password` VARCHAR(50) NOT NULL COMMENT '비밀번호',

    var nickname: String, // `nickname` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '유저 닉네임',

    var point: Int = 0, // `point` INT NOT NULL DEFAULT '0' COMMENT '남은 포인트',

    val regDt: LocalDate = LocalDate.now(), // `chg_dt` DATETIME NOT NULL COMMENT '수정일시',

    var chgDt: LocalDate = LocalDate.now(),

    @Enumerated(EnumType.STRING)
    var userRole: UserRole = UserRole.USER
) {
    fun updatePoint(point: Int) {
        this.point += point
    }
}