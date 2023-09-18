package org.example.task3;
import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/task3/words.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

