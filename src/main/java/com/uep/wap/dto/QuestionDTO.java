package com.uep.wap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuestionDTO {
    private int q_id;
    private String type;
    private String content;
    private int sectionId;
    private List<Integer> answerIds;


    public QuestionDTO() {
    }

    public QuestionDTO(int q_id, String type, String content, int sectionId, List<Integer> answerIds) {
        this.q_id = q_id;
        this.type = type;
        this.content = content;
        this.sectionId = sectionId;
        this.answerIds = answerIds;
    }

    // Getters and Setters
    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
    	return content;
    }

    public void setContent(String content) {
    	this.content = content;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public List<Integer> getAnswerIds() {
    	return answerIds;
    }

    public void setAnswerIds(List<Integer> answerIds) {
    	this.answerIds = answerIds;
    }
}

