package com.anandu.quziApp.controller;

import com.anandu.quziApp.model.QuestionWraper;
import com.anandu.quziApp.model.Response;
import com.anandu.quziApp.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizeService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizeService.createQuiz(category, numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWraper>> getQuizQuestion(@PathVariable Integer id){
        return quizeService.getQuizebyid(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response)
    {
        return quizeService.calculateResult(id,response);
    }
}

