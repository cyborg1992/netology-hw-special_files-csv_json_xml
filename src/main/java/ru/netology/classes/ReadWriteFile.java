package ru.netology.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {

    public static void writeString(String json, String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(json);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readString(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(x -> x.replace(" ", ""))
                    .reduce(String::concat)
                    .orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
