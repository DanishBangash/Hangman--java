import java.io.*;
import java.util.*;
public class GameStarter
{
    private Game game;
    private String exit = "";
    public GameStarter()
    {
        String chosenWord = WordProvider.chooseRandomWord();
        game = new Game(chosenWord);
    }
    public void startGame()
    {
        String restart = "yes";
        Scanner scan = new Scanner (System.in);
        String value;
        char[] valueChars;
        while(restart.toLowerCase().equals("yes"))
        {
            String chosenWord = WordProvider.chooseRandomWord();
            game = new Game(chosenWord);
            System.out.println("Welcome to Hangman. The game has started");
            System.out.println("Guess the word: " + game.getGuessWord());
 
            value = scan.next(); 
            valueChars = value.toCharArray();
            while(!value.toLowerCase().equals("exit"))
            {
                if(value.length() == 1)
                {
                    String mes = game.guessLetter(valueChars[0]);
                    System.out.println(mes);
                    System.out.println(game.getGuessWord());
                }
                else
                    System.out.println("Type a single character!");
                if(game.isHanged() || game.isGameOver())
                {
                    String waitForAnswer = "";
                    while(!(waitForAnswer.toLowerCase().equals("yes") || waitForAnswer.toLowerCase().equals("no")))
                    {
                        System.out.println("Do you want to restart the game? yes/no");
                        waitForAnswer = scan.next();
                        int a =0;
                    }
                    restart = waitForAnswer;
                    break;
                }
                else
                {
                    value = scan.next(); 
                    valueChars = value.toCharArray();
                }
            }
        }
    }
}