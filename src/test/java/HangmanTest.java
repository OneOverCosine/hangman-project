import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        assertEquals(word.length(), testHangman.showDisplayWord().length());
    }

    @Test
    public void displayWordUpdatesOnCorrectGuess() {
        Hangman testHangman = new Hangman();
        String testGuessFirstLetter = testHangman.getWord().substring(0, 1);

        testHangman.checkPlayerGuess(testGuessFirstLetter);
        String firstDisplayWordLetter = testHangman.showDisplayWord().substring(0, 1);

        assertEquals(testGuessFirstLetter, firstDisplayWordLetter);
    }

    @Test
    public void incorrectGuessLeavesDisplayWordUnchanged() {
        Hangman testHangman = new Hangman();
        String initialDisplayWord = testHangman.showDisplayWord();

        testHangman.checkPlayerGuess("z");
        assertTrue(initialDisplayWord.equals(testHangman.showDisplayWord()));
    }

    @Test
    public void incorrectGuessIsStored() {
        Hangman testHangman = new Hangman();
        String testGuess = "z";

        testHangman.checkPlayerGuess(testGuess);
        assertEquals(testGuess, testHangman.getIncorrectGuesses());
    }

    @Test
    public void incorrectGuessIsCounted() {
        Hangman testHangman = new Hangman();
        String testGuess = "z";

        testHangman.checkPlayerGuess(testGuess);
        assertEquals(1, testHangman.incorrectGuessCount());
    }

    @Test
    public void hangedManUpdatesAfterIncorrectGuess() {
        Hangman testHangman = new Hangman();
        String initialState = testHangman.getHangedMan();
        String testGuess = "z";

        testHangman.checkPlayerGuess(testGuess);
        assertFalse(initialState.equals(testHangman.getHangedMan()));
    }
}
