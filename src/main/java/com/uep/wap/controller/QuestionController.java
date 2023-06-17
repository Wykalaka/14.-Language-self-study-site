package com.uep.wap.controller;

import com.uep.wap.service.QuestionService;
import com.uep.wap.dto.QuestionDTO;
import com.uep.wap.model.Question;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public String addQuestion(@RequestBody QuestionDTO questionDTO) {
        questionService.addQuestion(questionDTO);
        return "Question added!";
    }

    @GetMapping
    public Iterable<com.uep.wap.model.Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping(path = "/{id}")
    public Question getQuestionById(@PathVariable("id") Integer id) {
        return questionService.getQuestion(id);
    }

    @PutMapping(path = "/{id}")
    public String updateQuestion(@PathVariable("id") Integer id, @RequestBody QuestionDTO questionDTO) {
        questionDTO.setQ_id(id);
        questionService.updateQuestion(questionDTO);
        return "Question updated!";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteQuestion(@PathVariable("id") Integer id) {
        questionService.deleteQuestion(id);
        return "Question deleted!";
    }


}
