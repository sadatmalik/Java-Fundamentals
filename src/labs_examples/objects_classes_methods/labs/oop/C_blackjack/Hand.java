package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private int handValue;

    public Hand() {
        this.cards = new ArrayList<>();
        this.handValue = 0;
    }

    public void addCard(Card card) {
        cards.add(card);
        handValue += card.getCardValue();
    }

    public boolean isBust() {
        return handValue > 21 ? true : false;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getHandValue() {
        return handValue;
    }

}
