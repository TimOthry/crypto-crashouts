package cc.hackathon.shef.uk.cryptocrashouts.controllers;

import cc.hackathon.shef.uk.cryptocrashouts.Battle;
import cc.hackathon.shef.uk.cryptocrashouts.Card;
import cc.hackathon.shef.uk.cryptocrashouts.models.BattleQue;
import cc.hackathon.shef.uk.cryptocrashouts.models.CompletedBattle;
import cc.hackathon.shef.uk.cryptocrashouts.service.BattleQueService;
import cc.hackathon.shef.uk.cryptocrashouts.service.CompletedBattleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class mainController {
    private final BattleQueService battleQueService;
    private final CompletedBattleService completedBattleService;

    public mainController(BattleQueService battleQueService, CompletedBattleService completedBattleService) {
        this.battleQueService = battleQueService;
        this.completedBattleService = completedBattleService;
    }

    @GetMapping("/landing")
    public String index() {
        return "landing";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/battle")
    public String battle(String coinAmount, String coinName, Model model) {
        // add the user to the queue for a battle
        BattleQue battleQue = new BattleQue(coinName, Double.parseDouble(coinAmount));
        battleQueService.addToQueue(battleQue);

        // the reference for the user in the database
        model.addAttribute("battleQueNum", battleQue.getId());

        // send the user to the waiting for battle page
        return "battleQue";
    }

    @PostMapping("/battlequeue/{id}")
    public String battleQueue(@PathVariable Long id, Model model) {
        CompletedBattle completedBattle = completedBattleService.findByPlayer2Id(id);

        // check if the battle has been completed
        if (completedBattle == null) {
            // try and do a battle if there's enough players
            List<BattleQue> queue = battleQueService.getQueue();

            if (queue.size() >= 2) {
                // make a card for the current player
                BattleQue player1 = battleQueService.findById(id);
                Card p1Card = new Card(player1.getCoinName(), player1.getCoinAmount());

                BattleQue player2 = null;

                // find another player to get
                if (queue.get(0).getId() == id) {
                    player2 = battleQueService.findById(queue.get(1).getId());
                } else {
                    player2 = battleQueService.findById(queue.get(0).getId());
                }

                Card p2Card = new Card(player2.getCoinName(), player2.getCoinAmount());

                // battle the cards
                int result = Battle.battleJustTwoCards(p1Card, p2Card);
                Long winner;

                // get the id of the winner. The current player is always player 1
                if (result == 1) {
                    winner = player1.getId();
                } else if (result == 2) {
                    winner = player2.getId();
                } else {
                    winner = 0L;
                }

                // write result to completed database
                CompletedBattle completedBattle1 = new CompletedBattle(player1.getId(), player1.getCoinName(), player1.getCoinAmount(), player2.getId(), player2.getCoinName(), player2.getCoinAmount(), winner);
                completedBattleService.save(completedBattle1);

                // remove players from the queue
                battleQueService.removeFromQueue(player1);
                battleQueService.removeFromQueue(player2);

                // send the user to the after battle page
                model.addAttribute("completedBattle", completedBattle1);
                model.addAttribute("battleQueNum", id);
                return "battleComplete";
            } else {
                // make the user wait more for enough players
                model.addAttribute("battleQueNum", id);
                return "battleQue";
            }
        } else {
            // if the user has been in a battle that's been completed
            model.addAttribute("completedBattle", completedBattle);
            model.addAttribute("battleQueNum", id);
            return "battleComplete";
        }
    }
}
