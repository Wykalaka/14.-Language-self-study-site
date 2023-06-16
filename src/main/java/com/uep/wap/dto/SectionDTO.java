package com.uep.wap.dto;

public class SectionDTO {
    private int s_id;
    private String proficiency;

    private int c_id;


    public SectionDTO(int s_id, String proficiency, int c_id) {
        this.s_id = s_id;
        this.proficiency = proficiency;
        this.c_id = c_id;
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

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
}

