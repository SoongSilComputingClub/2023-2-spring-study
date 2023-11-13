package com.server.springtest.domain.repository;

import com.server.springtest.domain.entity.Answer;
import com.server.springtest.domain.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
