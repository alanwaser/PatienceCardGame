import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlayerScore{

    private String profile_score = "score.txt";

    public ArrayList<PlayerInfo> readPlayers() {
        ArrayList<PlayerInfo> players = new ArrayList<>();
        try (FileReader fileReader = new FileReader(profile_score);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] each = line.split(",");//splits each string inbetween commmas into parts of the array that can then be read
                if (each.length == 4) {
                    String name = each[0];
                    int score = Integer.parseInt(each[1]);
                    int bestScore = Integer.parseInt(each[2]);
                    int numGames = Integer.parseInt(each[3]);

                    PlayerInfo player = new PlayerInfo(name, score, numGames, bestScore);
                    players.add(player);
                }
            }
        } catch (IOException e) {
        }
        return players;
    }

    public void saveScore(PlayerInfo player) {
        ArrayList<PlayerInfo> players = readPlayers();
        boolean playerFound = false;

        for (int i = 0; i < players.size(); i++) {
            PlayerInfo existingPlayer = players.get(i);
            if (existingPlayer.getName().equals(player.getName())) {
                existingPlayer.setScore(player.getScore());
                existingPlayer.bestScoreReal(player.getScore());
                existingPlayer.everyGamePlayed();
                playerFound = true;
                break;
            }
        }

        if (!playerFound) {
            players.add(player);
        }

        try {
            FileWriter newFile = new FileWriter(profile_score);
            BufferedWriter bufferedWriter = new BufferedWriter(newFile);
            for (PlayerInfo p : players) {
                bufferedWriter.write(p.getName() + "," + p.getScore() + "," + p.getBestScore() + "," + p.getNumGames());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            System.out.println("Score saved");
        } catch (IOException e) {
            System.out.println("Error saving score");
        }
    }

    public ArrayList<PlayerInfo> getTopTenPlayers() {
        ArrayList<PlayerInfo> players = readPlayers();

        Collections.sort(players, new Comparator<PlayerInfo>() {
            public int compare(PlayerInfo p1, PlayerInfo p2) {
                return Integer.compare(p1.getBestScore(), p2.getBestScore());
            }
        });

        ArrayList<PlayerInfo> topTen = new ArrayList<>();
        for (int i = 0; i < Math.min(10, players.size()); i++) {
            topTen.add(players.get(i));
        }

        return topTen;
    }
}