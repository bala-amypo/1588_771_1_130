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
    public String email() {
        return email;
    }
    public String password() {
        return password;
    }
    public String getRoles() {
        return roles;
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
    public void setRole(String role) {
        this.roles=roles;
    }
}
