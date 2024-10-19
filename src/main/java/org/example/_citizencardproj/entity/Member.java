package org.example._citizencardproj.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MemberID")
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(length = 20)
    private String phone;

    @Column(name = "RegisterDate")
    private LocalDateTime registerDate;

    @Column(name = "LastLoginTime")
    private LocalDateTime lastLoginTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;

    // Additional fields that might be useful
    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column(length = 255)
    private String address;

    @Column(name = "IsVerified")
    private boolean isVerified;

    @Column(name = "IsActive")
    private boolean isActive;

    // Enum for Role
    public enum Role {
        USER, ADMIN, MODERATOR
    }

    @PrePersist
    protected void onCreate() {
        registerDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastLoginTime = LocalDateTime.now();
    }
}