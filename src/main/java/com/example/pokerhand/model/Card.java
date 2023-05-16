package com.example.pokerhand.model;

import com.example.pokerhand.model.enums.CardSuit;
import com.example.pokerhand.model.enums.NominalValues;
import lombok.Data;

@Data
public class Card implements Comparable<Card> {
    NominalValues nominal_value;

    CardSuit card_suit;

    public Card(NominalValues nominal, CardSuit suit) {
        this.nominal_value = nominal;
        this.card_suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        return NominalValues.compareValues(this.nominal_value, o.nominal_value);
    }

    @Override
    public String toString() {
        return nominal_value.getSymbol() + card_suit.getSymbol();
    }
}

