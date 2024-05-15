package jp.ac.ohara.score.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "Tests")
public class TestModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(name = "student_no")
	private String studentNo;
	
	//@ManyToOne
    //@JoinColumn(name = "student_no")
    //private StudentModel student;
	
	@Column(name = "school_cd")
	private String schoolCd;
	
	@Column(name = "subject_cd")
	private String subjectCd;
	
	@Column(name = "class_num")
	private String classNum;
	
	@Column(name = "no")
	private Integer no;
	
	@Column(name = "point")
	private Integer point;
	
	/* 科目別 */
	@Transient  // データベースのカラムに対応しないフィールド
    private String studentName;
	@Transient  // データベースのカラムに対応しないフィールド
    private Integer entYear;
	
	// 学生名を設定するためのメソッド
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    // 入学年度を設定するためのメソッド
    public void setEntYear(Integer entYear) {
        this.entYear = entYear;
    }
    
    
    /* - - - - - 学生別 - - - - - */
    @Transient  // データベースのカラムに対応しないフィールド
    private String subjectName;
	
	// 科目名を設定するためのメソッド
    public void setSubjentName(String subjectName) {
        this.subjectName = subjectName;
    }
}