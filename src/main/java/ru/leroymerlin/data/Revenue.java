package ru.leroymerlin.data;

import ru.leroymerlin.protocol.ReportType;

import java.math.BigDecimal;

public class Revenue {
    private final ReportType reportType;
    private final BigDecimal profit;

    public Revenue(ReportType reportType, BigDecimal profit) {
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

    public BigDecimal getProfit() {
        return profit;
    }
    //endregion
}