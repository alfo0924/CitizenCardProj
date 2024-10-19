package org.example._citizencardproj.dto;

import lombok.Data;
import org.example._citizencardproj.entity.Member;

import java.time.LocalDateTime;

@Data
public class MemberDTO {
    private Long id;
    private String email;
    private String password;
    private String phone;
    private String firstName;
    private String lastName;
    private LocalDateTime registerDate;
    private LocalDateTime lastLoginTime;
    private Member.Role role;
    private boolean isVerified;
    private boolean isActive;
}