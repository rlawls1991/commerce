CREATE SCHEMA IF NOT EXISTS `user` DEFAULT CHARACTER SET utf8;
USE `user`;

CREATE TABLE `user` (
  `user_no` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '사용자 user_no',
  `username` VARCHAR(20) NOT NULL COMMENT '유저이름',
  `password` VARCHAR(50) NOT NULL COMMENT '비밀번호',
  `nickname` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '유저 닉네임',
  `point` INT NOT NULL DEFAULT '0' COMMENT '남은 포인트',
  `chg_dt` DATETIME NOT NULL COMMENT '수정일시',
  PRIMARY KEY (`user_no`),
  KEY `idx_user_1` (`username`),
  KEY `idx_user_2` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='유저 정보';

CREATE TABLE `point_history` (
  `point_history_no` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '포인트 history_no',
  `user_no` INT UNSIGNED NOT NULL COMMENT '사용자 user_no',
  `order_no` BIGINT DEFAULT NULL COMMENT '주문번호',
  `point` INT UNSIGNED NOT NULL DEFAULT '0' COMMENT '증감된 포인트',
  `point_status` CHAR(1) DEFAULT NULL COMMENT '포인트사용상태(A:충전, C:사용취소, U:사용)',
  `reg_dt` DATETIME NOT NULL COMMENT '등록일시',
  PRIMARY KEY (`point_history_no`),
  KEY `idx_point_history_1` (`user_no`, `order_no`, `point_status`),
  KEY `idx_point_history_2` (`reg_dt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='유저 정보';