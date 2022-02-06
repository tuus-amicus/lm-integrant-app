package ru.leroymerlin.data;

public class Service {
    private final String itemName;
    private final Double sum;
    private final Double commission;

    public Service(String itemName, Double sum, Double commission) {
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

    public Double getSum() {
        return sum;
    }

    public Double getCommission() {
        return commission;
    }
    //endregion
}
