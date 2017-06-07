package data.model;

/**
 * Created by alexferreira on 06/06/17.
 */
public enum SuitCard {

    SPADES (""),
    HEART (""),
    DIAMOND (""),
    CLUBS (""),
    ;

    private String value;

    SuitCard(String value) {
        this.value = value;
    }

    public boolean isHigherThan(SuitCard suitCard){
        return this.ordinal() > suitCard.ordinal() ? true : false;
    }
}
