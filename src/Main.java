import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        LetterInput letterInput = new RusLetterInput();
        List<String> words = WordLoader.wordLoader("words.txt");
        if (words == null || words.isEmpty()) {
            System.out.println("Ошибка при чтении файла");
            System.exit(1);
        }
        while (true) {
            int randomIndex = random.nextInt(words.size());
            String randomItem = words.get(randomIndex).toLowerCase();
            System.out.println("[N]ew game or [E]xit ?");
            String userAnswer = inputCommand(input, "Введите n или e");
            if (userAnswer.equalsIgnoreCase("N")) {
                HangmanGame game = new HangmanGame(randomItem);
                System.out.println("--------------");
                System.out.println("| НАЧАЛО ИГРЫ |");
                System.out.println("--------------");
                while (!game.isWon() && !game.isLost()) {
                    System.out.println("Слово: " + game.buildMask());
                    System.out.println(PictureStorage.drawHangman(game.getMistakes()));
                    System.out.print("Введите букву: ");
                    String letter = letterInput.get(input, "Введите русскую букву");
                    System.out.println(game.processLetter(letter));
                }
                if (game.isWon()) {
                    System.out.println("Слово: " + game.buildMask());
                    System.out.println("-----------------------------------");
                    System.out.println("| Вы отгадали слово! Вы выиграли! |");
                    System.out.println("-----------------------------------");
                } else {
                    System.out.println(PictureStorage.drawHangman(game.getMistakes()));
                    System.out.println("------------------------------------");
                    System.out.println("| Вы проиграли! Попробуйте еще раз |");
                    System.out.println("------------------------------------");
                    System.out.println("Загаданное слово было: " + randomItem);
                }
            } else if (userAnswer.equalsIgnoreCase("E")) {
                System.out.println("Конец игры :(");
                break;
            }
        }
    }
    private static String inputCommand(Scanner scanner, String errorMessage) {
        String value = scanner.nextLine();
        while (value.isEmpty()) {
            System.out.println(errorMessage);
            value = scanner.nextLine();
        }
        return value;
    }
}