package com.anandu.quziApp.dao;

import com.anandu.quziApp.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {

}
