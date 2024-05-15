package jp.ac.ohara.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.ac.ohara.score.models.TeacherModel;
import jp.ac.ohara.score.repository.TeacherRepository;


@Service
public class TeacherService implements UserDetailsService {
	@Autowired
    private TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String teacherId) throws UsernameNotFoundException {
        // 教員IDを受け取り、対応する教員情報をデータベースから取得する
    	//System.out.println("▸service 教員情報取得");
    	//System.out.println("serach id : " + teacherId);
		TeacherModel teacher = teacherRepository.findByTeacherIdEquals(teacherId);
		//System.out.println("▸IDに対応した教員の情報");
		//System.out.println(teacher.toString());
		return teacher;
    }

	public boolean authenticate(String teacherId, String password) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
