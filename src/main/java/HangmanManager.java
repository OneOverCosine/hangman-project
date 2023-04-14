import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HangmanManager {

    private static final String[] hangedManStates = loadHangedManStates();

    public static String[] loadHangedManStates(){
        StringBuilder fileOutput = new StringBuilder();
        try{
            File file = new File("src/hangmanStates.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) fileOutput.append(reader.nextLine());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileOutput.toString().split("\\.");
    }

    public static String getCurrentHangedMan(int incorrectGuessCount) {
        return hangedManStates[incorrectGuessCount];
    }
}
