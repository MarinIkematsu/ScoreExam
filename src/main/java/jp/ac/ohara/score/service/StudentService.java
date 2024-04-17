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
    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
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
    public List<StudentModel> filterStudents(Integer entYear, String classNum, boolean isAttend) {
    	// if文で絞り込みの種類を増やす
    	
        return studentRepository.findByEntYearAndClassNumAndIsAttend(entYear, classNum, isAttend);
    }
	
}
