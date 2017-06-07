package data.model.handcard;

import data.model.Card;
import data.model.SuitCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FlushHand implements HandCard {

    public FlushHand() {
    }

    @Override
    public boolean isHandType(List<Card> cards) {
        SuitCard lastSuit = null;
        for (Card card : cards) {
            if (lastSuit ==  null){
                lastSuit = card.getSuitType();
                continue;
            }

            if (lastSuit != card.getSuitType()) {
                return false;
            }
            lastSuit = card.getSuitType();
        }
        return false;
    }
}
