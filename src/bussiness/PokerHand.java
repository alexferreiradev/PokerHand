package bussiness;

import data.model.Card;
import data.model.CardValue;
import data.model.ResultHand;
import data.model.SuitCard;
import data.model.handcard.HandCard;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by alexferreira on 06/06/17.
 */
public class PokerHand {

    private String hand;
    private List<Card> cards;

    public PokerHand(String hand) {
        this.hand = hand;
        extractCards();
    }

    private void extractCards() {
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
    }

    public ResultHand compareWith(PokerHand hand){
        new HandCard();
        return ;
    }

}
