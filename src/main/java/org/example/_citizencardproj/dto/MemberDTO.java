package org.example._citizencardproj.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
    private Long id;
    private String email;
    private String phone;
    private String username;
    private String password; // Note: Be cautious with password handling
    private String firstName;
    private String lastName;
    private String nationalId; // National ID number
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private boolean isVerified;
    private String membershipType; // e.g., "STANDARD", "PREMIUM"
    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginDate;
    private String profileImageUrl;
    private boolean isActive;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String occupation;
    private String employerName;
    private String educationLevel;
    private String preferredLanguage;
    private boolean newsletterSubscription;
    private String cardNumber; // CitizenCard number
    private LocalDate cardExpiryDate;
    private Double walletBalance;
}