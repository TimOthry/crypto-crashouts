package cc.hackathon.shef.uk.cryptocrashouts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a player and all of their wallets combined, and contains the cards in the wallets
 */
public class Player {
    private List<Card> cards = new ArrayList<>();

    /**
     * Constructor for a player
     * @param walletPath File path for their wallet csv file
     * @throws IOException If the file path isn't valid
     */
    public Player(String walletPath) throws IOException {
        // generate the player's cards
        this.cards = cardsFromCSV(walletPath);
    }

    /**
     * Reads a CSV representation of a wallet and creates cards of each crypto
     * @param walletPath The file path of the wallet CSV
     * @return A list of cards for each crypto
     * @throws IOException If the file isn't found
     */
    private List<Card> cardsFromCSV(String walletPath) throws IOException {
        // read the wallet. iterate through and generate new card for each entry. finish
        Scanner sc = new Scanner(new File(walletPath));
        List<Card> newCards = new ArrayList<>();

        // add a new card for each cryptocurrency
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split(",");

            Card newCard = new Card(split[0], Double.parseDouble(split[1]));
            newCards.add(newCard);
        }

        return newCards;
    }

    public List<Card> getCards() { return cards; }

    public String toString() {
        return "Cards in this wallet: " + cards.toString();
    }
}
