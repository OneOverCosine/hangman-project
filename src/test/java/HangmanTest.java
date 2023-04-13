import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HangmanTest {
    @Test
    public void hangmanStartsWithWord() {
        Hangman testHangman = new Hangman();
        assertTrue(testHangman.getWord().length() > 0);
    }

    @Test
    public void startingDisplayWord() {
        Hangman testHangman = new Hangman();
        String word = testHangman.getWord();
        assertEquals(word.length(), testHangman.getDisplayWord().length());
    }
}
