package com.uep.wap.service;

import com.uep.wap.dto.QuestionDTO;
import com.uep.wap.model.Question;
import com.uep.wap.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void addQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setType(questionDTO.getType());
        questionRepository.save(question);
        System.out.println("Question added!");
    }

    public Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public void updateQuestion(QuestionDTO questionDTO) {
        Question question = questionRepository.findById(questionDTO.getQ_id()).orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + questionDTO.getQ_id()));
        question.setType(questionDTO.getType());
        questionRepository.save(question);
        System.out.println("Question updated!");
    }
}
