package bussiness;

import data.model.Card;
import data.model.CardValue;
import data.model.ResultHand;
import data.model.SuitCard;
import data.model.handcard.HandCard;
import data.model.handcard.HandFactory;
import data.model.handcard.NoHigherHand;
import data.model.handcard.SpecHand;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by alexferreira on 06/06/17.
 */
public class PokerHand {

    private String hand;
    private List<Card> cards;
    private HandCard handCard;

    public PokerHand(String hand) {
        this.hand = hand;
        extractHand();
    }

    private void extractHand() {
        StringTokenizer tokenizer = new StringTokenizer(hand, " ");
        cards = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            String[] split = token.split("\\w");
            SuitCard suitType = SuitCard.valueOf(split[0]);
            CardValue value = CardValue.valueOf(split[1]);
            Card card = new Card(suitType, value);
            cards.add(card);
        }

        HandFactory handFactory = new HandFactory(new SpecHand(cards));
        handCard = handFactory.build();
    }

    public ResultHand compareWith(PokerHand hand){
        if (this.handCard.isHigherThan(hand.getHandCard())){
            return ResultHand.WIN;
        }

        return ResultHand.LOSS;
    }

    public HandCard getHandCard() {
        return handCard;
    }
}
