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

    // метод служит для сравнения профита
    public static int compare(Service service1, Service service2) {
        //считается профит с первой услуги и со второй и возвращается service1>service2
        double profitService1 = service1.getSum() - service1.getCommission();
        double profitService2 = service2.getSum() - service2.getCommission();
        if (profitService1 > profitService2)
            return 1;
        return -1;
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
