package com.server.springtest.domain.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.server.springtest.domain.dto.AnswerDTO;
import jakarta.persistence.*;

import lombok.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("content")
    private String content;

    @JsonProperty("createDate")
    private LocalDateTime createDate;

    @JsonProperty("question")
    @JsonIgnore
    @ManyToOne
    private Question question;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createDate=" + createDate;
    }

}