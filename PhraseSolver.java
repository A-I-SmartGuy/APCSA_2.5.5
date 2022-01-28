/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;
  private int currentPlayer;
  private Scanner input;
  private boolean correct;
  private int total1;
  private int total2;
  private Board board;


  /* your code here - constructor(s) */ 
  public PhraseSolver() {
    solved = false;
    currentPlayer = 1;
    input = new Scanner(System.in);
    correct = true;
    player1 = new Player("1");
    player2 = new Player("2");
    total1 = 0;
    total2 = 0;
    board = new Board();
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {

    System.out.println("Welcome, " + player1.getName() + " and " + player2.getName() + ", here is the outline of the phrase:");

    while (!solved) 
  {
      System.out.println(board.getSolvedPhrase());
      System.out.print("Guess a letter, " + player1.getName() + ": ");
      String firstInput = input.nextLine();
      if (board.guessLetter(firstInput)) {
        board.setLetterValue();
        total1+=board.getLetterValue();
        System.out.println("Nice job! You got: " + board.getLetterValue() + " points. " + total1 + " in total now for " + player1.getName() +".\n");
      } else {
        System.out.println("Sorry, that is not in the phrase. " + total1 + " in total now for " + player1.getName() +".\n");
      }

      if(board.isSolved()) {
        solved = true;
        System.out.println("\n\n");
        if(total1 > total2) {
          System.out.println("Congrats! You guys solved the phrase, and " + player1.getName() +" won with a " + (total1 - total2) + " point lead!    " + player1.getName() + ": " + total1 + "    " + player2.getName() + ": " + total2);
        } else if (total2 > total1) {
          System.out.println("Congrats! You guys solved the phrase, and " + player2.getName() +" won with a " + (total2 - total1) + " point lead!    " + player1.getName() + ": " + total1 + "    " + player2.getName() + ": " + total2);
        } else {
          System.out.println("No way! " + player1.getName() + " and " + player2.getName() + " tied at a score of " + total1 + "!");
        }
        return;
      }

      System.out.println(board.getSolvedPhrase());
      System.out.print("Guess a letter, " + player2.getName() + ": ");
      String secondInput = input.nextLine();
      if (board.guessLetter(secondInput)) {
        board.setLetterValue();
        total2+=board.getLetterValue();
        System.out.println("Nice job! You got: " + board.getLetterValue() + " points. " + total2 + " in total now for " + player2.getName() +".\n");
      } else {
        System.out.println("Sorry, that is not in the phrase. " + total2 + " in total now for " + player2.getName() +".\n");
      }
      
      /* your code here - determine how game ends */
      if(board.isSolved()) {
        solved = true;
        System.out.println("\n\n");
        if(total1 > total2) {
          System.out.println("Congrats! You guys solved the phrase, and " + player1.getName() +" won with a " + (total1 - total2) + " point lead!\n" + player1.getName() + ": " + total1 + "    " + player2.getName() + ": " + total2);
        } else if (total2 > total1) {
          System.out.println("Congrats! You guys solved the phrase, and " + player2.getName() +" won with a " + (total2 - total1) + " point lead!\n" + player1.getName() + ": " + total1 + "    " + player2.getName() + ": " + total2);
        } else {
          System.out.println("No way! " + player1.getName() + " and " + player2.getName() + " tied at a score of " + total1 + "!");
        }
        return;
      }
    } 
  }
}