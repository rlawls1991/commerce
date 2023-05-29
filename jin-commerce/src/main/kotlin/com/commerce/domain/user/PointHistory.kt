package com.commerce.domain.user

import java.math.BigInteger
import java.time.LocalDate
import javax.persistence.*

@Entity
data class PointHistory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val pointHistoryNo: BigInteger? = null, //`point_history_no` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '포인트 history_no',

    @ManyToOne
    var user: User,

    val orderNo: BigInteger, // BIGINT DEFAULT NULL COMMENT '주문번호',

    val point: Int, // `point` INT UNSIGNED NOT NULL DEFAULT '0' COMMENT '증감된 포인트',

    val pointStatus: PointStatus, // `point_status` CHAR(1) DEFAULT NULL COMMENT '포인트사용상태(A:충전, C:사용취소, U:사용)',

    val regDt: LocalDate = LocalDate.now(), // `chg_dt` DATETIME NOT NULL COMMENT '수정일시',
)
