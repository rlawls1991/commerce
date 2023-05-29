package com.commerce.domain.escrow

import java.math.BigInteger
import javax.persistence.*

@Entity
data class Delivery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val deliveryNo: BigInteger? = null, // `delivery_no` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '구매후기시퀀스',

    @OneToOne
    val order: Order, // BIGINT UNSIGNED NOT NULL COMMENT '주문번호',

    var deliveryStatus: String, // CHAR(1) DEFAULT NULL COMMENT '배송상태(A:배송중, D:배송대기, E:배송완료)',
)
