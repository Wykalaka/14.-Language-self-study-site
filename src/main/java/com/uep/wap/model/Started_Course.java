package com.uep.wap.model;

import javax.persistence.*;

@Entity
public class Started_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sc_id;

    private int correctly;

    private int incorrectly;

    private float completion;

    @ManyToOne
    @JoinColumn(name = "c_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


