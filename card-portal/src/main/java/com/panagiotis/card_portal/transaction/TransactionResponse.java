package com.panagiotis.card_portal.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
        Long id,
        String merchant,
        BigDecimal amount,
        String currency,
        LocalDateTime dateTime,
        TransactionStatus status,
        boolean disputed
) {
    public static TransactionResponse from(Transaction t) {
        return new TransactionResponse(
                t.getId(),
                t.getMerchant(),
                t.getAmount(),
                t.getCurrency(),
                t.getDateTime(),
                t.getStatus(),
                t.isDisputed()
        );
    }
}