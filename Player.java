/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
    private String name;
    private int points;

    public Player(String inputName) {
        if(inputName == "1") {
            System.out.println("Enter first player name:");
        } else if (inputName == "2") {
            System.out.println("Enter second player name:");
        }
        
        Scanner sc = new Scanner(System.in);
        String newName = sc.nextLine();

        name = newName;
        points = 0;
        System.out.println("Hello " + newName + ", and welcome to hangman 2.0 \n");
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addToPoints(int value) {
        points = points + value;
    }
}