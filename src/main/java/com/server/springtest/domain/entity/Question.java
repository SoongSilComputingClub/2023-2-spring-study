package com.server.springtest.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.server.springtest.domain.dto.QuestionDTO;
import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @Column(length = 200)
    @JsonProperty("subject")
    private String subject;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("content")
    private String content;

    @JsonProperty("createDate")
    private LocalDateTime createDate;

    @JsonProperty("answerList")
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    public void update(Question q){
        this.id = q.getId();
        this.subject = q.getSubject();
        this.content = q.getContent();
        this.createDate = q.getCreateDate();
        this.answerList = q.getAnswerList();
    }


}

