// src/main/java/com/example/demo/dto/RegisterRequest.java
package com.example.demo.dto;

import java.util.List;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private List<String> roles;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }
}
