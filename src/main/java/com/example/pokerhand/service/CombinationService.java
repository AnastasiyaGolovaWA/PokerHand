package com.example.pokerhand.service;

import com.example.pokerhand.model.Card;

import java.util.*;

public class CombinationService {
    public static final int ROYAL_FLUSH = 9;
    public static final int STRAIGHT_FLUSH = 8;
    public static final int FOUR_OF_A_KIND = 7;
    public static final int FULL_HOUSE = 6;
    public static final int FLUSH = 5;
    public static final int STRAIGHT = 4;
    public static final int THREE_OF_A_KIND = 3;
    public static final int TWO_PAIR = 2;
    public static final int ONE_PAIR = 1;
    public static final int HIGH_CARD = 0;

    public static int getHandRank(List<Card> hands) {
        if (isRoyalFlush(hands)) return ROYAL_FLUSH;
        if (isStraightFlush(hands)) return STRAIGHT_FLUSH;
        if (isFourOfAKind(hands)) return FOUR_OF_A_KIND;
        if (isFullHouse(hands)) return FULL_HOUSE;
        if (isFlush(hands)) return FLUSH;
        if (isStraight(hands)) return STRAIGHT;
        if (isThreeOfAKind(hands)) return THREE_OF_A_KIND;
        if (isTwoPair(hands)) return TWO_PAIR;
        if (isOnePair(hands)) return ONE_PAIR;
        return HIGH_CARD;
    }

    public static boolean isRoyalFlush(List<Card> hands) {
        String[] royalFlushOrder = {"ACE", "KING", "QUEEN", "JACK", "TEN"};
        String suit = String.valueOf(hands.get(0).getCard_suit());
        for (int i = 0; i < hands.size(); i++) {
            String nominal = String.valueOf(hands.get(i).getNominal_value());
            if (!nominal.equals(royalFlushOrder[i]) && Objects.equals(String.valueOf(hands.get(i).getCard_suit()), suit)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFullHouse(List<Card> hands) {
        Map<String, Integer> nominalCount = new HashMap<>();
        Set<String> uniqueRanks = new HashSet<>();

        for (Card card : hands) {
            String nominal = String.valueOf(card.getNominal_value());
            nominalCount.put(nominal, nominalCount.getOrDefault(nominal, 0) + 1);
            uniqueRanks.add(nominal);
        }

        if (uniqueRanks.size() != 2) {
            return false;
        }

        for (int count : nominalCount.values()) {
            if (count != 2 && count != 3) {
                return false;
            }
        }

        return true;
    }

    public static boolean isThreeOfAKind(List<Card> hands) {
        Map<String, Integer> nominalCounts = new HashMap<>();

        for (Card card : hands) {
            String nominal = String.valueOf(card.getNominal_value());
            nominalCounts.put(nominal, nominalCounts.getOrDefault(nominal, 0) + 1);
        }

        int countThreeOfAKind = 0;
        int countPairs = 0;

        for (int count : nominalCounts.values()) {
            if (count == 3) {
                countThreeOfAKind++;
            } else if (count == 2) {
                countPairs++;
            }
        }

        return countThreeOfAKind == 1 && countPairs == 0;
    }

    public static boolean isTwoPair(List<Card> hands) {
        Map<String, Integer> nominalCounts = new HashMap<>();

        for (Card card : hands) {
            String nominal = String.valueOf(card.getNominal_value());
            nominalCounts.put(nominal, nominalCounts.getOrDefault(nominal, 0) + 1);
        }

        int pairCount = 0;

        for (int count : nominalCounts.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    public static boolean isOnePair(List<Card> hands) {
        Set<String> uniqueNominals = new HashSet<>();
        Set<String> pairNominals = new HashSet<>();

        for (Card card : hands) {
            String nominal = String.valueOf(card.getNominal_value());

            if (uniqueNominals.contains(nominal)) {
                pairNominals.add(nominal);
            } else {
                uniqueNominals.add(nominal);
            }
        }
        return pairNominals.size() == 1 && uniqueNominals.size() == hands.size() - 1;
    }

    public static boolean isFlush(List<Card> hands) {
        String suit = String.valueOf(hands.get(0).getCard_suit());

        for (Card card : hands) {
            if (!Objects.equals(String.valueOf(card.getCard_suit()), suit)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFourOfAKind(List<Card> hands) {
        Map<String, Integer> nominalCount = new HashMap<>();

        for (Card card : hands) {
            String nominal = String.valueOf(card.getNominal_value());
            nominalCount.put(nominal, nominalCount.getOrDefault(nominal, 0) + 1);
        }

        for (int count : nominalCount.values()) {
            if (count == 4) {
                return true;
            }
        }

        return false;
    }

    public static boolean isStraightFlush(List<Card> hands) {
        return findDuplicatesStraightFlush(hands) && isArrayListSorted(hands);
    }

    private static boolean findDuplicatesStraightFlush(List<Card> hands) {
        boolean allEqual = true;
        for (int i = 1; i < hands.size(); i++) {
            String currentSuit = String.valueOf(hands.get(i).getCard_suit());
            if (!currentSuit.equals(getFirstSuit(hands))) {
                allEqual = false;
                break;
            }
        }
        return allEqual;
    }

    private static boolean isStraight(List<Card> hands) {

        for (int i = 0; i <= hands.size() - 5; i++) {
            boolean isStraight = true;

            for (int j = i; j < i + 4; j++) {
                int currentRank = hands.get(j).getNominal_value().ordinal();
                int nextRank = hands.get(j + 1).getNominal_value().ordinal();

                if (currentRank + 1 != nextRank) {
                    isStraight = false;
                    break;
                }
            }

            if (isStraight && isArrayListSorted(hands)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isArrayListSorted(List<Card> list) {
        List<Card> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        return list.equals(sortedList);
    }

    private static String getFirstSuit(List<Card> hands) {
        return String.valueOf(hands.get(0).getCard_suit());
    }
}
