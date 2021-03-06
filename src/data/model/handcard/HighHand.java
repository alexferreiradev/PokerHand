package data.model.handcard;

import data.model.Card;
import data.model.handcard.util.HandUtil;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class HighHand extends BaseNoHigherHand {

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        higherCard = HandUtil.getLastCard(specHand.getCards());
        return this;
    }

    @Override
    public HandType getType() {
        return HandType.HIGH_CARD;
    }
}
