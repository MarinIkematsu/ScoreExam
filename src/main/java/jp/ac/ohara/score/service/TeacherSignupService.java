package jp.ac.ohara.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jp.ac.ohara.score.models.TeacherModel;
import jp.ac.ohara.score.repository.TeacherRepository;



@Service
public class TeacherSignupService {
	@Autowired
	private TeacherRepository teacherRepository; // ユーザモデルのRepository
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public void signupTeacher(TeacherModel teacherModel) {
        TeacherModel teacher = new TeacherModel();
        teacher.setTeacherId(teacherModel.getTeacherId());
        teacher.setPassword(passwordEncoder.encode(teacherModel.getPassword()));
        teacher.setSchoolCd(teacherModel.getSchoolCd());
        teacher.setTeacherName(teacherModel.getTeacherName());
        System.out.println("hashpass:" + teacher.getPassword());
        System.out.println("teacher_id:" + teacher.getTeacherId());
        System.out.println("school_cd:" + teacher.getSchoolCd());
        System.out.println("name:" + teacher.getTeacherName());
        System.out.println(teacher.getUsername());
        teacherRepository.save(teacher);
    }
}
