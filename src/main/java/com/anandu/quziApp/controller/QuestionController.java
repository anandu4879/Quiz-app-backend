package com.anandu.quziApp.controller;

import com.anandu.quziApp.Questions;
import com.anandu.quziApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allquestion")
    public List<Questions> getAllQuestion(){
        return questionService.getAllQuestion();
    }
}
