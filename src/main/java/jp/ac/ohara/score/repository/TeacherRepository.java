package jp.ac.ohara.score.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.score.models.TeacherModel;


@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {
    TeacherModel findByTeacherIdEquals(String teacherId);
}
