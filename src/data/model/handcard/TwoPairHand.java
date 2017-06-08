package data.model.handcard;

import data.model.Card;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class TwoPairHand extends BaseNoHigherHand {

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        return null;
    }

    @Override
    public HandType getType() {
        return HandType.TWO_PAIR;
    }
}
