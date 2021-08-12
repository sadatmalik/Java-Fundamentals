package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Card {

    static char[] suit = new char[]{'♠', '♦', '♥', '♣'};

    private char cardSuit;
    private int cardValue;

    public Card(char cardSuit, int cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardSuit=" + cardSuit +
                ", cardValue=" + cardValue +
                '}';
    }

    public static char[] getSuit() {
        return suit;
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }
}
