package com.server.springtest;

import com.server.springtest.domain.entity.Question;
import com.server.springtest.domain.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class dbTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @Transactional
    void testJpa() {
        Question q1 = Question.builder()
                .subject("222sbb가 무엇인가요?")
                .content("222sbb에 대해서 알고 싶습니다.")
                .createDate(LocalDateTime.now())
                .build();
        questionRepository.save(q1);

        Question q2 = Question.builder()
                .subject("222스프링부트 모델 질문입니다.")
                .content("222id는 자동으로 생성되나요?")
                .createDate(LocalDateTime.now())
                .build();
        questionRepository.save(q2);
    }

}
