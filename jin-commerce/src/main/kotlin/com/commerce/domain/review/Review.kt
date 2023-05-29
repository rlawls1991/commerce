package com.commerce.domain.review

import java.math.BigInteger
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val reviewNo: Long? = null, // `review_no` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '구매후기시퀀스',

    @Column(unique = true)
    val orderNo: BigInteger, // `order_no` BIGINT NOT NULL COMMENT '주문 번호',

    val prodNo: BigInteger, // `prod_no` BIGINT UNSIGNED NOT NULL COMMENT '상품 ID',

    val userNo: Long, // `user_no` INT UNSIGNED NOT NULL COMMENT '작성자 ID',

    val reviewContent: String? = null, // `review_content` VARCHAR(1000) NOT NULL COMMENT '구매후기 내용',

    val likeCount: Long = 0L, // `like_count` INT UNSIGNED NOT NULL DEFAULT '0' COMMENT '좋아요총건수',

    val delYn: String, // `del_yn` CHAR(1) NOT NULL COMMENT '삭제여부 y, n',

    var regDt: LocalDate = LocalDate.now(), // `reg_dt` DATETIME NOT NULL COMMENT '등록일시',

    var chgDt: LocalDate = LocalDate.now() // `chg_dt` DATETIME NOT NULL COMMENT '수정일시',
)
