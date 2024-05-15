package jp.ac.ohara.score.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.score.models.ClassModel;

@Repository
public interface ClassRepository extends JpaRepository<ClassModel, Long> {
	// DBからクラス番号を取得
	List<ClassModel> findBySchoolCd(String schoolCd);
}
