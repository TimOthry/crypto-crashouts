package cc.hackathon.shef.uk.cryptocrashouts;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.util.Scanner;

/**
 * Class for testing. Can be deleted later
 */
public class TestBattling {
    public static void main(String[] args) throws IOException {
        // test getting crypto balance
        System.out.println(Dotenv.configure().load().get("API_KEY"));
        System.out.println(Wallet.btcWalletValue("34xp4vRoCGJym3xR7yCVPFHoCNxv4Twseo"));
        System.out.println(Wallet.ethWalletValue("0x00000000219ab540356cBB839Cbe05303d7705Fa"));
        System.out.println(Wallet.dogeWalletValue("DEgDVFa2DoW1533dxeDVdTxQFhMzs1pMke"));

        // test reading a wallet csv and then print it out
        Player player1 = new Player("src/main/resources/testWallet.csv");
        System.out.println(player1.toString());

        Player player2 = new Player("src/main/resources/testWallet2.csv");
        System.out.println(player2.toString());
        String again = "y";

        while (again.equals("y")) {
            // Battle the two players with a card
            System.out.println("\n\n--- Battle Commences!! ---\n");

            // player 1 enters their card
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter player 1's card: ");
            String p1Card = keyboard.nextLine();

            // player 2 enters their card
            System.out.println("\nEnter player 2's card: ");
            String p2Card = keyboard.nextLine();

            Battle battle = new Battle(player1, player2);
            battle.battleTwoCards(p1Card, p2Card);

            if (battle.getWinner() == 1) {
                System.out.println("Player 1 wins!");
            } else if (battle.getWinner() == 2) {
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("Draw!");
            }

            // see if the user wants to play again
            System.out.println("\n Play again? (y/n) ");
            again = keyboard.nextLine();
        }
    }
}
