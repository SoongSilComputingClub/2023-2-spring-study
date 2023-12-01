package com.server.springtest.domain.dto;

import com.server.springtest.domain.entity.Answer;
import com.server.springtest.domain.entity.Question;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AnswerDTO {

    private Integer id;
    private String content;
    private LocalDateTime createDate;
    // Include only the question ID if that's all you need
    private QuestionDTO questionDTO;

    public AnswerDTO(Answer answer) {
        this.id = answer.getId();
        this.content = answer.getContent();
        this.createDate = answer.getCreateDate();
        this.questionDTO = new QuestionDTO(answer.getQuestion().getId(), answer.getQuestion().getSubject(), answer.getQuestion().getContent(), answer.getQuestion().getCreateDate(), null);
    }

}
