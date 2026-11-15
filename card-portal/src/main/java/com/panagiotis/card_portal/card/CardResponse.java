package com.panagiotis.card_portal.card;

import java.math.BigDecimal;

public record CardResponse(
    Long id,
    CardBrand brand,
    String maskedNumber,
    String holderName,
    CardType type,
    CardStatus status,
    BigDecimal balance,
    BigDecimal creditLimit
){
    public static CardResponse from(Card card){
        return new CardResponse(
            card.getId(),
            card.getBrand(),
            "**** **** **** " + card.getLast4(),
            card.getHolderName(),
            card.getType(),
            card.getStatus(),
            card.getBalance(),
            card.getCreditLimit() 
        );
    }

}