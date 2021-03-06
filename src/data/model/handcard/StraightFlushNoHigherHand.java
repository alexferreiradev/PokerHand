package data.model.handcard;

import data.model.CardValue;
import data.model.handcard.util.HandUtil;

/**
 * Created by alexferreira on 06/06/17.
 */
public class StraightFlushNoHigherHand extends BaseNoHigherHand {

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        Sequence sequence = specHand.retrieveSequence();
        if (sequence.getInitValue() != CardValue.TEN && sequence.extractLength() == 5 && sequence.isAllSameSuit()){
            higherCard = HandUtil.getLastCard(sequence.getCards());
            return this;
        }

        return null;
    }

    @Override
    public HandType getType() {
        return HandType.STRAIGHT_FLUSH;
    }

}
