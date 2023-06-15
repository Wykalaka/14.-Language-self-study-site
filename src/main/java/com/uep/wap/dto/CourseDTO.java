package com.uep.wap.dto;

import java.util.List;

public class CourseDTO {
    private int c_id;
    private String language;
    private List<Integer> startedCourseIds;
    private List<Integer> sectionIds;

    // Getters and Setters
    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Integer> getStartedCourseIds() {
        return startedCourseIds;
    }

    public void setStartedCourseIds(List<Integer> startedCourseIds) {
        this.startedCourseIds = startedCourseIds;
    }

    public List<Integer> getSectionIds() {
        return sectionIds;
    }

    public void setSectionIds(List<Integer> sectionIds) {
        this.sectionIds = sectionIds;
    }
}

