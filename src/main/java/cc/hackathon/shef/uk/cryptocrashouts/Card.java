package cc.hackathon.shef.uk.cryptocrashouts;

/**
 * Represents a card for a crypto currency
 */
public class Card {
    private final String name;
    private double power;

    /**
     * Constructor for a card
     * @param name The name of the cryptocurrency
     * @param coinAmount The amount of the cryptocurrency the user owns
     * @param marketPrice The market price in USD of one coin
     */
    public Card(String name, double coinAmount, double marketPrice) {
        this.name = name;
        this.power = coinAmount * marketPrice;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public String toString() {
        return "Crypto: " + name + ", Power: " + power;
    }
}
