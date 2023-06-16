package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int q_id;

    private String type;

    private String content;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "s_id")
    private Section section;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
    	this.content = content;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }


    public List<Answer> getAnswers() {
    	return answers;
    }

    public void setAnswers(List<Answer> answers) {
    	this.answers = answers;
    }

}
