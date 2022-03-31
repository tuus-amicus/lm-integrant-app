package ru.leroymerlin.data;

import java.math.BigDecimal;

public class Item {
    private final String itemName;
    private final BigDecimal sum;
    private final Integer quantity;
    private final BigDecimal commission;

    public Item(String itemName, BigDecimal sum, Integer quantity, BigDecimal commission) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.sum = sum;
        this.commission = commission;
    }

    //region ToString, getters, setters
    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", sum=" + sum +
                ", quantity=" + quantity +
                ", commission=" + commission +
                '}';
    }

    public Integer getQuantity() {
        return quantity;
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
