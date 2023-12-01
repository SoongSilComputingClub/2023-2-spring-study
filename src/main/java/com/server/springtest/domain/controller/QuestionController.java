package com.server.springtest.domain.controller;

import com.server.springtest.domain.dto.QuestionDTO;
import com.server.springtest.domain.entity.Question;
import com.server.springtest.domain.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/question")
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true") // Replace the wildcard
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/sbb")
    public String index(){
        return "index";
    }

    @GetMapping("/list")
    public ResponseEntity<List<QuestionDTO>> list() {
        List<QuestionDTO> questionList = questionService.getList();
        System.out.println("questionList"+questionList);
        return ResponseEntity.ok().body(questionList);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Integer id) {
        Question question = questionService.getQuestion(id);
        return ResponseEntity.ok(question);
    }
}
