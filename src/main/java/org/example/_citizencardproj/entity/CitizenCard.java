package org.example._citizencardproj.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "CitizenCards")
public class CitizenCard {
    @Id
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "MemberID")
    private Member member;

    private String holderName;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    public enum CardType {
        一般卡, 敬老卡, 愛心卡, 學生卡
    }
}