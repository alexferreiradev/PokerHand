package data.model.handcard;

import data.model.Card;

/**
 * Created by alexferreira on 08/06/17.
 */
public interface NoHigherHand extends HandCard{

    Card getHigherCard();

    boolean isHigherKicker(NoHigherHand handCard);

    boolean isSameHand(NoHigherHand handCard);
}
