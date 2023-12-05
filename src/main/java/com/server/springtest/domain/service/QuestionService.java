package com.server.springtest.domain.service;

import com.server.springtest.domain.DataNotFoundException;
import com.server.springtest.domain.dto.QuestionDTO;
import com.server.springtest.domain.entity.Question;
import com.server.springtest.domain.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    public List<QuestionDTO> getList(){
        // db에서 데이터를 가져와서 dto로 변환
        List<Question> questionList = questionRepository.findAll();

        return questionList.stream()
                .map(QuestionDTO::new) // Using the constructor for conversion
                .collect(Collectors.toList());
    }

    public Question getQuestion(Integer id){
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else{
            throw new DataNotFoundException("Question data not found");
        }
    }

}
