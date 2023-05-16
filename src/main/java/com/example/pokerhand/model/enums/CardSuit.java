package com.example.pokerhand.model.enums;

public enum CardSuit {
    SPADES("S"),
    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C");

    private final String symbol;

    private CardSuit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static CardSuit fromSymbol(String symbol) {
        for (CardSuit value : CardSuit.values()) {
            if (value.symbol.equals(symbol)) {
                return value;
            }
        }
        return null;
    }
}

