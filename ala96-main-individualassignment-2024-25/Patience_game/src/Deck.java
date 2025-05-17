import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;


    /**
     *
     */
    public Deck(){
        deck = new ArrayList<>();
        Card cardTemplate = new Card ("C","8");
        ArrayList<String> suits = cardTemplate.getPerfectSuits();
        ArrayList<String> numbers = cardTemplate.getPerfectNumbers();

        for (int i = 0; i < suits.size(); i++){
            for (int j = 0; j < numbers.size(); j++){
                deck.add(new Card(suits.get(i),numbers.get(j)));
            }
        }
    }

    /**
     * sHUuffles cards useing 
     */
    public void shuffle() {
        java.util.Random random = new java.util.Random();


        for (int i = deck.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    public Card dealCard(){
        if (deck.size() == 0){
            return null;
        }
        return deck.remove(0);
    }

    public boolean isEmpty(){
        return deck.isEmpty();
    }
    public int size(){
        return deck.size();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public String toString() {
        return deck.toString();
    }
}