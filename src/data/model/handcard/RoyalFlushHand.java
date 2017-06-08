package data.model.handcard;

import data.model.Card;
import data.model.CardValue;
import data.model.SuitCard;
import data.model.handcard.util.HandUtil;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class RoyalFlushHand implements HandCard {

    @Override
    public boolean isHigherThan(NoHigherHand hand) {
        return getType().isHigherThan(hand.getType());
    }

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        Sequence sequence = specHand.retrieveSequence();
        SuitCard sequenceSuitType = HandUtil.getLastCard(sequence.getCards()).getSuitType();
        if (sequence.getInitValue() == CardValue.TEN && sequence.extractLength() == 5 &&
                sequence.isAllSameSuit() && sequenceSuitType == SuitCard.HEART){
            return this;
        }

        return null;
    }

    @Override
    public HandType getType() {
        return HandType.ROYAL_FLUSH;
    }
}
