import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class DiceGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many players are in the game?");
        int numPlayers = input.nextInt();

        System.out.println("How many sides are on the dice?");
        int numSides = input.nextInt();

        Player[] players = new Player[numPlayers];

        for (int i = 1; i <= numPlayers; i++) {

            System.out.println("Enter name for Player " + i + ": ");
            String name = input.next();

            Die playerDie = new Die(numSides);

            players[(i - 1)] = new Player(name, playerDie);
        }

        File diceGameOutput = new File("DiceGameOutput.txt");
        try{
            FileWriter fileWriter = new FileWriter(diceGameOutput);

        for (Player player : players) {
            Die playerDie = player.getDie();

            fileWriter.write("\n" + player.getName() + " rolled a " +
                    playerDie.roll() + " on a " + numSides + " sided die.");
        }
        String winner = decideWinner(players).getName();
        fileWriter.write("\n" + winner + " won the game!");
        fileWriter.close();

    } catch(IOException e){
            System.out.println(e.getMessage());
        }}

        public static Player decideWinner(Player[] players){

            ArrayList<Integer> compareValues = new ArrayList<>();
            int dieValue;

            for (Player player : players) {
                Die playerDie = player.getDie();
                dieValue = playerDie.getValue();
                compareValues.add(dieValue);
            }
            int maxValue = 0;

            for (int compareValue : compareValues) {
                if (compareValue > maxValue) {
                    maxValue = compareValue;
                }
            }
            return players[compareValues.indexOf(maxValue)];
        }

        }



