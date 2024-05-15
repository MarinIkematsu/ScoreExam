package jp.ac.ohara.score.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.score.models.SchoolModel;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolModel, Long> {

}
