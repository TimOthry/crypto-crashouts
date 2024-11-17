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
    private String maticWallet;

    public Player() {}

    public Player(String btcWallet, String ethWallet, String dogeWallet, String maticWallet) {
        if (btcWallet != null) {
            this.btcWallet = btcWallet;
        }
        if (ethWallet != null) {
            this.ethWallet = ethWallet;
        }
        if (dogeWallet != null) {
            this.dogeWallet = dogeWallet;
        }
        if (maticWallet != null) {
            this.maticWallet = maticWallet;
        }
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

    public String getMaticWallet() {
        return maticWallet;
    }
}
