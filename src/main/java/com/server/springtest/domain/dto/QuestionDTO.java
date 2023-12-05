package com.server.springtest.domain.dto;

import com.server.springtest.domain.entity.Question;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class QuestionDTO {
    private Integer id;
    private String subject;
    private String content;
    private LocalDateTime createDate;
    // You can choose to include a list of AnswerDTOs or just their IDs, based on your requirements
    private List<AnswerDTO> answerList;

    public QuestionDTO(Question question) {
        this.id = question.getId();
        this.subject = question.getSubject();
        this.content = question.getContent();
        this.createDate = question.getCreateDate();
        this.answerList = question.getAnswerList().stream()
                .map(AnswerDTO::new)
                .collect(Collectors.toList());
    }

}
