
import java.util.Random;

public class WordProvider
{

    private static String[] randomWords = new String[] {"moon", "train", "fire",
            "army", "islam", "Allah"};

    public static String chooseRandomWord()
    {

        Random rand = new Random();

        int wordIndex = rand.nextInt(randomWords.length);
        return (String)randomWords[wordIndex];
    }
}

