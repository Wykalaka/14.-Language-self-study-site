package com.uep.wap.dto;

public class SectionDTO {
    private int s_id;
    private String proficiency;

    public SectionDTO() {
    }

    public SectionDTO(int s_id, String proficiency) {
        this.s_id = s_id;
        this.proficiency = proficiency;
    }

    // Getters and Setters
    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }
}

