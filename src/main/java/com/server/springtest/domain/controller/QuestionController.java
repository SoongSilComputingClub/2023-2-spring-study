package com.server.springtest.domain.controller;

import com.server.springtest.domain.dto.QuestionDTO;
import com.server.springtest.domain.entity.Question;
import com.server.springtest.domain.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public ResponseEntity<Map<String,Object>> list() {
        List<QuestionDTO> questionList = questionService.getList();

        List<Map<String, Object>> simplifiedQuestionList = questionList.stream().map(question -> {
            Map<String, Object> questionMap = new HashMap<>();
            questionMap.put("id", question.getId());
            questionMap.put("subject", question.getSubject());
            questionMap.put("content", question.getContent());
            questionMap.put("createDate", question.getCreateDate());
            return questionMap;
        }).collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("questions", new ArrayList<>(simplifiedQuestionList));

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Integer id) {
        Question question = questionService.getQuestion(id);
        System.out.println(question);
        return ResponseEntity.ok(question);
    }
}
