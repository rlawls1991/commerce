CREATE SCHEMA IF NOT EXISTS `escrow` DEFAULT CHARACTER SET utf8 ;
USE `escrow`;

CREATE TABLE `order` (
  `order_no` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '주문번호',
  `prod_no` BIGINT UNSIGNED NOT NULL COMMENT '상품 ID',
  `prod_count` BIGINT UNSIGNED NOT NULL COMMENT '상품 구매 갯수',
  `cancel_yn` CHAR(1) DEFAULT NULL COMMENT '주문취소여부',
  `user_no` INT UNSIGNED NOT NULL COMMENT '주문자 ID',
  `reg_dt` DATETIME NOT NULL COMMENT '등록일시',
  PRIMARY KEY (`order_no`),
  KEY `prod_no` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='주문';

CREATE TABLE `delivery` (
  `delivery_no` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '구매후기시퀀스',
  `order_no` BIGINT UNSIGNED NOT NULL COMMENT '주문번호',
  `delivery_status` CHAR(1) DEFAULT NULL COMMENT '배송상태(A:배송중, D:배송대기, E:배송완료)',
  PRIMARY KEY (`delivery_no`),
  UNIQUE KEY `uk_delivery_1`(`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='배송';