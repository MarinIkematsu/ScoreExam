CREATE TABLE `Classes` (
	`id` SERIAL,
	`school_cd` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学校コード',
	`class_num` VARCHAR(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'クラス番号',
	PRIMARY KEY (`school_cd`,`class_num`)
) ENGINE=InnoDB;