package com.example.pokerhand.model;

import com.example.pokerhand.model.enums.CardSuit;
import com.example.pokerhand.model.enums.NominalValues;
import com.example.pokerhand.service.CombinationService;

import java.util.ArrayList;
import java.util.List;


public class PokerHand implements Comparable<PokerHand> {

    private List<Card> cards;


    public PokerHand(String handString) {
        cards = new ArrayList<>();
        String[] cardStrings = handString.split(" ");
        if (cardStrings.length != 5) {
            throw new IllegalArgumentException("Incorrect hand format, 5 elements need to be entered.");
        }
        for (String cardString : cardStrings) {
            if (cardString.length() != 2) {
                throw new IllegalArgumentException("Incorrect card format, must be 2 symbols: " + cardString);
            }
            String nominalValueString = cardString.substring(0, 1);
            String suitValueString = cardString.substring(1, 2);
            NominalValues nominalValue = NominalValues.fromSymbol(nominalValueString);
            CardSuit suitValue = CardSuit.fromSymbol(suitValueString);
            if (nominalValue != null && suitValue != null) {
                cards.add(new Card(nominalValue, suitValue));
            } else {
                throw new IllegalArgumentException("There are no cards of this format: " + cardString);
            }
        }
    }

    public List<Card> getHands() {
        List<Card> hands = new ArrayList<>();
        for (Card card : cards) {
            hands.add(card);
        }
        return hands;
    }

    @Override
    public int compareTo(PokerHand o) {
        return Integer.compare(CombinationService.getHandRank(cards), CombinationService.getHandRank(o.cards));
    }
}
