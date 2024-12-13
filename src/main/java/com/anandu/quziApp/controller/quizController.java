package com.anandu.quziApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("questions")
public class quizController {

    @GetMapping("allquestion")
    public String getallquestion(){
        return questionservice.getall
    }
}
