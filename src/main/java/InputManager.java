import java.io.InputStream;
import java.util.Scanner;

public class InputManager {
    public static String getInput(InputStream input, String message) {
        Scanner in = new Scanner(input);
        return in.nextLine();
    }
}
