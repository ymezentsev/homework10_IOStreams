package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static final String FILE_NAME = ".\\src\\main\\resources\\task2\\file.txt";

    public static void main(String[] args) {
        List<User> users = readUsersFromFile(FILE_NAME);
        writeUsersToJson(users);
    }

    public static List<User> readUsersFromFile(String fileName) {
        List<User> users = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String str = bufferedReader.readLine();
            str = bufferedReader.readLine();
            while (str != null) {
                String[] userString = str.split(" ");
                users.add(new User(userString[0], Integer.parseInt(userString[1])));

                str = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    private static void writeUsersToJson(List<User> users) {
        File file = new File(".\\src\\main\\resources\\task2\\user.json");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);
            bufferedWriter.write(json);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
