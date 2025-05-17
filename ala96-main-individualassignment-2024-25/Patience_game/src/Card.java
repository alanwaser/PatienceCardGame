import java.util.ArrayList;

public class Card {


    /**
     * Card class represents a suit and a number value of a card from the deck
     */
    private String suits;
    private String numbers;


    /**
     * makes a card with suit and class
     * @param suit this will include the values D,H,S,C
     * @param number includes 2,3,4,5,6,7,8,9,10,J,Q,K
     */
    public Card(String suit, String number) {
    this.suits = suit;
    this.numbers = number;
    }
    /**
     * Valid suits here = clubs, spades, diaomonds, hearts
     */
    public void setSuits(String suits) {
        suits = suits.toUpperCase();
        ArrayList<String> validSuit = getPerfectSuits();

        boolean found = false;
        for (String name : validSuit) {
            if (name.equals(suits)) {
                found = true;
                break;
            }
        }
        if (found) {
            this.suits = suits;
        }else{
            throw new IllegalArgumentException("Valid suits are: "+
                    validSuit);
        }
    }

    /**
     * returns a suit for the card
     * @return S,D,H,C
     */
    public String getSuits() {
        return this.suits;
    }

    public static ArrayList<String> getPerfectSuits() {
        ArrayList<String> perfectSuits = new ArrayList<>();
        perfectSuits.add("S");
        perfectSuits.add("H");
        perfectSuits.add("C");
        perfectSuits.add("D");
        return perfectSuits;
    }

    /**
     * Sets numbers to the cards
     * @param numbers
     */
    public void setNumbers(String numbers) {
        numbers = numbers.toLowerCase();
        ArrayList<String> validNumber = getPerfectNumbers();

        boolean found = false;
        for (String name : validNumber) {
            if (name.equals(numbers)) {
                found = true;
                break;
            }
        }
        if (found) {
            this.numbers = numbers;
        }else{
            throw new IllegalArgumentException("Valid numbers are: "+
                    validNumber);
        }

    }

    /**
     * gets the number value that was set to it
     * @return 2,3,4,5,6,7,8,9,10,J,Q,K
     */

    public String getNumbers(){

        return this.numbers;
    }

    public static ArrayList<String> getPerfectNumbers() {
        ArrayList<String> perfectNumbers = new ArrayList<>();
        perfectNumbers.add("2");
        perfectNumbers.add("3");
        perfectNumbers.add("4");
        perfectNumbers.add("5");
        perfectNumbers.add("6");
        perfectNumbers.add("7");
        perfectNumbers.add("8");
        perfectNumbers.add("9");
        perfectNumbers.add("10");
        perfectNumbers.add("j");
        perfectNumbers.add("q");
        perfectNumbers.add("k");
        perfectNumbers.add("a");
        return perfectNumbers;
    }

    /**
     * Returns string of the card class
     * @return returns the full card with both the suit and the number in one for example 3s
     */

    public String toString() {

        return numbers + suits;
    }
}




