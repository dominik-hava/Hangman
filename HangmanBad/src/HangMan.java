public class HangMan {
    private String wordToGuess;
    private String guessingWord;
    public boolean isWord = false;

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess.trim();
    }
    public void setGuessingWord(String guessingWord) {
        this.guessingWord = guessingWord.trim();
    }
    public char getGuessingCharacter() {
        return this.guessingWord.charAt(0);
    }
    public String getWordToGuess() {
        return wordToGuess;
    }

    public boolean testCharOrWord(char guessingCharacter, char[] hiddenWord, String wordToGuess) {
        if(guessingWord.length() != 1){
            isWord = true;
            return guessingWord.equalsIgnoreCase(this.wordToGuess);
        }
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessingCharacter) {
                hiddenWord[i] = guessingCharacter;
                return true;
            }
        }
        return false;
    }
}
