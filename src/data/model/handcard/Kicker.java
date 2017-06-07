package data.model.handcard;

import data.model.Card;

import java.util.List;

/**
 * Created by alexferreira on 07/06/17.
 */
public class Kicker {

    private List<Card> cards;

    public Kicker(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kicker kicker = (Kicker) o;

        return cards != null ? cards.equals(kicker.cards) : kicker.cards == null;
    }

    @Override
    public int hashCode() {
        return cards != null ? cards.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Kicker{" +
                "cards=" + cards +
                '}';
    }
}
