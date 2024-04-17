CREATE TABLE `Tests` (
	`student_no` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生番号',
	`school_cd` CHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学校コード',
	`subject_cd` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '科目コード',
	`class_num` VARCHAR(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'クラス番号',
	`no` INT(10) NOT NULL COMMENT '回数',
	`point` INT(10) DEFAULT NULL COMMENT '得点',
	PRIMARY KEY (`student_no`,`school_cd`,`subject_cd`,`no`)
) ENGINE=InnoDB;