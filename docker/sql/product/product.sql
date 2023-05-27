CREATE SCHEMA IF NOT EXISTS `product` DEFAULT CHARACTER SET utf8;
USE `product`;

CREATE TABLE `prod`(
    `prod_no`        BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '상품번호',
    `prod_nm`        VARCHAR(100) NOT NULL COMMENT '상품명',
    `prod_status`    CHAR(1)      NOT NULL DEFAULT '' COMMENT '상품상태(T: 임시저장, A:판매중, S:판매중지, E:수정대기)',
    `sale_status`    CHAR(1)      NOT NULL DEFAULT '' COMMENT '판매상태(A:판매중, S:품절)',
    `sale_price`     INT UNSIGNED NULL DEFAULT NULL COMMENT '판매가격',
    `dcate_cd`       INT(10) UNSIGNED NOT NULL COMMENT '세카테고리',
    `sale_status_dt` DATETIME              DEFAULT NULL COMMENT '판매중지처리일시',
    `disp_yn`        CHAR(1)               DEFAULT NULL COMMENT '노출정보',
    `reg_id`         VARCHAR(20)  NOT NULL COMMENT '등록자',
    `reg_dt`         DATETIME     NOT NULL COMMENT '등록일시',
    `chg_id`         VARCHAR(20)           DEFAULT NULL COMMENT '수정자',
    `chg_dt`         DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
    PRIMARY KEY (`prod_no`),
    UNIQUE KEY `uk_prod_1`(`prod_no`, `dcate_cd`),
    KEY              `idx_prod_1` (`dcate_cd`),
    KEY              `idx_prod_2` (`reg_dt`),
    KEY              `idx_prod_3` (`reg_id`),
    KEY              `idx_prod_search_1` (`dcate_cd`,`prod_status`,`sale_status`,`disp_yn`,`reg_dt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품정보';

CREATE TABLE `category_divide` (
    `dcate_cd` INT UNSIGNED NOT NULL COMMENT '세분류(400000)',
    `lcate_cd` INT UNSIGNED NOT NULL COMMENT '대분류',
    `mcate_cd` INT UNSIGNED NOT NULL COMMENT '중분류',
    `scate_cd` INT UNSIGNED NOT NULL COMMENT '소분류',
    `dcate_nm` VARCHAR(50) NOT NULL COMMENT '세분류 명',
    `use_yn` CHAR(1) NOT NULL COMMENT '사용여부(사용:Y/미사용:N)',
    `reg_dt` DATETIME NOT NULL COMMENT '등록일시',
    `chg_dt` DATETIME NOT NULL COMMENT '수정일시',
    PRIMARY KEY (`dcate_cd`),
    KEY `idx_category_divide_1` (`use_yn`),
    KEY `idx_category_divide_2` (`reg_dt`),
    KEY `idx_category_divide_3` (`chg_dt`),
    KEY `idx_category_divide_4` (`scate_cd`),
    KEY `idx_category_divide_5` (`mcate_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='세카테고리';

CREATE TABLE `category_large` (
    `lcate_cd` INT UNSIGNED NOT NULL COMMENT '대분류(100000)',
    `lcate_nm` VARCHAR(50) NOT NULL COMMENT '대분류 명',
    `use_yn` CHAR(1) NOT NULL COMMENT '사용여부(사용:Y/미사용:N)',
    `reg_dt` DATETIME NOT NULL COMMENT '등록일시',
    `chg_dt` DATETIME NOT NULL COMMENT '수정일시',
    PRIMARY KEY (`lcate_cd`),
    KEY `idx_category_large_1` (`use_yn`),
    KEY `idx_category_large_2` (`reg_dt`),
    KEY `idx_category_large_3` (`chg_dt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='대카테고리';

CREATE TABLE `category_middle` (
    `mcate_cd` INT UNSIGNED NOT NULL COMMENT '중분류(200000)',
    `lcate_cd` INT UNSIGNED NOT NULL COMMENT '대분류',
    `mcate_nm` VARCHAR(50) NOT NULL COMMENT '중분류 명',
    `use_yn` CHAR(1) NOT NULL COMMENT '사용여부(사용:Y/미사용:N)',
    `reg_dt` DATETIME NOT NULL COMMENT '등록일시',
    `chg_dt` DATETIME NOT NULL COMMENT '수정일시',
    PRIMARY KEY (`mcate_cd`),
    KEY `idx_category_middle_1` (`use_yn`),
    KEY `idx_category_middle_2` (`reg_dt`),
    KEY `idx_category_middle_3` (`chg_dt`),
    KEY `idx_category_middle_4` (`lcate_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='중카테고리';

CREATE TABLE `category_small` (
    `scate_cd` INT UNSIGNED NOT NULL COMMENT '소분류(300000)',
    `lcate_cd` INT UNSIGNED NOT NULL COMMENT '대분류',
    `mcate_cd` INT UNSIGNED NOT NULL COMMENT '중분류',
    `scate_nm` VARCHAR(50) NOT NULL COMMENT '소분류 명',
    `use_yn` CHAR(1) NOT NULL COMMENT '사용여부(사용:Y/미사용:N)',
    `reg_dt` DATETIME NOT NULL COMMENT '등록일시',
    `chg_dt` DATETIME NOT NULL COMMENT '수정일시',
    PRIMARY KEY (`scate_cd`),
    KEY `idx_category_small_1` (`use_yn`),
    KEY `idx_category_small_2` (`reg_dt`),
    KEY `idx_category_small_3` (`chg_dt`),
    KEY `idx_category_small_4` (`mcate_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='소카테고리';