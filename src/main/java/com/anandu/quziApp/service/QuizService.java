package com.anandu.quziApp.service;

import com.anandu.quziApp.dao.QuestionDao;
import com.anandu.quziApp.dao.QuizDao;
import com.anandu.quziApp.model.QuestionWraper;
import com.anandu.quziApp.model.Questions;
import com.anandu.quziApp.model.Quiz;
import com.anandu.quziApp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Questions> questions=questionDao.findRandomQuestionByCategory(category, numQ);
        Quiz quiz =new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWraper>> getQuizebyid(Integer id) {
        Optional<Quiz> quiz= quizDao.findById(id);
        List<Questions> questionfromDB=quiz.get().getQuestions();
        List<QuestionWraper> questionforuser=new ArrayList<>();
        for (Questions q:questionfromDB)
        {
            QuestionWraper qw=new QuestionWraper(q.getId(), q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionforuser.add(qw);
        }
        return new ResponseEntity<>(questionforuser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz=quizDao.findById(id).get();
        List<Questions> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for (Response response :responses)
        {
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }

}
