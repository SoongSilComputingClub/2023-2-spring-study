package com.server.springtest.domain.controller;

import com.server.springtest.domain.entity.Question;
import com.server.springtest.domain.service.AnswerService;
import com.server.springtest.domain.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public ResponseEntity<?> createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        Question question = questionService.getQuestion(id);
        answerService.create(question, content);
        return ResponseEntity.ok(question);
    }
}