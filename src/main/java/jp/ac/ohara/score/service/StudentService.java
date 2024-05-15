package jp.ac.ohara.score.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.ohara.score.models.StudentModel;
import jp.ac.ohara.score.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
    private StudentRepository studentRepository;
	
	// 全生徒取得メソッド
    //public List<StudentModel> getAllStudents() {
    //    return studentRepository.findAll();
    //}
	// 学校コードに一致する学生情報を取得するメソッド
    public List<StudentModel> getAllStudentsBySchoolCd(String schoolCd) {
        return studentRepository.findBySchoolCd(schoolCd);
    }
    
	// 生徒追加メソッド
    public void saveStudent(StudentModel studentModel) {
        studentRepository.save(studentModel);
    }
    
    // 生徒情報変更メソッド
    public void updateStudent(StudentModel studentModel) {
    	if(studentModel.getIsAttend() == null) {
    		studentModel.setIsAttend(false);
    	}
        studentRepository.save(studentModel);
    }
    
    // 生徒削除メソッド
    public void daleteStudent(StudentModel studentModel) {
        studentRepository.delete(studentModel);
    }

    // 生徒IDで生徒情報を取得するメソッド
    public StudentModel getStudentById(Long id) {
        Optional<StudentModel> student = studentRepository.findById(id);
        return student.orElse(null);
    }
    
    // 学生絞り込み表示メソッド(入学年度・クラス・在学中フラグ)
    public List<StudentModel> filterStudents(Integer entYear, String classNum, Boolean isAttend) {
    	// if文で絞り込みの種類を増やす
    	List<StudentModel> students = studentRepository.findAll();
    	// 入学年度で絞り込み
        if (entYear != null) {
            students = studentRepository.findByEntYear(entYear);
        }
 
        // クラス番号で絞り込み
        if (classNum != null && !classNum.isEmpty()) {
            List<StudentModel> classNumStudents = studentRepository.findByClassNum(classNum);
            students.retainAll(classNumStudents);
        }
 
        // 在学状況で絞り込み
        if (isAttend != null) {
            List<StudentModel> isAttendStudents = studentRepository.findByIsAttend(isAttend);
            students.retainAll(isAttendStudents);
        }
    	
        return students;
    }
    public List<StudentModel> findByEntYearAndClassNum(Integer entYear, String classNum){
    	return studentRepository.findByEntYearAndClassNum(entYear,classNum);
    }

	public StudentModel getStudentByStudentNo(String studentNo) {
		return studentRepository.findByStudentNo(studentNo);
	}
}
