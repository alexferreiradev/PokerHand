package data.model.handcard;

import data.model.Card;
import data.model.SuitCard;
import data.model.handcard.util.HandUtil;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FlushHand extends BaseNoHigherHand {

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        List<Card> cards = specHand.getCards();
        SuitCard suitCard = null;
        if (specHand.retrieveSequence().isComplete() || !HandUtil.isSameSuit(cards)){
            return null;
        }

        higherCard = HandUtil.getLastCard(specHand.getCards());

        return this;
    }

    @Override
    public HandType getType() {
        return HandType.FLUSH;
    }

}
