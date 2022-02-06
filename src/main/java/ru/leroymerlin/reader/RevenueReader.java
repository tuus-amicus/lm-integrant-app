package ru.leroymerlin.reader;

import ru.leroymerlin.FileResourceUtil;
import ru.leroymerlin.data.Revenue;
import ru.leroymerlin.protocol.ReportType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RevenueReader {
    public static Map<ReportType, Double> getRevenue() throws URISyntaxException, IOException {
        List<String> content = FileResourceUtil.getContentFromFile("billing/revenue.csv");

        return content.stream().skip(1)
                .map(it -> it.split(","))
                .map(it -> new Revenue(ReportType.valueOf(it[0]), Double.valueOf(it[1])))
                .collect(Collectors.toMap(Revenue::getReportType, Revenue::getProfit));
    }
}
