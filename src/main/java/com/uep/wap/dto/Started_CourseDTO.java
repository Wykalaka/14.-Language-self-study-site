package com.uep.wap.dto;

public class Started_CourseDTO {
    private int sc_id;
    private int correctly;
    private int incorrectly;
    private float completion;
    private int u_id;  // User foreign key
    private int c_id;  // Course foreign key

    public Started_CourseDTO() {
    }

    public Started_CourseDTO(int sc_id, int correctly, int incorrectly, float completion, int userId, int courseId) {
        this.sc_id = sc_id;
        this.correctly = correctly;
        this.incorrectly = incorrectly;
        this.completion = completion;
        this.u_id = userId;
        this.c_id = courseId;
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

    public int getUserId() {
        return u_id;
    }

    public void setUserId(int userId) {
        this.u_id = userId;
    }

    public int getCourseId() {
        return c_id;
    }

    public void setCourseId(int courseId) {
        this.c_id = courseId;
    }
}
