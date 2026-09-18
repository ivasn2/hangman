import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RusLetterInput implements LetterInput {
    private static final String REGEX = "[А-Яа-яЁё]";
    private final Pattern pattern = Pattern.compile(REGEX);

    @Override
    public String get(Scanner scanner, String errorMessage) {
        String value = scanner.nextLine().toLowerCase();
        while (true) {
            Matcher matcher = pattern.matcher(value);
            boolean isMatch = matcher.matches();
            if (value.isEmpty()) {
                System.out.println(errorMessage);
                value = scanner.nextLine().toLowerCase();
            } else if (value.length() != 1 || !Character.isLetter(value.charAt(0))) {
                System.out.println(errorMessage);
                value = scanner.nextLine().toLowerCase();
            } else if (!isMatch) {
                System.out.println("Введите русскую букву");
                value = scanner.nextLine().toLowerCase();
            } else {
                break;
            }
        }
        return value;
    }
}
