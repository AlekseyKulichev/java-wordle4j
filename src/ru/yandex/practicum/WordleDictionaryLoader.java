package ru.yandex.practicum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WordleDictionaryLoader {
    private final PrintWriter log;

    public WordleDictionaryLoader(PrintWriter log) {
        if (log == null) {
            throw new InvalidDictionaryException("Журнал обязателен");
        }
        this.log = log;
    }

    public WordleDictionary loadFromFile(String filePath) throws IOException {
        if (filePath == null || filePath.isBlank()) {
            throw new InvalidDictionaryException("Путь к файлу не может быть пустым");
        }

        List<String> words = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        }

        if (words.isEmpty()) {
            throw new InvalidDictionaryException("В файле не найдено слов из 5 русских букв");
        }

        return new WordleDictionary(words, log);
    }
}
