import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    public static final String FILE_NAME = ".\\src\\main\\resources\\task1\\file.txt";

    public static void main(String[] args) {
        printTelephoneNumberIfIsValid(FILE_NAME);
    }

    public static void printTelephoneNumberIfIsValid(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String str = bufferedReader.readLine();
            while (str != null) {
                if (str.matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}") || str.matches("\\d{3}-\\d{3}-\\d{4}")) {
                    System.out.println(str);
                }
                str = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
