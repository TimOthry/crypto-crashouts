package cc.hackathon.shef.uk.cryptocrashouts.models;

import jakarta.persistence.*;

/**
 * Stores the wallets of a player in the database
 */
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String btcWallet;
    private String ethWallet;
    private String dogeWallet;

    public Player() {}

    public Player(String btcWallet, String ethWallet, String dogeWallet) {
        this.btcWallet = btcWallet;
        this.ethWallet = ethWallet;
        this.dogeWallet = dogeWallet;
    }

    public Long getId() {
        return id;
    }

    public String getBtcWallet() {
        return btcWallet;
    }

    public String getEthWallet() {
        return ethWallet;
    }

    public String getDogeWallet() {
        return dogeWallet;
    }
}
