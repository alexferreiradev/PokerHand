package data.model.handcard;

import data.model.Card;
import data.model.CardValue;

import java.util.List;

/**
 * Created by alexferreira on 07/06/17.
 */
public class Sequence {

    private List<Card> cards;
    private CardValue initValue;
    private int length;
    private boolean isAllSameSuit;

    public Sequence(List<Card> cards) {
        if (cards == null || cards.isEmpty()){
            throw new IllegalArgumentException("Cartas é nula ou vazia.");
        }

        this.cards = cards;
        this.initValue = cards.get(0).getValueType();
        this.isAllSameSuit = true;
        this.length = extractPosSeq(cards, 0) + 1;
    }

    private int extractPosSeq(List<Card> cards, int pos){
        Card card = cards.get(pos);
        Card nextCard = cards.get(pos + 1);
        if (nextCard.getValueType().ordinal() == card.getValueType().ordinal() + 1){
            if (isAllSameSuit && card.getSuitType() != nextCard.getSuitType()){
                isAllSameSuit = false;
            }

            return extractPosSeq(cards, pos + 1);
        } else {
            return pos;
        }
    }

    public CardValue getInitValue() {
        return initValue;
    }

    public void setInitValue(CardValue initValue) {
        this.initValue = initValue;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isAllSameSuit() {
        return isAllSameSuit;
    }

    public void setAllSameSuit(boolean allSameSuit) {
        isAllSameSuit = allSameSuit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sequence sequence = (Sequence) o;

        if (length != sequence.length) return false;
        if (isAllSameSuit != sequence.isAllSameSuit) return false;
        return initValue == sequence.initValue;
    }

    @Override
    public int hashCode() {
        int result = initValue != null ? initValue.hashCode() : 0;
        result = 31 * result + length;
        result = 31 * result + (isAllSameSuit ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "initValue=" + initValue +
                ", length=" + length +
                ", isAllSameSuit=" + isAllSameSuit +
                '}';
    }
}
