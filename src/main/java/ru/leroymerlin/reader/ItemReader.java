package ru.leroymerlin.reader;

import ru.leroymerlin.FileResourceUtil;
import ru.leroymerlin.data.Item;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class ItemReader {
    public static List<Item> getItems() throws URISyntaxException, IOException {
        List<String> content = FileResourceUtil.getContentFromFile("reports/items.csv");

        return content.stream().skip(1).limit(content.size())
                .map(it -> it.split(","))
                .map(it -> new Item(it[0]
                        , BigDecimal.valueOf(Double.parseDouble(it[1]))
                        , Integer.valueOf(it[2])
                        , BigDecimal.valueOf(Double.parseDouble(it[3]))))
                .collect(Collectors.toList());
    }
}
