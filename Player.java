/**
 * Basic player class
 * @author Sean Wunderlich
 * @version 1.0
 * ITSE 1302-011
 */

package blackjack;

public class Player {

    static int intTotalNumberOfPlayers = 0;
    private ArrayList<Card> aryHand = new ArrayList<Card>();
    int intCurrentBet = 0;
    int intMoney = 2000;
    String strName = "no one";

    /**
     * Default constructor that adds players by number.
     */
    public Player() {
        name(++intTotalNumberOfPlayers);
    }

    /**
     * Constructor that sets the players name.
     */
    public Player(String pstrName) {
        name(pstrName);
    }

    /**
     * Sets the players name base on a number.
     * @param intPlayerNumber int The number of the player.
     */
    public void name(int intPlayerNumber) {
        name("Player " + intPlayerNumber);
    }

    /**
     * Sets the players name base on a string.
     * @param pstrName String The name of the player.
     */
    public void name(String pstrName) {
        strName = pstrName;
    }

    /**
     * Get the player name.
     * @return String The players name.
     */
    public String name() {
        return strName;
    }

    /**
     * Sets the money value for the player.
     * @param pintMoney int Money value to set for the player.
     */
    public void setMoney(int pintMoney) {
        intMoney = pintMoney;
    }

    /**
     * Get the current money the player has.
     * @return int Players current money.
     */
    public int getMoney() {
        return intMoney;
    }

    /**
     * Sets the current bet for the player.
     * @param intBet int The bet amount.
     */
    public void setBet(int intBet) {
        intCurrentBet = intBet;
    }

    /**
     * Simple check to see if the player has money.
     * @return boolean True player has money, false otherwise.
     */
    public boolean hasMoney() {
        return (getMoney() > 0);
    }

    /**
     * Function to prompt user for the bet taking into consideration
     *  the amount of money they have.
     */
    public void inputBet() {
        int intBet = 0;
        setBet(0);
        Scanner objScanner = new Scanner(System.in);
        do {
            System.out.println(toString());
            System.out.print("Please enter your bet: ");
            intBet = objScanner.nextInt();
        } while(intBet > getMoney() || intBet < 1);
        setBet(intBet);
    }

    /**
     * Gets the players current bet.
     * @return int The bet amount.
     */
    public int getBet() {
        return intCurrentBet;
    }

    /**
     * Calculates the total face value of the cards in the players hand.
     * @return int The total face value of the cards.
     */
    public int getTotalFaceValue() {
        int intFaceValueTotal = 0;
        int intCurrentCard = 0;
        Card objCard = null;
        boolean hasAce = false;
        while(intCurrentCard < aryHand.size()){
            objCard = aryHand.get(intCurrentCard);
            intFaceValueTotal += objCard.getFaceValue();
            if(objCard.getFace() == 1) {
                hasAce = true;
            }
            intCurrentCard++;
        }

        if(hasAce && intFaceValueTotal <= 11) {
            intFaceValueTotal += 10;
        }

        return intFaceValueTotal;
    }

    /**
     * Adds a card to the players hand.
     * @param objCard Card Card to add to players hand.
     */
    public void addCard(Card objCard) {
        aryHand.add(objCard);
    }

    /**
     * Clears the players current hand.
     */
    public void clearHand() {
        aryHand.clear();
    }

    /**
     * Prints out the current hand information.
     */
    public void printHand() {
        System.out.println(aryHand + " Total: " + getTotalFaceValue());
    }

    /**
     * Prints out the current player money information.
     */
    public void printMoney() {
        System.out.println("Total: $" + getMoney() + "\tBet: $" + getBet());
    }

    /**
     * Returns the number of cards in the players hand.
     * @return int The number of cards the player currently has.
     */
    public int getNumberOfCards() {
        return aryHand.size();
    }

    /**
     * Returns all the details about the player as a string.
     * @return String String containing all the player information.
     */
    public String toString() {
        return "\n" + name() + ": " + aryHand + " Total: " + getTotalFaceValue() + "\n" +
                "Total: $" + getMoney() + "\tBet: $" + getBet();
    }
}
