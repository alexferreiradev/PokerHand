package data.model.handcard;

import data.model.Card;
import data.model.CardValue;
import data.model.handcard.util.HandUtil;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by alexferreira on 06/06/17.
 */
public class OnePairHand implements HandCard {

    @Override
    public boolean isHandType(List<Card> cards) {
        Stack<Card> cardStack = new Stack<>();
        cardStack.addAll(cards);
        while (cardStack.size() > 1){
            Card card = cardStack.pop();
            int sameCard = HandUtil.countSameCardValue(card, cardStack.elements());
            if (sameCard == 2){
                return true;
            }
        }
        return false;
    }

    public List<Card> removePair(List<Card> cards){
        Map<CardValue, Integer> groupOfValues = HandUtil.groupOfValues(cards);
        for (Map.Entry<CardValue, Integer> entry : groupOfValues.entrySet()) {
            Integer count = entry.getValue();
            CardValue cardValue = entry.getKey();

        }
    }
}
