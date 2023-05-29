CREATE SCHEMA IF NOT EXISTS `review` DEFAULT CHARACTER SET utf8;
USE `review`;

CREATE TABLE `review` (
    `review_no` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '구매후기시퀀스',
    `order_no` BIGINT DEFAULT NULL COMMENT '주문 번호',
    `prod_no` BIGINT UNSIGNED NOT NULL COMMENT '상품 ID',
    `user_no` INT UNSIGNED NOT NULL COMMENT '작성자 ID',
    `review_content` VARCHAR(1000) NOT NULL COMMENT '구매후기 내용',
    `like_count` INT UNSIGNED NOT NULL DEFAULT '0' COMMENT '좋아요총건수',
    `del_yn` CHAR(1) NOT NULL COMMENT '삭제여부 y, n',
    `reg_dt` DATETIME NOT NULL COMMENT '등록일시',
    `chg_dt` DATETIME NOT NULL COMMENT '수정일시',
    PRIMARY KEY (`review_no`),
    UNIQUE KEY `uk_review_1` (`order_no`),
    KEY `idx_review_1` (`prod_no`),
    KEY `idx_review_2` (`reg_dt`),
    KEY `idx_review_3` (`user_no`),
    KEY `idx_review_4` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='구매후기';