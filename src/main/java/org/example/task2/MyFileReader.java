package org.example.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/task2/file.txt"));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    String name = parts[0];
                    Integer age = Integer.parseInt(parts[1]);
                    users.add(new User(name, age));
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("user.json"), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
