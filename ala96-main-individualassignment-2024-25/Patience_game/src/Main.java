import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private final Deck deck;
    private final ArrayList<Card> pile;
    private final PlayerScore playerScore;

    public Main() {
        deck = new Deck();
        pile = new ArrayList<>();
        playerScore = new PlayerScore();
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.startGame();
    }

    public void startGame() {
        boolean running = true;

        while (running) {
            System.out.println("    ********Patience Card Game Menu:********");
            System.out.println("    1 - Print the pack out  ");
            System.out.println("    2 - Shuffle");
            System.out.println("    3 - Deal a card");
            System.out.println("    4 - Make a move, move last pile onto previous one");
            System.out.println("    5 - Make a move, move last pile back over two piles");
            System.out.println("    6 - Amalgamate piles in the middle (starting with 1)");
            System.out.println("    7 - Print the displayed cards on the command line");
            System.out.println("    8 - Play for me once(if 2 possible moves makes the furthest one)");
            System.out.println("    9 - Play for me many times(if 2 possible moves makes the furthest one)");
            System.out.println("    10 - Display top 10 results");
            System.out.println("    Q - Quit");

            System.out.print("PLease enter the command:");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            String choice_Upper = choice.toUpperCase();

            switch (choice_Upper) {
                case "1":
                    showDeck();
                    break;
                case "2":
                    shuffleDeck();
                    break;
                case "3":
                    dealCard();
                    break;
                case "4":
                    movePileToAdjacent();
                    break;
                case "5":
                    movePileOverTwo();
                    break;
                case "6":
                    amalgamatePiles();
                    break;
                case "7":
                    showCardsInPlay();
                    break;
                case "8":
                    playOnce();
                    break;
                case "9":
                    playMany();
                    break;
                case "10":
                    topten();
                    break;
                case "Q":
                    quitGame();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void showDeck() {
        System.out.println("Deck:" + deck.toString());
    }

    public void shuffleDeck() {
        deck.shuffle();
        System.out.println("Deck shuffle has occured.");
    }
    public void dealCard() {
        if (deck.isEmpty()) {
            System.out.println("You don't have a cards left to deal.");
            return;
        } else {
            Card card = deck.dealCard();
            pile.add(card);
            System.out.println("Dealt card "+(card.toString()));
            showCardsInPlay();
        }
    }

    public void movePileToAdjacent() {
        if (pile.size()<2){
            System.out.println("You don't have enough cards in play to make a move");
        }else{
            int lastPileIndex = pile.size()-1;
            int twoPilesIndex = pile.size()-2;

            Card lastCard = pile.get(lastPileIndex);
            Card twoCard = pile.get(twoPilesIndex);

            if (lastCard.getNumbers().equals(twoCard.getNumbers()) || lastCard.getSuits().equals(twoCard.getSuits())){
                Card movingCard = pile.remove(lastPileIndex);
                pile.set(twoPilesIndex, movingCard);
                System.out.println(pile.toString());
            }else{
                System.out.println("Invalid move");
            }
        }
    }
    public void movePileOverTwo() {
        if (pile.size()<4){
            System.out.println("You don't have enough cards in play to make a move");
        }else{

            int lastPileIndex = pile.size()-1;
            int fourPilesIndex = pile.size()-4;
            Card lastCard = pile.get(lastPileIndex);
            Card fourCard = pile.get(fourPilesIndex);

            if(lastCard.getNumbers().equals(fourCard.getNumbers()) || lastCard.getSuits().equals(fourCard.getSuits())){
                Card movingCard = pile.remove(lastPileIndex);
                pile.set(fourPilesIndex, movingCard);
                System.out.println(pile.toString());
            }else{
                System.out.println("Invalid move");
            }
        }
    }
    public void amalgamatePiles() {
        Scanner scanner = new Scanner(System.in);
        if (pile.size()<2){
            System.out.println("You don't have enough cards in play to make a move");
        }else{
            System.out.println("Which pile is moveing?");
            int lastPileUserInput = Integer.valueOf(scanner.nextInt()) -1;
            if (lastPileUserInput < 0 || lastPileUserInput >= pile.size()) {
                System.out.println("Invalid pile number.");
            }
            System.out.println("Where is it moveing too?");
            int moveUserInput = Integer.valueOf(scanner.nextInt()) -1;
            if (moveUserInput < 0 || moveUserInput >= pile.size()) {
                System.out.println("Invalid pile number.");
            }
            if (lastPileUserInput <= moveUserInput){
                System.out.println("Invalid move");
            }else {
                Card lastUserCard = pile.get(lastPileUserInput);
                Card twoUserCard = pile.get(moveUserInput);
                if (lastPileUserInput == moveUserInput + 1) {
                    if (lastUserCard.getNumbers().equals(twoUserCard.getNumbers()) || lastUserCard.getSuits().equals(twoUserCard.getSuits())) {
                        Card movingCard = pile.remove(lastPileUserInput);
                        pile.set(moveUserInput, movingCard);
                        System.out.println(pile.toString());
                    } else {
                        System.out.println("Invalid move");
                    }
                }else if (lastPileUserInput == moveUserInput + 3) {
                    if (lastUserCard.getNumbers().equals(twoUserCard.getNumbers()) || lastUserCard.getSuits().equals(twoUserCard.getSuits())) {
                        Card movingCard = pile.remove(lastPileUserInput);
                        pile.set(moveUserInput, movingCard);
                        System.out.println(pile.toString());
                    } else {
                        System.out.println("Invalid move");
                    }
                }
            }
        }
    }
    public void showCardsInPlay() {
        if (pile.isEmpty()){
            System.out.println("There are no cards in play.`");
            return;
        }else{
            for (Card card : pile) {
                System.out.println(card.toString());
            }
        }
    }
    public void playOnce() {
        boolean running = false;
        if (pile.size()<2){
            System.out.println("You don't have enough cards in play to make a move");
        }else if (pile.size()>=4){
            for (int i = 0; i < pile.size() - 3; i++) {
                Card card = pile.get(i);
                Card twoCard = pile.get(i + 3);
                if (card.getNumbers().equals(twoCard.getNumbers()) || card.getSuits().equals(twoCard.getSuits())) {
                    Card movingCard = pile.remove(i + 3);
                    pile.set(i, movingCard);
                    System.out.println(pile.toString());
                    running = true;
                    break;
                }
            }
        }
        if (!running){
            for (int i = 0; i < pile.size() -1; i++) {
                Card card = pile.get(i);
                Card twoCard = pile.get(i + 1);

                if (card.getNumbers().equals(twoCard.getNumbers()) || card.getSuits().equals(twoCard.getSuits())) {
                    Card movingCard = pile.remove(i+1);
                    pile.set(i, movingCard);
                    System.out.println(pile.toString());
                    running = true;
                    break;
                }
            }
        }
        if (!running){
            System.out.println("No valid moves available");
        }

    }
    public void playMany() {
        while (pile.size() > 1) {
            boolean moveMade = false;
            int startingSize = pile.size();
            playOnce();
            if (pile.size() != startingSize) {
                moveMade = true;
            }
            if (!moveMade) {
                break;
            }
        }
        showCardsInPlay();
    }
    public void topten(){
        ArrayList<PlayerInfo> topten = playerScore.getTopTenPlayers();
        if (topten.isEmpty()){
            System.out.println("No one has played");
            return;
        }else{
            System.out.println("********TOP TEN PLAYERS********");
            for (int i = 0; i < topten.size(); i++) {
                PlayerInfo playerInfo = topten.get(i);
                System.out.println("NAME : " + playerInfo.getName());
                System.out.println("SCORE : " + playerInfo.getBestScore());
                System.out.println("NUM OF GAMES PLAYED : " + playerInfo.getNumGames());
            }
        }


    }
    public void quitGame() {
        if (!pile.isEmpty()){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name");
            String name = scanner.nextLine();

            PlayerInfo playerInfo = new PlayerInfo(name, pile.size());

            playerScore.saveScore(playerInfo);

            System.out.println("Game saved, thanks for playing!");
        }else{
            System.out.println("Not played");
        }
    }
}
