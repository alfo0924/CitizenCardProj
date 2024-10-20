package org.example._citizencardproj.service;

import org.example._citizencardproj.entity.Member;
import org.example._citizencardproj.entity.Wallet;
import org.example._citizencardproj.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(Long memberId) {
        Wallet wallet = new Wallet();
        wallet.setMember(new Member(memberId));
        wallet.setBalance(BigDecimal.ZERO);
        return walletRepository.save(wallet);
    }

    public Wallet getWalletByMemberId(Long memberId) {
        return walletRepository.findByMemberId(memberId);
    }

    public Wallet addBalance(Long memberId, BigDecimal amount) {
        Wallet wallet = getWalletByMemberId(memberId);
        if (wallet != null) {
            wallet.setBalance(wallet.getBalance().add(amount));
            return walletRepository.save(wallet);
        }
        return null;
    }

    public Wallet subtractBalance(Long memberId, BigDecimal amount) {
        Wallet wallet = getWalletByMemberId(memberId);
        if (wallet != null && wallet.getBalance().compareTo(amount) >= 0) {
            wallet.setBalance(wallet.getBalance().subtract(amount));
            return walletRepository.save(wallet);
        }
        return null;
    }
}