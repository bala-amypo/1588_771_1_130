package com.example.demo.model;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    @Builder.Default
    private Set<String> roles = new HashSet<>();
}
