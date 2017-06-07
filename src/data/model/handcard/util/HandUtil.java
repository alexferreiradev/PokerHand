package data.model.handcard.util;

import data.model.Card;
import data.model.CardValue;

import java.util.*;

/**
 * Created by alexferreira on 06/06/17.
 */
public class HandUtil {

    /**
     * Retorna o maior número de cartas criados com a lista de cards
     *
     * @param card - carta a ser utilizada para agrupar
     * @param cards - conjunto de cartas para encontrar grupos
     * @return - quantidade de cartas encontras iguais
     */
    public static int countSameCardValue(Card card, Enumeration<Card> cards){
        int count = 0;

        while (cards.hasMoreElements()){
            Card cardComparing = cards.nextElement();
            if (card.getValueType() == cardComparing.getValueType()){
                count ++;
            }
        }

        return count;
    }

    public static Map<CardValue, Integer> groupOfValues(List<Card> cards){
        Map<CardValue, Integer> groups = new HashMap<>();
        Stack<Card> cardStack = new Stack<>();
        cardStack.addAll(cards);
        while (!cardStack.isEmpty()){
            Card card = cardStack.pop();
            groups.put(card.getValueType(), countSameCardValue(card, cardStack.elements()));
        }
        return groups;
    }
}
