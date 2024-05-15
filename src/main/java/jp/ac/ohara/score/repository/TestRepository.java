package jp.ac.ohara.score.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.score.models.TestModel;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Long> {
	//List<StudentModel> findByEntYearAndClassNum(Integer entYear, String classNum);
	List<TestModel> findBySchoolCd(String schoolCd);
	
    // 科目別検索のメソッド
	List<TestModel> findByStudentNoInAndSubjectCd(List<String> studentNos, String subjectCd);
	
	// 学生別検索のメソッド
    List<TestModel> findByStudentNo(String studentNo);

}