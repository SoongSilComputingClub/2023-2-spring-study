package com.server.springtest;

import com.server.springtest.domain.entity.Answer;
import com.server.springtest.domain.entity.Question;
import com.server.springtest.domain.repository.AnswerRepository;
import com.server.springtest.domain.repository.QuestionRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SsccSpringApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void testJpa(){

		// insert data
//		Question q1 = Question.builder()
//				.subject("sbb가 무엇인가요?")
//				.content("sbb에 대해서 알고 싶습니다.")
//				.createDate(LocalDateTime.now())
//				.build();
//		questionRepository.save(q1);
//
//		Question q2 = Question.builder()
//				.subject("스프링부트 모델 질문입니다.")
//				.content("id는 자동으로 생성되나요?")
//				.createDate(LocalDateTime.now())
//				.build();
//		questionRepository.save(q2);

		// equal
//		List<Question> all = this.questionRepository.findAll();
//		// 동일한지 조사하는 JUnit의 euql method
//		assertEquals(2, all.size());
//
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());

		// findById
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()){
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}

		// findBySubject
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1,q.getId());

		// and or between...
//		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다");
//		assertEquals(1, q.getId());

		// 표현식..
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());

		// builder update..이게맞나
//		Optional<Question> oq = this.questionRepository.findById(10);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Question uq = Question.builder()
//				.id(q.getId())
//				.subject("수정된 제목")
//				.content(q.getContent())
//				.createDate(q.getCreateDate())
//				.answerList(q.getAnswerList())
//				.build();
//		q.update(uq);
//		questionRepository.save(uq);

//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(10);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());

//		Optional<Question> oq = this.questionRepository.findById(11);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = Answer.builder()
//				.content("네 자동으로 생성됩니다.")
//				.question(q)
//				.createDate(LocalDateTime.now())
//				.build();
//		this.answerRepository.save(a);

//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(11, a.getQuestion().getId());

		Optional<Question> oq = this.questionRepository.findById(11);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}

}
