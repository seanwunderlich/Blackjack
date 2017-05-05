/**
 * Blackjack instance
 * @author Sean Wunderlich
 * @version 1.0
 * ITSE 1302-011
 */

package blackjack;
import java.util.ArrayList;

/**
 * Class stub out for the beginning of a blackjack game.
 */

public class BlackJack {

    /**
     * Just a simple starting point for the class and it
     * starts by playing a round.
     */

    public static void main(String[] strArgs) {
        BlackJack objGame = new BlackJack();
        objGame.playRound();
    }

    /**
     * Simple dealer logic to hard stop at 16.
     *
     * @param objDealer Player Player you want to add cards to until they get over 16.
     * @param objDeck   Deck Deak you want to get cards from.
     * @return Player Player instance with new cards added.
     */
    public Player dealerLogic(Player objDealer, Deck objDeck) {
        return dealerLogic(objDealer, objDeck, 16);
    }

    /**
     * Simple dealer logic to hard stop at a certain point.
     *
     * @param objDealer Player Player you want to add cards to until they get over intStop.
     * @param objDeck   Deck Deak you want to get cards from.
     * @param intStop   int The total face value that stops the cards from being added.
     * @return Player Player instance with new cards added.
     */
    public Player dealerLogic(Player objDealer, Deck objDeck, int intStop) {
        while (objDealer.getTotalFaceValue() <= intStop &&
                objDealer.getNumberOfCards() < 4) {
            objDealer.addCard(objDeck.getCard());
        }
        return objDealer;
    }

    /**
     * Incomplete concept of how you might play one round of blackjack.
     */
    public void playRound() {
        //TODO: Gut this logic and add your own function calls to play your own version of BlackJack.

        Deck objDeck = new Deck();
        objDeck.shuffle();

        ArrayList<Player> aryPlayers = new ArrayList<Player>();
        aryPlayers.add(new Player());
        aryPlayers.add(new Player());
        Player objDealer = new Player("Dealer");
        objDealer.setMoney(0);
        aryPlayers.add(objDealer);

        int intCurrentPlayer = 0;

        int intCounter = 0;
        while (intCounter < 2) {
            intCurrentPlayer = 0;
            while (intCurrentPlayer < aryPlayers.size()) {
                aryPlayers.get(intCurrentPlayer).addCard(objDeck.getCard());
                intCurrentPlayer++;
            }
            intCounter++;
        }

        intCurrentPlayer = 0;
        while (intCurrentPlayer < aryPlayers.size()) {
            if (aryPlayers.get(intCurrentPlayer).hasMoney()) {
                System.out.println(objDealer);
                aryPlayers.get(intCurrentPlayer).inputBet();
            }
            intCurrentPlayer++;
        }

        this.dealerLogic(objDealer, objDeck);

        System.out.println(aryPlayers);

        if (objDeck.shouldShuffle()) {
            objDeck.shuffle();
        }
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.printHand();


    }
}