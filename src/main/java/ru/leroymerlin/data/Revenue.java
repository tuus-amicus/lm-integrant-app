package ru.leroymerlin.data;

import ru.leroymerlin.protocol.ReportType;

public class Revenue {
    private final ReportType reportType;
    private final Double profit;

    public Revenue(ReportType reportType, Double profit) {
        this.reportType = reportType;
        this.profit = profit;
    }

    //region ToString, getters, setters
    @Override
    public String toString() {
        return "Reconciliation{" +
                "reportType=" + reportType +
                ", profit=" + profit +
                '}';
    }

    public ReportType getReportType() {
        return reportType;
    }

    public Double getProfit() {
        return profit;
    }
    //endregion
}