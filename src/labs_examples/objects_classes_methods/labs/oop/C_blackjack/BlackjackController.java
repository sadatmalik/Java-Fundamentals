package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackController {

    static int betSize = 0;

    public static void main(String[] args) {
        // testGame();

        playBlackJack();

    }

    public static void playBlackJack() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scanner.next();

        System.out.print("Place your bet: ");
        betSize = scanner.nextInt();

        Player playerOne = new Player(name, 10);
        Player computer = new Player("Computer", 10);

        Deck deck = new Deck();
        newGame(playerOne, computer, deck);

        boolean playerOneDealt = true;
        boolean computerDealt = true;

        while (true) {

            if (playerOne.getPotValue() < betSize) {
                System.out.println(playerOne.getName() + " can't afford to play any more -- minimum bet size " + betSize);
                break;
            }

            if (computer.getPotValue() < betSize) {
                System.out.println(computer.getName() + " can't afford to play any more -- minimum bet size " + betSize);
                break;
            }

            System.out.println("Would you like another card?");
            String anotherCard = scanner.next();

            if (anotherCard.equalsIgnoreCase("yes")) {
                deck.deal(playerOne);
                showCards(playerOne);
                playerOneDealt = true;
            } else {
                playerOneDealt = false;
            }

            boolean cardForComputer = computer.computerAI();
            if (cardForComputer) {
                deck.deal(computer);
                System.out.println("Computer takes another card");
                computerDealt = true;
            } else {
                System.out.println("Computer declines another card");
                computerDealt = false;
            }

            if (!playerOneDealt && !computerDealt) {
                endGame(playerOne, computer);
                newGame(playerOne, computer, deck);
            }

            if (playerOne.getHand().isBust() && computer.getHand().isBust()) {
                endGame(playerOne, computer);
                newGame(playerOne, computer, deck);
            }
        }

    }

    private static void newGame(Player p1, Player p2, Deck deck) {
        p1.newHand();
        p2.newHand();
        deck.newDeck();

        System.out.println("\n----New Game----");
        System.out.println(p1.getName() + "'s pot is " + p1.getPotValue());
        System.out.println(p2.getName() + "'s pot is " + p2.getPotValue());

        deck.populateCards();

        deck.deal(p1);
        deck.deal(p2);

        deck.deal(p1);
        deck.deal(p2);

        showCards(p1);
    }

    private static void endGame(Player p1, Player p2) {
        System.out.println("\nClosing hands...");

        showCards(p1);
        showCards(p2);

        System.out.println();

        if (!p1.getHand().isBust() && !p2.getHand().isBust()) {
            // calculate winner
            if (p1.getHand().getHandValue() > p2.getHand().getHandValue()) {
                // p1 wins
                System.out.println(p1.getName() + " wins!");
                settleBets(p1, p2);

            } else if (p1.getHand().getHandValue() == p2.getHand().getHandValue()) {
                // draw
                System.out.println("It's a draw!");
            } else {
                // p2 wins
                System.out.println(p2.getName() + " wins!");
                settleBets(p2, p1);
            }
        } else if (!p1.getHand().isBust() && p2.getHand().isBust()) {
            // p1 wins
            System.out.println(p1.getName() + " wins!");
            settleBets(p1, p2);
        } else if (p1.getHand().isBust() && !p2.getHand().isBust()) {
            // p2 wins
            System.out.println(p2.getName() + " wins!");
            settleBets(p2, p1);
        } else {
            // both lose
            System.out.println("You're both bust!");
        }

    }

    private static void settleBets(Player winner, Player loser) {
        loser.setPotValue(loser.getPotValue() - betSize);
        winner.setPotValue((winner.getPotValue()) + betSize);
    }

    private static void showCards(Player player) {
        ArrayList<Card> cards = player.getHand().getCards();
        System.out.println("\n" + player.getName() + "'s cards: ");
        for (Card card : cards) {
            System.out.println(card.toString());
        }
        System.out.println("Hand value = " + player.getHand().getHandValue());

    }

    public static void testGame() {
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
