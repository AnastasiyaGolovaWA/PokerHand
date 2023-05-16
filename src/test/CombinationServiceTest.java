import com.example.pokerhand.model.PokerHand;
import com.example.pokerhand.service.CombinationService;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class CombinationServiceTest {

    @Test
    public void testGetHandRankRoyalFlush() {
        PokerHand royalFlushHand = new PokerHand("AS KS QS JS TS");
        assertEquals(CombinationService.getHandRank(royalFlushHand.getHands()), CombinationService.ROYAL_FLUSH);
    }

    @Test
    public void testGetHandRankStraightFlush() {
        PokerHand straightFlushHand = new PokerHand("6S 7S 8S 9S TS");
        assertEquals(CombinationService.getHandRank(straightFlushHand.getHands()), CombinationService.STRAIGHT_FLUSH);
    }

    @Test
    public void testGetHandRankFourOfAKind() {
        PokerHand fourOfAKindHand = new PokerHand("6S 6H 6D 6C TS");
        assertEquals(CombinationService.getHandRank(fourOfAKindHand.getHands()), CombinationService.FOUR_OF_A_KIND);
    }

    @Test
    public void testGetHandRankFullHouse() {
        PokerHand fullHouseHand = new PokerHand("6S 6H 6D 9C 9D");
        assertEquals(CombinationService.getHandRank(fullHouseHand.getHands()), CombinationService.FULL_HOUSE);
    }

    @Test
    public void testGetHandRankFlush() {
        PokerHand flushHand = new PokerHand("2S 4S 8S 6S QS");
        assertEquals(CombinationService.getHandRank(flushHand.getHands()), CombinationService.FLUSH);
    }

    @Test
    public void testGetHandRankStraight() {
        PokerHand straightHand = new PokerHand("3S 4H 5D 6C 7S");
        assertEquals(CombinationService.getHandRank(straightHand.getHands()), CombinationService.STRAIGHT);
    }

    @Test
    public void testGetHandRankThreeOfAKind() {
        PokerHand threeOfAKindHand = new PokerHand("3S 3H 3D 6C 7S");
        assertEquals(CombinationService.getHandRank(threeOfAKindHand.getHands()), CombinationService.THREE_OF_A_KIND);
    }

    @Test
    public void testGetHandRankOnePair() {
        PokerHand onePairHand = new PokerHand("3S 3H 6D 5C 7S");
        assertEquals(CombinationService.getHandRank(onePairHand.getHands()), CombinationService.ONE_PAIR);
    }

    @Test
    public void testGetHandRankTwoPair() {
        PokerHand twoPairHand = new PokerHand("9S 9H 7H 7C 6D");
        assertEquals(CombinationService.getHandRank(twoPairHand.getHands()), CombinationService.TWO_PAIR);
    }

    @Test
    public void testGetHandRankHighCard() {
        PokerHand highCardHand = new PokerHand("2S 4H 6D 8C JS");
        assertEquals(CombinationService.getHandRank(highCardHand.getHands()), CombinationService.HIGH_CARD);
    }

    @Test
    public void testCompareHands() {
        PokerHand hand1 = new PokerHand("AS KS QS JS TS");
        PokerHand hand2 = new PokerHand("9S 9H 9C 8C 8D");
        Assertions.assertEquals(1, hand1.compareTo(hand2));
    }
}
