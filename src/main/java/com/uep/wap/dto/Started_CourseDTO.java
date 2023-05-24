package com.uep.wap.dto;

public class Started_CourseDTO {
    private int sc_id;
    private int correctly;
    private int incorrectly;
    private float completion;

    public Started_CourseDTO() {
    }

    public Started_CourseDTO(int sc_id, int correctly, int incorrectly, float completion) {
        this.sc_id = sc_id;
        this.correctly = correctly;
        this.incorrectly = incorrectly;
        this.completion = completion;
    }

    // Getters and Setters
    public int getSc_id() {
        return sc_id;
    }

    public void setSc_id(int sc_id) {
        this.sc_id = sc_id;
    }

    public int getCorrectly() {
        return correctly;
    }

    public void setCorrectly(int correctly) {
        this.correctly = correctly;
    }

    public int getIncorrectly() {
        return incorrectly;
    }

    public void setIncorrectly(int incorrectly) {
        this.incorrectly = incorrectly;
    }

    public float getCompletion() {
        return completion;
    }

    public void setCompletion(float completion) {
        this.completion = completion;
    }
}

