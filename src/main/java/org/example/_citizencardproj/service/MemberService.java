package org.example._citizencardproj.service;

import org.example._citizencardproj.dto.MemberDTO;
import org.example._citizencardproj.entity.Member;
import org.example._citizencardproj.exception.ResourceNotFoundException;
import org.example._citizencardproj.exception.ResourceAlreadyExistsException;
import org.example._citizencardproj.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public MemberDTO createMember(MemberDTO memberDTO) {
        if (memberRepository.existsByEmail(memberDTO.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already in use");
        }

        Member member = new Member();
        member.setEmail(memberDTO.getEmail());
        member.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        member.setPhone(memberDTO.getPhone());
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        member.setRegisterDate(LocalDateTime.now());
        member.setRole(Member.Role.USER);
        member.setVerified(false);
        member.setActive(true);

        Member savedMember = memberRepository.save(member);
        return convertToDTO(savedMember);
    }

    public MemberDTO getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));
        return convertToDTO(member);
    }

    public MemberDTO getMemberByEmail(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with email: " + email));
        return convertToDTO(member);
    }

    public List<MemberDTO> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public MemberDTO updateMember(Long id, MemberDTO memberDTO) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));

        member.setPhone(memberDTO.getPhone());
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        // Update other fields as necessary, but not email or password here

        Member updatedMember = memberRepository.save(member);
        return convertToDTO(updatedMember);
    }

    @Transactional
    public void deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            throw new ResourceNotFoundException("Member not found with id: " + id);
        }
        memberRepository.deleteById(id);
    }

    @Transactional
    public MemberDTO verifyMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));
        member.setVerified(true);
        Member verifiedMember = memberRepository.save(member);
        return convertToDTO(verifiedMember);
    }

    public List<MemberDTO> searchMembers(String keyword) {
        return memberRepository.searchMembers(keyword).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateLastLoginTime(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));
        member.setLastLoginTime(LocalDateTime.now());
        memberRepository.save(member);
    }

    private MemberDTO convertToDTO(Member member) {
        MemberDTO dto = new MemberDTO();
        dto.setId(member.getId());
        dto.setEmail(member.getEmail());
        dto.setPhone(member.getPhone());
        dto.setFirstName(member.getFirstName());
        dto.setLastName(member.getLastName());
        dto.setRegisterDate(member.getRegisterDate());
        dto.setLastLoginTime(member.getLastLoginTime());
        dto.setRole(member.getRole());
        dto.setVerified(member.isVerified());
        dto.setActive(member.isActive());
        // Do not set password in DTO for security reasons
        return dto;
    }
}