import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HangmanManager {
    public static String[] loadHangedManStates(){
        StringBuilder fileOutput = new StringBuilder();
        try{
            File file = new File("src/hangmanStates.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) fileOutput.append(reader.nextLine());
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return fileOutput.toString().split("\\.");
    }
}
