package data.model.handcard;

import data.model.Card;
import data.model.handcard.util.HandUtil;

import java.util.List;
import java.util.Stack;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FourKindHand implements HandCard {

    @Override
    public boolean isHandType(List<Card> cards) {
        int count = 0;

        Stack<Card> cardStack = new Stack<>();
        cardStack.addAll(cards);
        while (cardStack.size() > 3){
            Card card = cardStack.pop();
            int sameCard = HandUtil.countSameCardValue(card, cardStack.elements());
            if (sameCard == 4){
                return true;
            }
        }

        return false;
    }
}
