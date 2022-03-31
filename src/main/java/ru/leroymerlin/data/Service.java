package ru.leroymerlin.data;

import java.math.BigDecimal;

public class Service {
    private final String itemName;
    private final BigDecimal sum;
    private final BigDecimal commission;

    public Service(String itemName, BigDecimal sum, BigDecimal commission) {
        this.itemName = itemName;
        this.sum = sum;
        this.commission = commission;
    }

    //region ToString, getters, setters
    @Override
    public String toString() {
        return "Service{" +
                "itemName='" + itemName + '\'' +
                ", sum=" + sum +
                ", commission=" + commission +
                '}';
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public BigDecimal getCommission() {
        return commission;
    }
    //endregion
}
