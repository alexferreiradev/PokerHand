package data.model.handcard;

import data.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by alexferreira on 07/06/17.
 */
public abstract class BaseHand {

    protected List<Card> cards;
    protected Sequence sequence;
    protected Group group;
    protected List<Pair> pairs;
    protected Kicker kicker;

    public BaseHand(List<Card> cards) {
        this.cards = cards;
        Collections.sort(cards);
        init();
    }

    protected abstract void init();

    protected List<Card> extractSequence(){
        Sequence sequence = new Sequence(cards);

        if (sequence.getLength() == 5){
            this.sequence = sequence;
        } else{
            this.sequence = null;
            return cards;
        }

        return null;
    }

    protected List<Card> extractGroups(List<Card> cards){
        if (cards == null || cards.isEmpty())
            return null;

        Stack<Card> cardStack = new Stack<>();
        cardStack.addAll(cards);
        List<Card> rest = new ArrayList<>();
        List<Card> cardsToGroup = groupSameCardValue(cardStack, rest);
        if (cardsToGroup.isEmpty())
            return cards;

        this.group = new Group(cardsToGroup);

        return rest;
    }

    protected List<Card> extractPairs(List<Card> cards){
        if (cards == null || cards.isEmpty())
            return null;

        Stack<Card> cardStack = new Stack<>();
        cardStack.addAll(cards);
        List<Pair> pairs = new ArrayList<>();
        List<Card> rest = new ArrayList<>();
        while (!cardStack.isEmpty()){
            Card card = cardStack.pop();
            if (card.getValueType() == cardStack.peek().getValueType()){
                pairs.add(new Pair(card, cardStack.pop()));
            } else {
                rest.add(card);
            }
        }

        List<Card> cardsToGroup = groupSameCardValue(cardStack, rest);
        if (cardsToGroup.isEmpty())
            return cards;

        return rest;
    }

    private List<Card> groupSameCardValue(Stack<Card> cardStack, List<Card> rest) {
        if (cards == null || cards.isEmpty())
            return null;

        List<Card> cardsToGroup = new ArrayList<>();
        while (!cardStack.isEmpty()){
            Card card = cardStack.pop();
            if (card.getValueType() == cardStack.peek().getValueType()){
                cardsToGroup.add(card);
            } else {
                rest.add(card);
            }
        }
        return cardsToGroup;
    }

    protected List<Card> extractKickers(){
        return null;
    }
}
