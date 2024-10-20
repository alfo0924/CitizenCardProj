package org.example._citizencardproj.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
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

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column(name = "RegisterDate")
    private LocalDateTime registerDate;

    @Column(name = "LastLoginTime")
    private LocalDateTime lastLoginTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;

    @Column(name = "IsVerified")
    private boolean isVerified;

    @Column(name = "IsActive")
    private boolean isActive;

    public enum Role {
        USER, ADMIN, MODERATOR
    }

    // 添加一個接受 id 的構造函數
    public Member(Long id) {
        this.id = id;
    }

    // 無參數構造函數
    public Member() {}
}