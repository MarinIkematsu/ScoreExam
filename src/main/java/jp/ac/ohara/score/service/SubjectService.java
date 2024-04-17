package jp.ac.ohara.score.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.ohara.score.models.SubjectModel;
import jp.ac.ohara.score.repository.SubjectRepository;

@Service
public class SubjectService {
	@Autowired
    private SubjectRepository subjectRepository;
	
	// 科目一覧の取得
	public List<SubjectModel> getAllSubjects() {
        return subjectRepository.findAll();
    }
	// 科目の新規登録
	public void saveSubject(SubjectModel subjectModel) {
        subjectRepository.save(subjectModel);
    }
	// 科目の編集更新
	public void updateSubject(SubjectModel subjectModel) {
        subjectRepository.save(subjectModel);
    }
	// 科目の削除
	public void deleteSubject(SubjectModel subjectModel) {
		subjectRepository.delete(subjectModel);
    }
	// IDを使用した科目の検索
	public SubjectModel getSubjectById(Long id) {
        Optional<SubjectModel> subject = subjectRepository.findById(id);
        return subject.orElse(null);
    }
}
