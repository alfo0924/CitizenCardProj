package org.example._citizencardproj.repository;

import org.example._citizencardproj.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByMemberMemberID(Long memberID);
}