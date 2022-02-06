package ru.leroymerlin.reader;

import ru.leroymerlin.FileResourceUtil;
import ru.leroymerlin.data.Reconciliation;
import ru.leroymerlin.protocol.ReportType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class ReconciliationReader {
    public static List<Reconciliation> getReconciliation() throws URISyntaxException, IOException {
        List<String> content = FileResourceUtil.getContentFromFile("billing/reconciliation.csv");

        return content.stream().skip(1)
                .map(it -> it.split(","))
                .map(it -> new Reconciliation(ReportType.valueOf(it[0]), Double.valueOf(it[1]), Double.valueOf(it[2])))
                .collect(Collectors.toList());
    }
}
