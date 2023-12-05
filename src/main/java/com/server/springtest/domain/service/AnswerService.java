package com.server.springtest.domain.service;

import com.server.springtest.domain.entity.Answer;
import com.server.springtest.domain.entity.Question;
import com.server.springtest.domain.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = Answer.builder()
                .question(question)
                .content(content)
                .build();

        answerRepository.save(answer);
    }
}
