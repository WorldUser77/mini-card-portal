package com.panagiotis.card_portal.card;

import com.panagiotis.card_portal.transaction.TransactionRepository;
import com.panagiotis.card_portal.transaction.TransactionResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service   // Spring creates ONE instance of this and manages it
public class CardService {

    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;

    // Constructor injection: Spring passes the repositories in automatically
    public CardService(CardRepository cardRepository,
                       TransactionRepository transactionRepository) {
        this.cardRepository = cardRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional(readOnly = true)
    public List<CardResponse> getAllCards() {
        return cardRepository.findAll()
                .stream()                    // go through each Card...
                .map(CardResponse::from)     // ...turn it into a CardResponse...
                .toList();                   // ...collect into a list
    }

    @Transactional(readOnly = true)
    public List<TransactionResponse> getTransactions(Long cardId) {
        if (!cardRepository.existsById(cardId)) {
            throw new CardNotFoundException(cardId);   // → 404
        }
        return transactionRepository.findByCardIdOrderByDateTimeDesc(cardId)
                .stream()
                .map(TransactionResponse::from)
                .toList();
    }

    @Transactional
    public CardResponse freeze(Long id) {
        Card card = findCard(id);
        card.setStatus(CardStatus.FROZEN);
        return CardResponse.from(cardRepository.save(card));
    }

    @Transactional
    public CardResponse unfreeze(Long id) {
        Card card = findCard(id);
        card.setStatus(CardStatus.ACTIVE);
        return CardResponse.from(cardRepository.save(card));
    }

    private Card findCard(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new CardNotFoundException(id));
    }
}