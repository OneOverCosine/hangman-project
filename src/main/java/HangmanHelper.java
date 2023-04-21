import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HangmanHelper {

    static final String menu = loadMenu();

    public static String[] loadHangedManStates() {
        StringBuilder fileOutput = loadFile("hangmanStates.txt");
        return fileOutput.toString().split("\\.");
    }

    public static String loadMenu() {
        return String.valueOf(loadFile("menu.txt"));
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
