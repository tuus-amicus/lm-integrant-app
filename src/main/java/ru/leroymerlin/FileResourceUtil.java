package ru.leroymerlin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileResourceUtil {
    public static List<String> getContentFromFile(String fileName) throws URISyntaxException, IOException {
        ClassLoader classLoader = FileResourceUtil.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return Files.readAllLines(Path.of(resource.toURI()));
        }
    }
}
