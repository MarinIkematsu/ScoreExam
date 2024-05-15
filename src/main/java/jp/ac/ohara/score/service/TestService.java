package jp.ac.ohara.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.ohara.score.models.StudentModel;
import jp.ac.ohara.score.models.TestModel;
import jp.ac.ohara.score.repository.StudentRepository;
import jp.ac.ohara.score.repository.TestRepository;

@Service
public class TestService {
	@Autowired
    private TestRepository testRepository;
	@Autowired
    private StudentRepository studentRepository;
	
	// 成績の一覧表示
	// 学生テーブルから入学年度とクラス番号で絞り込み
	public List<StudentModel> filterTests(Integer entYear, String classNum){
		return studentRepository.findByEntYearAndClassNum(entYear, classNum);
    }
	/* 成績の登録 */
	public void saveTest(TestModel testModel) {
		testRepository.save(testModel);
	}


	/* 成績参照 */
	
	// 成績一覧表示
	public List<TestModel> getAllTestsBySchoolCd(String schoolCd) {
        return testRepository.findBySchoolCd(schoolCd);
    }
	
	// 成績一覧 学生情報 絞り込み表示
	public List<TestModel> filterTestByStudentNo(String studentNo){
		return testRepository.findByStudentNo(studentNo);
	}
	// 成績一覧 科目情報 絞り込み表示
	public List<TestModel> filterTestStudentNoAndSubjectCd(List<String> studentNos, String subjectCd) {
		return testRepository.findByStudentNoInAndSubjectCd(studentNos, subjectCd);
	}

}






//成績一覧 科目情報 絞り込み表示
	//public List<TestModel> filterTestBySubject(Integer entYear, String classNum, String subjectCd){
	//	return testRepository.findByEntYearAndClassNumAndSubjectCd(entYear, classNum, subjectCd);
	//}