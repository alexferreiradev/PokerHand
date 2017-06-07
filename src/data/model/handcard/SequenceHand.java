package data.model.handcard;

import data.model.Card;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class SequenceHand extends HandCard {

    public SequenceHand(List<Card> cards) {
        super(cards);
    }

    @Override
    public boolean isHandType(List<Card> cards) {
        return false;
    }
}
