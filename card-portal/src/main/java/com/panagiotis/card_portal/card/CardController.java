package com.panagiotis.card_portal.card;

import com.panagiotis.card_portal.transaction.TransactionResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<CardResponse> getAll() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionResponse> getTransactions(@PathVariable Long id) {
        return cardService.getTransactions(id);
    }

    @PatchMapping("/{id}/freeze")
    public CardResponse freeze(@PathVariable Long id) {
        return cardService.freeze(id);
    }

    @PatchMapping("/{id}/unfreeze")
    public CardResponse unfreeze(@PathVariable Long id) {
        return cardService.unfreeze(id);
    }

}
