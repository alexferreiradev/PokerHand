package data.model.handcard;

import data.model.Card;
import data.model.handcard.util.HandUtil;

import java.util.List;
import java.util.Stack;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FullHouse implements HandCard {

    public FullHouse(List<Card> cards) {
    }

    @Override
    public boolean isHandType(List<Card> cards) {
        Stack<Card> cardStack = new Stack<>();
        cardStack.addAll(cards);
        boolean hasPair = new OnePairHand().isHandType(cards);
        if (hasPair){
            while (cardStack.size() > 3){
                Card card = cardStack.pop();
                int sameCard = HandUtil.countSameCardValue(card, cardStack.elements());
                if (sameCard == 3){
                    return true;
                }
            }
        }

        return false;
    }
}
