package jp.ac.ohara.score.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Students")
public class StudentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
    @Column(name = "student_no")
    private String studentNo;

    @Column(name = "student_name")
    private String studentName;
    
    @Column(name = "ent_year")
    private Integer entYear;
    
    @Column(name = "class_num")
    private String classNum;
    
    @Column(name = "is_attend")
    private Boolean isAttend;
    
    @Column(name = "school_cd")
    private String schoolCd;
}
