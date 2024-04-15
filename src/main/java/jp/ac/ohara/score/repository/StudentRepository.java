package jp.ac.ohara.score.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.score.models.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
	// DBから絞り込んで取得
	List<StudentModel> findByEntYearAndClassNumAndIsAttend(Integer entYear, String classNum, boolean isAttend);
}
