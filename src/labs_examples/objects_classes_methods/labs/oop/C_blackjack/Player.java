package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    private String name;
    private Hand hand;
    private int potValue;
    private int wins;

    public Player(String name) {
        this(name, 0);
    }

    public Player(String name, int potValue) {
        this.name = name;
        this.hand = new Hand();
        this.potValue = potValue;
    }

    public boolean computerAI() {
        return hand.getHandValue() < 16 ? true : false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void wins() {
        wins++;
    }

    public int getWins() {
        return wins;
    }

    public void newHand() {
        this.hand = new Hand();
    }

    public int getPotValue() {
        return potValue;
    }

    public void setPotValue(int potValue) {
        this.potValue = potValue;
    }
}
