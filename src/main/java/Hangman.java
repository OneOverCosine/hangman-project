public class Hangman {

    private String word = "hello";
    private String displayWord = "_".repeat(word.length());

    public String getWord() {
        return word;
    }

    public String getDisplayWord() {
        return displayWord;
    }
}
