import java.util.HashSet;
import java.util.Set;

public class HangmanGame {

    private final String randomItem;
    private final Set<Character> necessaryLetters;
    private final Set<Character> unNecessaryLetters;
    private int mistakes;

    public int getMistakes() {
        return mistakes;
    }

    public HangmanGame(String word) {
        this.necessaryLetters = new HashSet<>();
        this.unNecessaryLetters = new HashSet<>();
        this.mistakes = HangmanRenderer.getStagesCount() - 1;
        this.randomItem = word;
    }

    public String buildMask() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : randomItem.toCharArray()) {
            if (necessaryLetters.contains(character)) {
                stringBuilder.append(character);
            } else {
                stringBuilder.append("*");
            }
        }
        return stringBuilder.toString();
    }

    public String processLetter(String letter) {
        if (necessaryLetters.contains(letter.charAt(0))) {
            return "Вы уже вводили эту букву\n---------------------------";
        }
        else if (randomItem.contains(letter)) {
            necessaryLetters.add(letter.charAt(0));
        }
        else if (unNecessaryLetters.contains(letter.charAt(0))) {
            return "Вы уже вводили эту букву\n---------------------------";
        }
        else {
            mistakes -= 1;
            unNecessaryLetters.add(letter.charAt(0));
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
