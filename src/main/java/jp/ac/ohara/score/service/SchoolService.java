package jp.ac.ohara.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.ohara.score.repository.SchoolRepository;

@Service
public class SchoolService {
	@Autowired
    private SchoolRepository schoolRepository;
}
