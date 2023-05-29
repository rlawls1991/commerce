package com.commerce.domain.escrow

import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderNo: BigInteger? = null, // `order_no` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '주문번호',

    val prodNo: BigInteger, //  `prod_count` BIGINT UNSIGNED NOT NULL COMMENT '상품 구매 갯수',

    val prodCount: Int, // prod_nm` VARCHAR(100) NOT NULL COMMENT '상품명',

    val cancelYn: String, // `cancel_yn` CHAR(1) DEFAULT NULL COMMENT '주문취소여부',

    val userNo: String, // `user_no` INT UNSIGNED NOT NULL COMMENT '주문자 ID',

    val regDt: Int, // DATETIME NOT NULL COMMENT '등록일시',
)
