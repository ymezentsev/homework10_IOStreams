import java.io.*;
import java.util.*;

public class Task3 {
    public static final String FILE_NAME = ".\\src\\main\\resources\\task3\\words.txt";

    public static void main(String[] args) {
        countAndPrintFrequencyWords(FILE_NAME);
    }

    private static void countAndPrintFrequencyWords(String fileName) {
        List<String> words = readFileToList(fileName);

        Map<String, Integer> wordsCount = new HashMap<>();
        int count = 1;

        for (String word : words) {
            if (wordsCount.containsKey(word)) {
                int value = wordsCount.get(word);
                value++;
                wordsCount.replace(word, value);
            } else {
                wordsCount.put(word, count);
            }
        }

        Map<String, Integer> sortedMap = sortMapByValue(wordsCount);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static List<String> readFileToList(String fileName) {
        List<String> words = new ArrayList<>();

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(FILE_NAME)))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    private static Map<String, Integer> sortMapByValue(Map<String, Integer> wordsCount) {
        Object[] objects = wordsCount.values().toArray();
        Arrays.sort(objects, Collections.reverseOrder());

        Map<String, Integer> result = new LinkedHashMap<>();
        for (var object : objects) {
            for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
                if (object.equals(entry.getValue())) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return result;
    }
}