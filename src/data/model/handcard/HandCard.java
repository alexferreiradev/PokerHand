package data.model.handcard;

import data.model.Card;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public interface HandCard {

    boolean isHigherThan(NoHigherHand hand);

    /**
     * Gera uma mao de acordo com a specificação passada.
     *
     * @param specHand
     * @return - null caso a especificação não ser adequada para gerar.
     */
    HandCard generateFromSpec(SpecHand specHand);

    HandType getType();

}