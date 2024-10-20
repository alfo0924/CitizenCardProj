package org.example._citizencardproj.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "CitizenCards")
public class CitizenCard {
    @Id
    @Column(name = "CardNumber")
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "MemberID")
    private Member member;

    @Column(name = "HolderName")
    private String holderName;

    @Enumerated(EnumType.STRING)
    @Column(name = "CardType")
    private CardType cardType;

    public enum CardType {
        一般卡, 敬老卡, 愛心卡, 學生卡
    }
}