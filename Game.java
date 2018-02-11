public class Game
{
    private String chosenWord;
    private String guessWord;
    private String guesses = "";
    private int triesCount;
    private int TOTAL_TRIES;

    public Game(String chosenWord)
    {
        TOTAL_TRIES = 6;
        this.chosenWord = chosenWord.toLowerCase();
        InitializeGuessWord();
    }
    public String getGuessWord()
    {
        return guessWord;
    }
    private void InitializeGuessWord()
    {
        guessWord = "";
        for(int i=0; i<chosenWord.length(); i++)
        {
            guessWord = guessWord + "-";
        }
    }
    public boolean isHanged()
    {
        if (triesCount >= TOTAL_TRIES)
            return true;
        else
            return false;
    }
    public boolean isGameOver()
    {
        boolean over;
        if (chosenWord.equals(guessWord))
            over = true;
        else
            over = false;
        return over;
    }
    public String guessLetter(char letter)
    {
        String mes = "";
        if(guesses.indexOf(letter) > -1)
        {
            mes = "You have already used letter: " + letter;
        }
        else if( guess(letter))
        {
            mes = "Correct guess! You have " + (TOTAL_TRIES - triesCount) + " guesses left.";
        }
        else
        {
            if(isHanged())
                mes = "Game over. You got hanged!";
            else if(isGameOver())
                mes = "Game over. You won!";
            else
                mes ="Wrong guess. You have " + (TOTAL_TRIES - triesCount) + " guesses left.";
        }
        if(isHanged())
            mes = "Game over. You got hanged!";
        else if(isGameOver())
            mes = "Game over. You won!";
        if(guesses.indexOf(letter) <= -1)
            guesses = guesses + letter;
        return mes;
    }
    private boolean guess(char letter)
    {
        if(chosenWord.indexOf(letter) > -1)
        {
            char[] chosenWordChars = chosenWord.toCharArray();
            char[] guessWordChars = guessWord.toCharArray();
            for(int i=0; i<chosenWordChars.length; i++)
            {
                if(chosenWordChars[i] == letter)
                    guessWordChars[i] = letter;
            }
           
            guessWord = new String(guessWordChars);
            return true;
        }
        else
        {
            triesCount = triesCount + 1;
            return false;
        }
    }
}