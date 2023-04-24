import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HangmanTest {
    Hangman testHangman;

    @BeforeEach
    void init() {
        testHangman = new Hangman();
        testHangman.setup(0);
    }

    @Test
    public void hangmanStartsWithWord() {
        assertTrue(testHangman.getWord().length() > 0);
    }

    @Test
    public void startingDisplayWord() {
        String word = testHangman.getWord();
        assertEquals(word.length(), testHangman.getDisplayWord().length());
    }

    @Test
    public void displayWordUpdatesOnCorrectGuess() {
        String testGuessFirstLetter = testHangman.getWord().substring(0, 1);

        testHangman.checkPlayerGuess(testGuessFirstLetter);
        String firstDisplayWordLetter = testHangman.getDisplayWord().substring(0, 1);

        assertEquals(testGuessFirstLetter, firstDisplayWordLetter);
    }

    @Test
    public void incorrectGuessLeavesDisplayWordUnchanged() {
        String initialDisplayWord = testHangman.getDisplayWord();

        testHangman.checkPlayerGuess("z");
        assertEquals(initialDisplayWord, testHangman.getDisplayWord());
    }

    @Test
    public void incorrectGuessIsStored() {
        String testGuess = "z";

        testHangman.checkPlayerGuess(testGuess);
        assertEquals(testGuess, testHangman.getIncorrectGuesses());
    }

    @Test
    public void incorrectGuessIsCounted() {
        String testGuess = "z";

        testHangman.checkPlayerGuess(testGuess);
        assertEquals(1, testHangman.incorrectGuessCount());
    }

    @Test
    public void hangedManUpdatesAfterIncorrectGuess() {
        String initialState = testHangman.getHangedMan();
        String testGuess = "z";

        testHangman.checkPlayerGuess(testGuess);
        assertNotEquals(initialState, testHangman.getHangedMan());
    }
}
