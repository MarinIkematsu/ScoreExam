package jp.ac.ohara.score.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.score.models.SubjectModel;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectModel, Long> {
	// 学校コードに一致する科目情報を取得するメソッドの定義
    List<SubjectModel> findBySchoolCd(String schoolCd);

    // SubjectCdに一致する科目情報の取得
	SubjectModel findBySubjectCd(String subjectCd);
}
