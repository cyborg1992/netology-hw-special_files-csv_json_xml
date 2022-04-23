package ru.netology;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.netology.classes.Employee;
import ru.netology.classes.Parsers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //  Задача 1
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        List<Employee> list = Parsers.parseCSV(columnMapping, "data.csv");
        String json = listToJson(list);
        writeString(json, "data.json");
        //  Задача 2
        list = Parsers.parseXML("data.xml");
        json = listToJson(list);
        writeString(json, "data2.json");
    }

    private static String listToJson(List<Employee> list) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting() //чтоб JSON был не в одну строку =)
                .create();
        return gson.toJson(list, new TypeToken<List<Employee>>() {
        }.getType());
    }

    private static void writeString(String json, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
