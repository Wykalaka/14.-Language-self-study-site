package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int s_id;

    private String proficiency;

    @JsonIgnore
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<Question> questions;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "c_id")
    private Course course;

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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}


