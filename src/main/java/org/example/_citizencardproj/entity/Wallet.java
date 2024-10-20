package org.example._citizencardproj.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WalletID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "MemberID", unique = true)
    private Member member;

    @Column(name = "Balance")
    private BigDecimal balance;
}