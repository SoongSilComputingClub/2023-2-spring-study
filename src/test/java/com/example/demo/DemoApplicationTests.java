package com.example.demo;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해 알고싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1); // 첫 번째 질문 저장
	}

}
