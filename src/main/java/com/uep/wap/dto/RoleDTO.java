package com.uep.wap.dto;

public class RoleDTO {
    private int r_id;
    private String r_name;

    public RoleDTO() {
    }

    public RoleDTO(int r_id, String r_name) {
        this.r_id = r_id;
        this.r_name = r_name;
    }

    // Getters and Setters
    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }
}

