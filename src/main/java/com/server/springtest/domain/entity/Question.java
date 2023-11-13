package com.server.springtest.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    public void update(Question q){
        this.id = q.getId();
        this.subject = q.getSubject();
        this.content = q.getContent();
        this.createDate = q.getCreateDate();
        this.answerList = q.getAnswerList();
    }

    @Builder
    public Question(Integer id, String subject, String content, LocalDateTime createDate, List<Answer> answerList){
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.createDate = createDate;
        this.answerList = answerList;
    }
}

