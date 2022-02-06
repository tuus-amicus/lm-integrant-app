package ru.leroymerlin.data;

public class Item {
    private final String itemName;
    private final Double sum;
    private final Integer quantity;
    private final Double commission;

    public Item(String itemName, Double sum, Integer quantity, Double commission) {
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

    public Double getSum() {
        return sum;
    }

    public Double getCommission() {
        return commission;
    }
    //endregion
}
