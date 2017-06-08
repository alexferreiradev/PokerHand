package data.model.handcard;

import data.model.Card;
import data.model.CardValue;
import data.model.handcard.util.HandUtil;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class SequenceHand extends BaseNoHigherHand {

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        if (specHand.retrieveSequence().isComplete() &&
                specHand.retrieveSequence().getInitValue() != CardValue.TEN &&
                !specHand.retrieveSequence().isAllSameSuit()){
            higherCard = HandUtil.getLastCard(specHand.getCards());
            return this;
        }

        return null;
    }

    @Override
    public HandType getType() {
        return HandType.SEQUENCE;
    }
}
