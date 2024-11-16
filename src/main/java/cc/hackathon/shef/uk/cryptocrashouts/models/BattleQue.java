package cc.hackathon.shef.uk.cryptocrashouts.models;

import jakarta.persistence.*;

@Entity
@Table(name = "battle_que")
public class BattleQue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // card details
    private String coinName;
    private double coinAmount;

    public BattleQue() {}

    public BattleQue(String coinName, double coinAmount) {
        this.coinName = coinName;
        this.coinAmount = coinAmount;
    }

    public Long getId() {
        return id;
    }

    public String getCoinName() {
        return coinName;
    }

    public double getCoinAmount() {
        return coinAmount;
    }
}

