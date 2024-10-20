package org.example._citizencardproj.controller;

import org.example._citizencardproj.entity.Wallet;
import org.example._citizencardproj.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<Wallet> createWallet(@RequestParam Long memberId) {
        Wallet wallet = walletService.createWallet(memberId);
        return ResponseEntity.ok(wallet);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Wallet> getWallet(@PathVariable Long memberId) {
        Wallet wallet = walletService.getWalletByMemberId(memberId);
        if (wallet != null) {
            return ResponseEntity.ok(wallet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{memberId}/add")
    public ResponseEntity<Wallet> addBalance(@PathVariable Long memberId, @RequestParam BigDecimal amount) {
        Wallet wallet = walletService.addBalance(memberId, amount);
        if (wallet != null) {
            return ResponseEntity.ok(wallet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{memberId}/subtract")
    public ResponseEntity<Wallet> subtractBalance(@PathVariable Long memberId, @RequestParam BigDecimal amount) {
        Wallet wallet = walletService.subtractBalance(memberId, amount);
        if (wallet != null) {
            return ResponseEntity.ok(wallet);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}