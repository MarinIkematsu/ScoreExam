package jp.ac.ohara.score.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.score.models.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
	// 学校コードに一致する学生情報を取得するメソッドの定義
    List<StudentModel> findBySchoolCd(String schoolCd);
	// DBから絞り込んで取得
	List<StudentModel> findByEntYearAndClassNumAndIsAttend(Integer entYear, String classNum, boolean isAttend);
	List<StudentModel> findByEntYear(Integer entYear);
	List<StudentModel> findByClassNum(String classNum);
	List<StudentModel> findByIsAttend(boolean isAttend);
	//成績管理用
	List<StudentModel> findByEntYearAndClassNum(Integer entYear, String classNum);
	//成績参照 StudentNoを使用した学生情報の取得
	StudentModel findByStudentNo(String studentNo);
	
}
