import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HangmanHelper {

    static final String menu = loadMenu();
    static final String[] words = loadWords();

    public static String getWord() {
        Random rand = new Random();
        return words[rand.nextInt(words.length)];
    }

    public static String[] loadHangedManStates() {
        StringBuilder fileOutput = loadFile("hangmanStates.txt");
        return fileOutput.toString().split("\\.");
    }

    public static String loadMenu() {
        return String.valueOf(loadFile("menu.txt"));
    }

    public static String[] loadWords() {
        String fileOutput = String.valueOf(loadFile("normal_words.txt"));
        return fileOutput.split("\\.");
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
