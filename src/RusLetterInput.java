import java.util.Scanner;

public class RusLetterInput implements LetterInput {
    @Override
    public String get(Scanner scanner, String errorMessage) {
        String value = scanner.nextLine().toLowerCase();
        while (true) {
            if (value.isEmpty()) {
                System.out.println(errorMessage);
                value = scanner.nextLine().toLowerCase();
            } else if (value.length() != 1 || !Character.isLetter(value.charAt(0))) {
                System.out.println(errorMessage);
                value = scanner.nextLine().toLowerCase();
            } else if (!value.matches("[А-Яа-яЁё]")) {
                System.out.println("Введите русскую букву");
                value = scanner.nextLine().toLowerCase();
            } else {
                break;
            }
        }
        return value;
    }
}
