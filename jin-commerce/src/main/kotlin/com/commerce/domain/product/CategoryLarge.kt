package com.commerce.domain.product

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CategoryLarge(
    @Id
    val lcateCd: Long? = null, //  `lcate_cd` INT UNSIGNED NOT NULL COMMENT '대분류(100000)',

    val lcateNm: String, //   `lcate_nm` VARCHAR(50) NOT NULL COMMENT '대분류 명',

    val useYn: String, // `use_yn` CHAR(1) NOT NULL COMMENT '사용여부(사용:Y/미사용:N)',

    val regId: String, // `reg_id` VARCHAR(20) NOT NULL COMMENT '등록자',

    val regDt: LocalDate = LocalDate.now(), // `regDt` DATETIME NOT NULL COMMENT '등록일시',

    val chgId: String, //  `chg_id` VARCHAR(20) DEFAULT NULL COMMENT '수정자',

    var chgDt: LocalDate = LocalDate.now(), // `chg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
)
