import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputManager {
    public static String getInput(InputStream input, String message) {
        System.out.printf(message);
        Scanner in = new Scanner(input);
        String userInput = in.nextLine();
        if(isValid(userInput)) return userInput;
        return "Invalid input";
    }

    public static Boolean isValid(String userInput) {
        // this needs work
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]");
        Matcher matcher = pattern.matcher(userInput);
        return matcher.find();
    }
}
