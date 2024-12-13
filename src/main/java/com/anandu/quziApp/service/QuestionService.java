package com.anandu.quziApp.service;

import com.anandu.quziApp.Questions;
import com.anandu.quziApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Questions> getAllQuestion() {
        return questionDao.findAll();
    }

    public List<Questions> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }
}
