import java.util.HashSet;
import java.util.Set;

public class HangmanGame {

    private final String word;
    private final Set<Character> guessedLetters;
    private final Set<Character> incorrectLetters;
    private int mistakes;

    public int getMistakes() {
        return mistakes;
    }

    public HangmanGame(String word) {
        this.guessedLetters = new HashSet<>();
        this.incorrectLetters = new HashSet<>();
        this.mistakes = PictureStorage.getStagesCount() - 1;
        this.word = word;
    }

    public String buildMask() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : word.toCharArray()) {
            if (guessedLetters.contains(character)) {
                stringBuilder.append(character);
            } else {
                stringBuilder.append("*");
            }
        }
        return stringBuilder.toString();
    }

    public String processLetter(String letter) {
        if (guessedLetters.contains(letter.charAt(0))) {
            return "Вы уже вводили эту букву\n---------------------------";
        }
        else if (word.contains(letter)) {
            guessedLetters.add(letter.charAt(0));
        }
        else if (incorrectLetters.contains(letter.charAt(0))) {
            return "Вы уже вводили эту букву\n---------------------------";
        }
        else {
            mistakes -= 1;
            incorrectLetters.add(letter.charAt(0));
            return "---------------------------\n Такой буквы нет в слове \n---------------------------\nОсталось ошибок: " + mistakes;

        }
        return "";
    }
    public boolean isWon() {
        return !buildMask().contains("*");
    }
    public boolean isLost() {
        return mistakes == 0;
    }
}
