package com.uep.wap.service;

import com.uep.wap.dto.AnswerDTO;
import com.uep.wap.model.Answer;
import com.uep.wap.model.Question;
import com.uep.wap.repository.AnswerRepository;
import com.uep.wap.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public void addAnswer(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        answer.setText(answerDTO.getText());
        answer.setCorrect(answerDTO.getIsCorrect());

        Question question = questionRepository.findById(answerDTO.getQuestionId())
                .orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + answerDTO.getQuestionId()));
        answer.setQuestion(question);

        answerRepository.save(answer);
        System.out.println("Answer added!");
    }

    public Iterable<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public Answer getAnswer(Integer id) {
        Answer answer  = answerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Answer not found with id: " + id));
        return answer;
    }

    public void updateAnswer(AnswerDTO answerDTO) {
        Answer answer = answerRepository.findById(answerDTO.getA_id())
                .orElseThrow(() -> new IllegalArgumentException("Answer not found with id: " + answerDTO.getA_id()));
        answer.setText(answerDTO.getText());
        answer.setCorrect(answerDTO.getIsCorrect());

        Question question = questionRepository.findById(answerDTO.getQuestionId())
                .orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + answerDTO.getQuestionId()));
        answer.setQuestion(question);

        answerRepository.save(answer);
        System.out.println("Answer updated!");
    }

    public void deleteAnswer(Integer id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Answer not found with id: " + id));
        answerRepository.delete(answer);
        System.out.println("Answer deleted!");
    }
}
