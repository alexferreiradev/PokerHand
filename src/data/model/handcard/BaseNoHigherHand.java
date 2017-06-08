package data.model.handcard;

import data.model.Card;

/**
 * Created by alexferreira on 08/06/17.
 */
public abstract class BaseNoHigherHand implements NoHigherHand{

    protected Card higherCard;

    @Override
    public boolean isHigherThan(NoHigherHand hand) {
        if (isSameHand(hand)){
            return isHigherKicker(hand);
        }

        return getType().isHigherThan(hand.getType());
    }

    @Override
    public boolean isSameHand(NoHigherHand handCard) {
        return handCard.getType() == getType() ? true : false;
    }

    @Override
    public boolean isHigherKicker(NoHigherHand handCard) {
        return handCard.getHigherCard().isHigherThan(higherCard);
    }

    @Override
    public Card getHigherCard() {
        return higherCard;
    }

}
