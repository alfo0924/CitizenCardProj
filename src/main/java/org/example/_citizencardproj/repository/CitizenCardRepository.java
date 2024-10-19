package org.example._citizencardproj.repository;

import org.example._citizencardproj.entity.CitizenCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenCardRepository extends JpaRepository<CitizenCard, String> {
    CitizenCard findByMemberMemberID(Long memberID);
}