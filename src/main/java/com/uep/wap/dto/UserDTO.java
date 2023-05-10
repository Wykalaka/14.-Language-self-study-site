package com.uep.wap.dto;

import java.util.Date;

public class UserDTO {

    private int u_id;
    private String first_Name;
    private String last_Name;
    private Date date_of_birth;
    private String e_mail;

    // Constructors
    public UserDTO() {
    }

    public UserDTO(int u_id, String first_Name, String last_Name, Date date_of_birth, String e_mail) {
        this.u_id = u_id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.date_of_birth = date_of_birth;
        this.e_mail = e_mail;
    }

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

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
}