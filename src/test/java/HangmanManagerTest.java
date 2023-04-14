import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class HangmanManagerTest {
    @Test
    public void hangmanStatesLoadWithCorrectFormat() {
        String[] testStates = HangmanManager.loadHangedManStates();
        String expected = "|\\n" +
                "|\\n" +
                "|\\n" +
                "|\\n" +
                "|___";

        assertTrue(expected.equals(testStates[0]));
    }
}
