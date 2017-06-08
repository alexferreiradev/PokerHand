package data.model.handcard;

import data.model.Card;
import data.model.handcard.util.HandUtil;

import java.util.List;
import java.util.Stack;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FourKindHand extends BaseNoHigherHand {

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        Group group = specHand.retrieveGroup();
        if (group.getLength() == 4){
            higherCard = HandUtil.getLastCard(specHand.retrieveKicker().getCards());
            return this;
        }

        return null;
    }

    @Override
    public HandType getType() {
        return HandType.FOUR_KIND;
    }

}
