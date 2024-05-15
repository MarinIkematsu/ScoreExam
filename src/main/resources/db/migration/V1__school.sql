CREATE TABLE `Schools` (
	`id` SERIAL,
	`school_cd` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学校コード',
	`school_name` VARCHAR(20) COMMENT '学校名',
	PRIMARY KEY (`school_cd`)
) ENGINE=InnoDB;