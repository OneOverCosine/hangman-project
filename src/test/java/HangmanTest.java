import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class HangmanTest {
    @Test
    public void hangmanStartsWithWord() {
        Hangman testHangman = new Hangman();
        assertTrue(testHangman.getWord().length() > 0);
    }
}
