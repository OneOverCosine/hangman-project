public class Hangman {

    private String word = "hello";
    private String displayWord = "_".repeat(word.length());

    public String getWord() {
        return word;
    }

    public String getDisplayWord() {
        return displayWord;
    }

    public void checkPlayerGuess(String guess) {
        int index = word.indexOf(guess);
        if (index == -1) return;
        updateDisplayWord(index, guess);
    }

    public void updateDisplayWord(int replaceFrom, String guess) {
        StringBuilder newString = new StringBuilder(displayWord);
        newString.replace(replaceFrom,replaceFrom+1, guess);
        displayWord = newString.toString();
    }
}