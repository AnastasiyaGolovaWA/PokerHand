package com.example.pokerhand.model.enums;

public enum NominalValues {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private final String symbol;

    private NominalValues(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static NominalValues fromSymbol(String symbol) {
        for (NominalValues value : NominalValues.values()) {
            if (value.symbol.equals(symbol)) {
                return value;
            }
        }
        return null;
    }

    public static int compareValues(NominalValues value1, NominalValues value2) {
        return Integer.compare(value1.ordinal(), value2.ordinal());
    }
}





