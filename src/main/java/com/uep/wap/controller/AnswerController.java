package com.uep.wap.controller;

import com.uep.wap.dto.AnswerDTO;
import com.uep.wap.model.Answer;
import com.uep.wap.service.AnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/answer")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public String addAnswer(@RequestBody AnswerDTO answerDTO) {
        answerService.addAnswer(answerDTO);
        return "Answer added!";
    }

    @GetMapping
    public Iterable<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping(path = "/{id}")
    public Answer getAnswerById(@PathVariable("id") Integer id) {
        return answerService.getAnswer(id);
    }

    @PutMapping(path = "/{id}")
    public String updateAnswer(@PathVariable("id") Integer id, @RequestBody AnswerDTO answerDTO) {
        answerDTO.setA_id(id);
        answerService.updateAnswer(answerDTO);
        return "Answer updated!";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteAnswer(@PathVariable("id") Integer id) {
        answerService.deleteAnswer(id);
        return "Answer deleted!";
    }
}
