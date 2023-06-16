package com.uep.wap.dto;

public class AnswerDTO {
    private int a_id;
    private String text;
    private boolean isCorrect;
    private int questionId;


    public AnswerDTO(int a_id, String text, boolean isCorrect, int questionId) {
        this.a_id = a_id;
        this.text = text;
        this.isCorrect = isCorrect;
        this.questionId = questionId;
    }

    // Getters and Setters
    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
    	this.text = text;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
    	this.isCorrect = isCorrect;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
    	this.questionId = questionId;
    }

}
