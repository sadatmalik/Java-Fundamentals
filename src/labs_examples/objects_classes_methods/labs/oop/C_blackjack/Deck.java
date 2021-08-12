package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    private Card[] cards;
    private ArrayList<Integer> usedCards;

    public Deck() {
        cards = new Card[52];
        usedCards = new ArrayList<>();
    }

    public void populateCards() {
        int count = 0;
        for (int suit = 0; suit < Card.getSuit().length; suit++) {
            for (int cardValue = 1; cardValue <=13 ; cardValue++) {
                Card card = new Card(Card.getSuit()[suit], cardValue);
                cards[count++] = card;
            }
        }
    }

    public void deal(Player player) {
        Random rand = new Random();
        int nextCard = rand.nextInt(52);
        while(usedCards.contains(nextCard)) {
            nextCard = rand.nextInt();
        }

        player.getHand().addCard(cards[nextCard-1]);
        usedCards.add(nextCard);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public ArrayList<Integer> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(ArrayList<Integer> usedCards) {
        this.usedCards = usedCards;
    }
}
