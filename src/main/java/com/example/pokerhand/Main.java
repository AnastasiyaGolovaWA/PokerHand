package com.example.pokerhand;

import com.example.pokerhand.model.PokerHand;
import com.example.pokerhand.service.CombinationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // ONE PAIR
        System.out.println(CombinationService.getHandRank(new PokerHand("9S 9H 7H 8C 6D").getHands()));
        // TWO PAIR
        System.out.println(CombinationService.getHandRank(new PokerHand("9S 9H 7H 7C 6D").getHands()));
        //THREE OF A KIND
        System.out.println(CombinationService.getHandRank(new PokerHand("9S 9H 7H 8C 9D").getHands()));
        //STRAIGHT
        System.out.println(CombinationService.getHandRank(new PokerHand("3S 4H 5H 6C 7D").getHands()));
        //FLUSH
        System.out.println(CombinationService.getHandRank(new PokerHand("3D 4D 6D 5D 7D").getHands()));
        //FULL HOUSE
        System.out.println(CombinationService.getHandRank(new PokerHand("9S 9H 9C 8C 8D").getHands()));
        //FOUR FOR A KIND
        System.out.println(CombinationService.getHandRank(new PokerHand("9S 9H 9D 9C 6D").getHands()));
        //STRAIGHT FLUSH
        System.out.println(CombinationService.getHandRank(new PokerHand("3S 4S 5S 6S 7S").getHands()));
        //ROYAL FLUSH
        System.out.println(CombinationService.getHandRank(new PokerHand("AS KS QS JS TS").getHands()));

        List<PokerHand> hands_ = new ArrayList<>();
        hands_.add(new PokerHand("AS KS QS JS TS"));
        hands_.add(new PokerHand("9S 9H 9C 8C 8D"));

        Collections.sort(hands_);

        for (PokerHand hand : hands_) {
            System.out.println(hand.getHands());
        }
    }
}