package com.panagiotis.card_portal.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Spring writes the SQL from the method name:
    // "find transactions where card.id = ? order by dateTime newest first"
    List<Transaction> findByCardIdOrderByDateTimeDesc(Long cardId);

}
