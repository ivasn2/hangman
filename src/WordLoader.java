import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class WordLoader {
    public static List<String> wordLoader(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла:", e);
        }
        return words;
    }
    private WordLoader() {
    }
}
