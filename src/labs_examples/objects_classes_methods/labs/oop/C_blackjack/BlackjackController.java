package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class BlackjackController {

    public static void main(String[] args) {
        // Test populate cards
        Deck deck = new Deck();
        deck.populateCards();

        System.out.println(deck);


        // Test deal card
        Player player = new Player("Sadat");
        System.out.println("New player hand: " + player.getHand().getCards().toString());
        System.out.println("Hand value = " + player.getHand().getHandValue());
        System.out.println("Deal card...");
        deck.deal(player);
        System.out.println("After dealing hand: " + player.getHand().getCards().toString());
        System.out.println("Hand value = " + player.getHand().getHandValue());

    }
}
