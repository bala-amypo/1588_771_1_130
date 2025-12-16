package com.example.demo.model;

import java.time.LocalDateTime;

public class User {
    private long id;
    private String name;
    private String email;
    private String password;
    private String roles;
    private LocalDateTime createdAt;
    
    public User() {}

    public User(String name,String email,String password,String roles,LocalDateTime createdAt) {
        this.name=name;
        this.email=email;
        this.password=password;
        this.roles=roles;
        this.createdAt=createdAt;
    }
    public long getId(){
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getRoles() {
        return roles;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setId(long id) {
        this.id=id;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public void Password(String password) {
        this.password=password;
    }
    public void setRoles(String roles) {
        this.roles=roles;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt=createdAt;
    }
}
