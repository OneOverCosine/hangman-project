import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HangmanHelper {

    private static final String[] hangedManStates = loadHangedManStates();

    public static String[] loadHangedManStates(){
        StringBuilder fileOutput = loadFile("hangmanStates.txt");
        return fileOutput.toString().split("\\.");
    }

    public static String getCurrentHangedMan(int incorrectGuessCount) {
        return hangedManStates[incorrectGuessCount];
    }

    private static StringBuilder loadFile(String filename) {
        StringBuilder fileOutput = new StringBuilder();
        try {
            File file = new File("resources/" + filename);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) fileOutput.append(reader.nextLine());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileOutput;
    }
}
