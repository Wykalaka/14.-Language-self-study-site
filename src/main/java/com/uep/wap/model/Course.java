package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int c_id;

    private String language;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Started_Course> startedCourses;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Section> sections;

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

    public List<Started_Course> getStartedCourses() {
        return startedCourses;
    }

    public void setStartedCourses(List<Started_Course> startedCourses) {
        this.startedCourses = startedCourses;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}

