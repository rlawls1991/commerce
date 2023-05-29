package com.commerce.domain.product

import java.math.BigInteger
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Prod(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val prodNo: BigInteger? = null, // `review_no` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '구매후기시퀀스',

    val prodNm: String, // prod_nm` VARCHAR(100) NOT NULL COMMENT '상품명',

    val prodStatus: String, // `prod_status` CHAR(1) NOT NULL DEFAULT '' COMMENT '상품상태(T: 임시저장, A:판매중, S:판매중지, E:수정대기)',

    val saleStatus: String, // `sale_status` CHAR(1) NOT NULL DEFAULT '' COMMENT '판매상태(A:판매중, S:품절)',

    val salePrice: Long, // `sale_price` INT UNSIGNED NULL DEFAULT NULL COMMENT '판매가격',

    val dcateCd: Int, // `dcate_cd` INT(10) UNSIGNED NOT NULL COMMENT '세카테고리',

    val saleStatusDt: LocalDate = LocalDate.now(), // `sale_status_dt` DATETIME DEFAULT NULL COMMENT '판매중지처리일시',

    val dispYn: String, // `disp_yn` CHAR(1) DEFAULT NULL COMMENT '노출정보',

    val regId: String, // `reg_id` VARCHAR(20) NOT NULL COMMENT '등록자',

    val regDt: LocalDate = LocalDate.now(), // `regDt` DATETIME NOT NULL COMMENT '등록일시',

    val chgId: String, //  `chg_id` VARCHAR(20) DEFAULT NULL COMMENT '수정자',

    var chgDt: LocalDate = LocalDate.now(), // `chg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
)
