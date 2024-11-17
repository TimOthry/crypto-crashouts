package cc.hackathon.shef.uk.cryptocrashouts.controllers;

import cc.hackathon.shef.uk.cryptocrashouts.Battle;
import cc.hackathon.shef.uk.cryptocrashouts.Card;
import cc.hackathon.shef.uk.cryptocrashouts.Wallet;
import cc.hackathon.shef.uk.cryptocrashouts.models.BattleQue;
import cc.hackathon.shef.uk.cryptocrashouts.models.CompletedBattle;
import cc.hackathon.shef.uk.cryptocrashouts.models.Player;
import cc.hackathon.shef.uk.cryptocrashouts.service.BattleQueService;
import cc.hackathon.shef.uk.cryptocrashouts.service.CompletedBattleService;
import cc.hackathon.shef.uk.cryptocrashouts.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class mainController {
    private final BattleQueService battleQueService;
    private final CompletedBattleService completedBattleService;
    private final PlayerService playerService;

    public mainController(BattleQueService battleQueService, CompletedBattleService completedBattleService, PlayerService playerService) {
        this.battleQueService = battleQueService;
        this.completedBattleService = completedBattleService;
        this.playerService = playerService;
    }

    @GetMapping("/") // Changed from "/landing"
    public String index() {
        return "landing";
    }

    @PostMapping("/addwallets")
    public String addWallets(String btc, String eth, String doge, RedirectAttributes redirectAttributes) {
        // add a player record to the database to store the wallets. I couldn't think of a better way to do this
        // as you can't pass an object from page to page every time as that's tedious, so just put player's id in
        // the url. They can't login or anything, so they'll have to reenter their information every time

        // create a player
        Player player = new Player(btc, eth, doge);
        Player savedPlayer = playerService.save(player);

        // redirect to home page
        return "redirect:/home/" + savedPlayer.getId();
    }

    @GetMapping("/home/{id}")
    public String home(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id);
        System.out.println(player.getId() + player.getBtcWallet());

        // add the wallet values to the page
        model.addAttribute("btcWallet", Wallet.btcWalletValue(player.getBtcWallet()));
        model.addAttribute("ethWallet", Wallet.ethWalletValue(player.getEthWallet()));
        model.addAttribute("dogeWallet", Wallet.dogeWalletValue(player.getDogeWallet()));

        // make cards of the coins so you can get the power
        Card btc = new Card("btc", Wallet.btcWalletValue(player.getBtcWallet()));
        model.addAttribute("btcPower", btc.getPower());

        Card eth = new Card("eth", Wallet.ethWalletValue(player.getEthWallet()));
        model.addAttribute("ethPower", eth.getPower());

        Card doge = new Card("doge", Wallet.dogeWalletValue(player.getDogeWallet()));
        model.addAttribute("dogePower", doge.getPower());

        // add the user Id so this can be forwarded around in the urls
        model.addAttribute("userId", id);
        return "home";
    }

    @PostMapping("/battle/{userId}")
    public String battle(@PathVariable Long userId, String coinAmount, String coinName, Model model) {
        // add the user to the queue for a battle
        BattleQue battleQue = new BattleQue(coinName, Double.parseDouble(coinAmount));
        battleQueService.addToQueue(battleQue);

        // the reference for the user in the database
        model.addAttribute("battleQueNum", battleQue.getId());

        // send the user to the waiting for battle page
        model.addAttribute("userId", userId);

        // Need a way to get the Players Chosen Card to then display that card in the Waiting room page
        // Then need to edit the js in the battleQue.html to get the correct object
        return "battleQue";
    }

    @PostMapping("/battlequeue/{id}/{userId}")
    public String battleQueue(@PathVariable Long id, @PathVariable Long userId, Model model) {
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
                model.addAttribute("userId", userId);
                return "battleComplete";
            } else {
                // make the user wait more for enough players
                model.addAttribute("battleQueNum", id);
                model.addAttribute("userId", userId);
                return "battleQue";
            }
        } else {
            // if the user has been in a battle that's been completed
            model.addAttribute("completedBattle", completedBattle);
            model.addAttribute("battleQueNum", id);
            model.addAttribute("userId", userId);
            return "battleComplete";
        }
    }
}
