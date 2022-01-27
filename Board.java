/*
 * Activity 2.5.3
 *
 * A Board class to the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String phrase = "";
  private String solvedPhrase = "";
  private int currentLetterValue;

  /* your code here - constructor(s) */ 
  public Board() {
    phrase = loadPhrase();
    solvedPhrase = getSolvedPhrase();
  }

  public String getPhrase() {
    return phrase;
  }
  public String getSolvedPhrase() {
    return solvedPhrase;
  }
  public int getLetterValue() {
    return currentLetterValue;
  }
  


  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved()
  {
    if (phrase.replace(" ", "").equalsIgnoreCase(solvedPhrase.replace(" ", "")))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  
// Description: Takes in the one letter guess and then detects if it is in 
// the phrase or not and where. It will return false if the guess is not in 
// the phrase and true if it is. It also replaces that letter into the part 
// of the phrase that it is supposed to go.
// 
// Pre-conditions: The phrase is set to a string value and the guess is set 
// to a string value but is a single character.
// 
// Post-conditions: True is returned if the guess is found in the phrase, and
// the solvedPhrase has the spots with the guess added on.
  public boolean guessLetter(String guess)
  {
    // This is the boolean that is returned at the end, so it sets it to false now to be set true later
    boolean foundLetter = false;
    // Makes a newSolvedPhrase string as a placeholder for the phrase in this method
    String newSolvedPhrase = "";
    
    // iterates as many times as phrase's length with i incrementing by 1
    for (int i = 0; i < phrase.length(); i++)
    {
      // checks to see if at a certain letter on phrase is equal to the guess
      if (phrase.substring(i, i + 1).equals(guess))
      {
        // adds the guessed letter onto the placeholder string since they guessed correctly
        newSolvedPhrase += guess + " ";
        // has the method return true since the letter was found in the phrase
        foundLetter = true;
      }
      else
      {
        // reverts newSolvedPhrase to what solvedPhrase is for the current letter i is trying to represent
        // it needs to be multiplied by 2 because of the spaces between each letter
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    // sets the newSolvedPhrase to solved phrase so that it can be more permanent and not the temporary variable
    solvedPhrase = newSolvedPhrase;
    // returns true or false depending on if the guessed letter was found
    return foundLetter;
  } 
} 