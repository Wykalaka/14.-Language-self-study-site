package com.uep.wap.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int u_id;

    private String first_Name;

    private String last_Name;

    private Date date_of_birth;

    @Column(name = "e_mail")
    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "u_id")
    private List<Started_Course> started_courses;

    // Getters and Setters
    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Started_Course> getStarted_courses() {
        return started_courses;
    }

    public void setStarted_courses(List<Started_Course> started_courses) {
        this.started_courses = started_courses;
    }

    public User( int u_id, String first_Name, String last_Name, Date date_of_birth, String email, String password) {
        this.u_id = u_id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.password = password;
    }

    public User(){

    }
}

