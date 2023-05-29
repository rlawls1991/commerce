package com.commerce.domain.product

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CategoryDivide(
    @Id
    @Column(name = "dcate_cd")
    val dcateCd: Long? = null, //  `dcate_cd` INT UNSIGNED NOT NULL COMMENT '세분류(400000)',

    val lcate_cd: Int, //  `lcate_cd` INT UNSIGNED NOT NULL COMMENT '대분류',

    val mcate_cd: Int, //  `mcate_cd` INT UNSIGNED NOT NULL COMMENT '중분류',

    val scate_cd: Int, //  `scate_cd` INT UNSIGNED NOT NULL COMMENT '소분류',

    val dcate_nm: String, //  `lcate_cd` INT UNSIGNED NOT NULL COMMENT '대분류',

    val useYn: String, // `use_yn` CHAR(1) NOT NULL COMMENT '사용여부(사용:Y/미사용:N)',

    val regId: String, // `reg_id` VARCHAR(20) NOT NULL COMMENT '등록자',

    val regDt: LocalDate = LocalDate.now(), // `regDt` DATETIME NOT NULL COMMENT '등록일시',

    val chgId: String, //  `chg_id` VARCHAR(20) DEFAULT NULL COMMENT '수정자',

    var chgDt: LocalDate = LocalDate.now(), // `chg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
)

