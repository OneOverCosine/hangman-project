import java.io.InputStream;

public class Hangman {

    private String word = "hello";
    private String compareWord = word;
    private String displayWord = "_".repeat(word.length());
    private String incorrectGuesses = "";
    private final String[] hangedManStates = HangmanHelper.loadHangedManStates();

    public String getWord() {
        return word;
    }

    public String getDisplayWord() {
        return displayWord;
    }

    public String getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public int incorrectGuessCount() {
        return incorrectGuesses.length();
    }

    public String getHangedMan() {
        // might not need this
        return hangedManStates[incorrectGuessCount()];
    }

    public void checkPlayerGuess(String guess) {
        if (!compareWord.contains(guess)) {
            incorrectGuesses += guess;
            return;
        }
        updateDisplayWord(guess);
    }

    public void updateDisplayWord(String guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(0, 1).equals(guess)) {
                displayWord = updateWord(i, guess, displayWord);
            }
        }
    }

    public String updateWord(int replaceFrom, String replaceWith, String word) {
        StringBuilder newString = new StringBuilder(word);
        newString.replace(replaceFrom, replaceFrom+1, replaceWith);
        return newString.toString();
    }

    public void mainMenu() {
        String choice = "";
        while (!"3".equals(choice)) {
            choice = InputManager.getInput(System.in, HangmanHelper.menu);
            switch (choice) {
                case "1":
                    play(0);
                    break;
                case "2":
                    System.out.println("Play hard mode");
                    break;
                case "3":
                    System.out.println("Closing game");
                    break;
                default:
                    System.out.println(choice);
            }
        }
    }

    public boolean gameOver() {
        return this.word.equals(this.displayWord) || incorrectGuessCount() == this.hangedManStates.length;
    }

    public String currentGameState() {
        StringBuilder currentState = new StringBuilder();
        currentState.append(getHangedMan());
        currentState.append(this.displayWord);
        currentState.append(" || Incorrect guesses: ");
        currentState.append(incorrectGuesses);
        currentState.append("%n%nYour guess: ");
        return currentState.toString();
    }

    public void play(int difficulty) {
        // get word based on difficulty

        // do the following until the word is guessed correctly or the incorrect guesses reach 8
        while(!gameOver()) {
            // 1. show the current game state 2. let the player make a guess
            String input = InputManager.getInput(System.in, currentGameState());
            // 3. check the guess
            checkPlayerGuess(input);
            // 4. update the state as needed
        }
    }
}
