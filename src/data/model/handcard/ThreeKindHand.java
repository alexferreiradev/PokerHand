package data.model.handcard;

import data.model.Card;
import data.model.handcard.util.HandUtil;

import java.util.*;

/**
 * Created by alexferreira on 06/06/17.
 */
public class ThreeKindHand implements HandCard {

    @Override
    public boolean isHandType(List<Card> cards) {
        int count = 0;

        Stack<Card> cardStack = new Stack<>();
        cardStack.addAll(cards);
        while (cardStack.size() > 2){
            Card card = cardStack.pop();
            int sameCard = HandUtil.countSameCardValue(card, cardStack.elements());
            if (sameCard == 3){
                return true;
            }
        }

        return false;
    }
}
