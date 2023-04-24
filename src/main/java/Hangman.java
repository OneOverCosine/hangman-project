public class Hangman {

    private String word;
    private String displayWord;
    private String incorrectGuesses;
    private final String[] hangedManStates = HangmanHelper.loadHangedManStates();

    public String getWord() {
        return word;
    }

    public String getDisplayWord() {return displayWord;}

    public String getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public String getHangedMan() {
        // might not need this
        return hangedManStates[incorrectGuessCount()];
    }

    public int incorrectGuessCount() {
        return incorrectGuesses.length();
    }

    public String showDisplayWord() {
        return displayWord.replace("", " ").trim();
    }

    public void checkPlayerGuess(String guess) {
        do {
            int index = this.word.indexOf(guess);
            if (index == -1) {
                this.incorrectGuesses += guess;
                return;
            }

            this.displayWord = updateWord(index, guess, this.displayWord);
            this.word = updateWord(index, "_", this.word);
        } while (this.word.contains(guess));
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
                    play(Integer.parseInt(choice));
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

    public int gameOver() {
        if (this.word.equals("_".repeat(this.word.length()))) return 2;
        else if (incorrectGuessCount() == this.hangedManStates.length) return 1;
        return 0;
    }

    public String currentGameState() {
        return getHangedMan() +
                showDisplayWord() + " || Incorrect guesses: " + incorrectGuesses +
                "%n%nYour guess: ";
    }

    public void setup(int difficulty) {
        this.word = "hello";  // will use difficulty to get
        this.displayWord = "_".repeat(this.word.length());
        this.incorrectGuesses = "";
    }

    public void play(int difficulty) {
        // get word based on difficulty
        setup(difficulty);

        // do the following until the word is guessed correctly or the incorrect guesses reach 8
        while(gameOver() == 0) {
            // 1. show the current game state 2. let the player make a guess
            String input = InputManager.getInput(System.in, currentGameState());
            // 3. check the guess
            checkPlayerGuess(input);
            // 4. update the state as needed
        }

        if (gameOver() == 1) System.out.println("\nYou lose");
        else System.out.println("\nYou win!");
    }
}
