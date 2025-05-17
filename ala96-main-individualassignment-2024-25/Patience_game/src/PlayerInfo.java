public class PlayerInfo extends Player {

    private int bestScore;
    private int numGames;

    public PlayerInfo(String name, int score, int numGames, int bestScore) {
        super(name, score);
        this.bestScore = bestScore;
        this.numGames = numGames;
    }

    public PlayerInfo(String name, int score) {
        super(name, score);
        this.bestScore = score;
        this.numGames = 1;
    }

    public void bestScoreReal(int newScore) {
        if (newScore < this.bestScore) {
            this.bestScore = newScore;
        }
    }

    public int getBestScore() {
        return bestScore;
    }

    public void everyGamePlayed(){
        numGames++;
    }

    public int getNumGames() {
        return numGames;
    }


    public String toString() {
        return "Games Played: " + numGames + " Best Score: " + bestScore;
    }

}