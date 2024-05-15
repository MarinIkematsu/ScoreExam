package jp.ac.ohara.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.ohara.score.models.ClassModel;
import jp.ac.ohara.score.repository.ClassRepository;

@Service
public class ClassService {
	@Autowired
    private ClassRepository classRepository;
	// ログイン中の教師のschoolCdに一致する全てのクラス番号を取得するメソッド
    public List<ClassModel> getAllClassNumsBySchoolCd(String schoolCd) {
        return classRepository.findBySchoolCd(schoolCd);
    }
    // 生徒追加メソッド
    public void saveClass(ClassModel classModel) {
        classRepository.save(classModel);
    }
}
