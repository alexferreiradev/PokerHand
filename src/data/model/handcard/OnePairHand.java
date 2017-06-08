package data.model.handcard;

import data.model.Card;
import data.model.CardValue;
import data.model.handcard.util.HandUtil;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by alexferreira on 06/06/17.
 */
public class OnePairHand extends BaseNoHigherHand {

    private List<Pair> mPairs;

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        List<Pair> pairs = specHand.retrievePairs();
        if (pairs.isEmpty() || pairs.size() > 1){
            return null;
        }
        mPairs = pairs;

        return this;
    }

    @Override
    public HandType getType() {
        return HandType.ONE_PAIR;
    }
}
