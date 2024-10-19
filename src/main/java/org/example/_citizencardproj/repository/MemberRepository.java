package org.example._citizencardproj.repository;

import org.example._citizencardproj.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    Optional<Member> findByPhone(String phone);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    List<Member> findByLastLoginTimeBefore(LocalDateTime date);

    List<Member> findByIsVerifiedFalse();

    @Query("SELECT m FROM Member m WHERE m.role = :role")
    List<Member> findByRole(@Param("role") Member.Role role);

    @Query("SELECT m FROM Member m WHERE m.firstName LIKE %:keyword% OR m.lastName LIKE %:keyword% OR m.email LIKE %:keyword%")
    List<Member> searchMembers(@Param("keyword") String keyword);

    @Query("SELECT COUNT(m) FROM Member m WHERE m.registerDate >= :startDate AND m.registerDate <= :endDate")
    long countMembersRegisteredBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query(value = "SELECT * FROM Members ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Member> findRandomMembers(@Param("limit") int limit);
}