package com.uep.wap.dto;

public class QuestionDTO {
    private int q_id;
    private String type;
    private int sectionId;

    public QuestionDTO() {
    }

    public QuestionDTO(int q_id, String type, int sectionId) {
        this.q_id = q_id;
        this.type = type;
        this.sectionId = sectionId;
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

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }
}

