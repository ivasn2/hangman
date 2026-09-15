import java.util.HashSet;
import java.util.Set;

public class HangmanGame {

    private String randomItem;
    private Set<Character> necessaryLetters;
    private Set<Character> unNecessaryLetters;
    private int mistakes;
    private String result;
    private StringBuilder stringBuilder;

    public int getMistakes() {
        return mistakes;
    }

    public HangmanGame(String word) {
        this.stringBuilder = new StringBuilder();

        this.necessaryLetters = new HashSet<>();
        this.unNecessaryLetters = new HashSet<>();

        this.result = "*";
        this.mistakes = HangmanRenderer.getStagesCount() - 1;

        this.randomItem = word;
    }

    public String buildMask() {
        stringBuilder.setLength(0);
        for (Character character : randomItem.toCharArray()) {
            if (necessaryLetters.contains(character)) {
                stringBuilder.append(character);
            } else {
                stringBuilder.append("*");
            }
        }
        result = stringBuilder.toString();
        return result;
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
        return !result.contains("*");
    }
    public boolean isLost() {
        return mistakes == 0;
    }
}
