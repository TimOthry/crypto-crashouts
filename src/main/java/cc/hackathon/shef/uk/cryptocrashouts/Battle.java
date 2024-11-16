package cc.hackathon.shef.uk.cryptocrashouts;

public class Battle {
    private final Player player1;
    private final Player player2;
    private int winner;

    /**
     * Constructor for a battle
     * @param player1 Player 1
     * @param player2 Player 2
     */
    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Battles two cards and stores the winner
     * @param crypto1 The name of the cryptocurrency used by player 1
     * @param crypto2 The name of the cryptocurrency used by player 2
     */
    public void battleTwoCards(String crypto1, String crypto2) {
        // find player 1's card in their deck/wallet
        Card p1Card = new Card("test", 0, 0);

        for (Card card : player1.getCards()) {
            if (card.getName().equals(crypto1)) {
                p1Card = card;
                break;
            }
        }

        // find player 2's card in their deck
        Card p2Card = new Card("test", 0, 0);

        for (Card card : player2.getCards()) {
            if (card.getName().equals(crypto2)) {
                p2Card = card;
            }
        }

        // main battle logic
        if (p1Card.getPower() > p2Card.getPower()) {
            winner = 1;
        } else if (p1Card.getPower() < p2Card.getPower()) {
            winner = 2;
        } else {
            winner = 0;
        }
    }

    /**
     * Gets the winner of the battle
     * @return 1 = player 1, 2 = player 2, 0 = draw
     */
    public int getWinner() {
        return winner;
    }

    public Player getPlayer1() { return player1; }

    public Player getPlayer2() { return player2; }
}
