package com.vkspark.vkspark_backend.entity;

import com.vkspark.vkspark_backend.enums.UserRole;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(name = "mobile_number")
private String phone;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private Boolean verified;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public User() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.verified = false;
        this.role = UserRole.USER;
    }

    
}