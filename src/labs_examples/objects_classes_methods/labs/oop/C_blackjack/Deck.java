package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    private Card[] cards;
    private ArrayList<Integer> usedCards;
    private int numOfNewDecks;

    public Deck() {
        cards = new Card[52];
        usedCards = new ArrayList<>();
    }

    public void newDeck() {
        cards = new Card[52];
        usedCards = new ArrayList<>();
    }

    public int getNumOfNewDecks() {
        return numOfNewDecks;
    }

    public void populateCards() {

        numOfNewDecks++;

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
            nextCard = rand.nextInt(52);
        }

        try {
            player.getHand().addCard(cards[nextCard]);
            usedCards.add(nextCard);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Attempting to retrieve card #" + nextCard);
            ex.printStackTrace();
        }

        // System.out.println(player.getName() + " dealt " + cards[nextCard]);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }

}
