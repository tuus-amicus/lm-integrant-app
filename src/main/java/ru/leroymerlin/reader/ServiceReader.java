package ru.leroymerlin.reader;

import ru.leroymerlin.FileResourceUtil;
import ru.leroymerlin.data.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceReader {
    public static List<Service> getServices() throws URISyntaxException, IOException {
        List<String> content = FileResourceUtil.getContentFromFile("reports/services.csv");

        return content.stream().skip(1)
                .map(it -> it.split(","))
                .map(it -> new Service(it[0], Double.valueOf(it[1]), Double.valueOf(it[2])))
                .collect(Collectors.toList());
    }
}
