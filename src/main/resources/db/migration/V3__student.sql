CREATE TABLE `Students` (
	`id` SERIAL,
	`student_no` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生番号',
	`student_name` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学生名',
	`ent_year` INT(10) DEFAULT NULL COMMENT '入学年度',
	`class_num` CHAR(3) DEFAULT NULL COMMENT 'クラス番号',
	`is_attend` BOOLEAN DEFAULT NULL COMMENT '在学中フラグ',
	`school_cd` CHAR(3) DEFAULT NULL COMMENT '学校コード',
	PRIMARY KEY (`student_no`)
) ENGINE=InnoDB;