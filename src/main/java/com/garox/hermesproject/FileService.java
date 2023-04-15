package com.garox.hermesproject;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class FileService {
    private final String fileName = "data.csv";
    public List<Task> readAllFiles() throws IOException {
        return Files.readAllLines(Paths.get(fileName))
                .stream()
                .map(CsvEntryConverter::parse)
                .collect(Collectors.toList());
    }

    void saveEntries(List<Task> tasks) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Task task : tasks) {
            writer.write(task.toString());
            writer.newLine();
        }
        writer.close();
    }

    private static class CsvEntryConverter {
        public static Task parse(String text) {
            String[] split = text.split(";");
            return new Task(split[0],split[1],Integer.parseInt(split[2]));
        }
    }
}
