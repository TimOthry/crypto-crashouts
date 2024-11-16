package cc.hackathon.shef.uk.cryptocrashouts.models;

import jakarta.persistence.*;

/**
 * Stores the details of a completed match so the web browsers of the waiting players can fetch the results
 * and play animations
 */
@Entity
@Table(name = "completed_battles")
public class CompletedBattle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Player 1 and their card
    private Long player1Id;
    private String p1CoinName;
    private String p1CoinAmount;

    // Player 2 and their card
    private Long player2Id;
    private String p2CoinName;
    private String p2CoinAmount;

    // the winner
    private int winner;

    public CompletedBattle() {}

    public CompletedBattle(Long player1Id, String p1CoinName, String p1CoinAmount, Long player2Id, String p2CoinName, String p2coinAmount) {
        this.player1Id = player1Id;
        this.p1CoinName = p1CoinName;
        this.p1CoinAmount = p1CoinAmount;

        this.player2Id = player2Id;
        this.p2CoinName = p2CoinName;
        this.p2CoinAmount = p2coinAmount;
    }

    public Long getId() {
        return id;
    }

    public Long getPlayer1Id() {
        return player1Id;
    }

    public String getP1CoinName() {
        return p1CoinName;
    }

    public String getP1CoinAmount() {
        return p1CoinAmount;
    }

    public Long getPlayer2Id() {
        return player2Id;
    }

    public String getP2CoinName() {
        return p2CoinName;
    }

    public String getP2CoinAmount() {
        return p2CoinAmount;
    }

    public int getWinner() {
        return winner;
    }
}

