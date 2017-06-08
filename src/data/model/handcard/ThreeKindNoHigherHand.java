package data.model.handcard;

import data.model.handcard.util.HandUtil;

/**
 * Created by alexferreira on 06/06/17.
 */
public class ThreeKindNoHigherHand extends BaseNoHigherHand {

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        if (specHand.retrieveGroup().getLength() == 3){
            higherCard = HandUtil.getLastCard(specHand.getCards());
        }
        return null;
    }

    @Override
    public HandType getType() {
        return HandType.THREE_KIND;
    }

}
