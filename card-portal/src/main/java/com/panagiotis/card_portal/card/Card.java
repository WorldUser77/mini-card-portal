package com.panagiotis.card_portal.card;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name="Cards")
@Getter @Setter

public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardBrand brand;

    @Column(nullable = false, length = 4)
    private String last4;

    @Column(nullable = false)
    private String holderName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardStatus status;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal balance; // money = BigDecimal, never double

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal creditLimit;
}
