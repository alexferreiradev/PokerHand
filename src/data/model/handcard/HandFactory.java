package data.model.handcard;

import data.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by alexferreira on 07/06/17.
 */
public class HandFactory {

    private SpecHand specHand;

    public HandFactory(SpecHand specHand) {
        this.specHand = specHand;
    }

    public HandCard build(){
        HandType[] handTypes = HandType.values();
        for (HandType handType : handTypes) {
            HandCard handCard = handType.getHandCard().generateFromSpec(specHand);
            if (handCard != null) {
                return handCard;
            }
        }

        return null;
    }
}
