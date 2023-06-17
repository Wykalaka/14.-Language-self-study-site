package com.uep.wap.service;

import com.uep.wap.dto.QuestionDTO;
import com.uep.wap.model.Answer;
import com.uep.wap.model.Question;
import com.uep.wap.model.Section;
import com.uep.wap.repository.AnswerRepository;
import com.uep.wap.repository.QuestionRepository;
import com.uep.wap.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public void addQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setType(questionDTO.getType());
        question.setContent(questionDTO.getContent());

        Section section = sectionRepository.findById(questionDTO.getSectionId())
                .orElseThrow(() -> new IllegalArgumentException("Section not found with id: " + questionDTO.getSectionId()));
        question.setSection(section);

        /*List<Answer> answers = questionDTO.getAnswerIds().stream()
                .map(id -> answerRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Answer not found with id: " + id)))
                .collect(Collectors.toList());
        question.setAnswers(answers);*/

        questionRepository.save(question);
        System.out.println("Question added!");
    }

    public Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Question question  = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + id));
        return question;
    }

    public void updateQuestion(QuestionDTO questionDTO) {
        Question question = questionRepository.findById(questionDTO.getQ_id())
                .orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + questionDTO.getQ_id()));
        question.setType(questionDTO.getType());
        question.setContent(questionDTO.getContent());

        Section section = sectionRepository.findById(questionDTO.getSectionId())
                .orElseThrow(() -> new IllegalArgumentException("Section not found with id: " + questionDTO.getSectionId()));
        question.setSection(section);

        List<Answer> answers = questionDTO.getAnswerIds().stream()
                .map(id -> answerRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Answer not found with id: " + id)))
                .collect(Collectors.toList());
        question.setAnswers(answers);

        questionRepository.save(question);
        System.out.println("Question updated!");
    }

    public void deleteQuestion(Integer id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + id));
        questionRepository.delete(question);
        System.out.println("Question deleted!");
    }


}
