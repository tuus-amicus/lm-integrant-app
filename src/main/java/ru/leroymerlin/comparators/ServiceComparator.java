package ru.leroymerlin.comparators;

import ru.leroymerlin.data.Service;

import java.util.Comparator;

public class ServiceComparator implements Comparator<Service> {
    @Override
    public int compare(Service o1, Service o2) {
        double profitService1 = o1.getSum() - o1.getCommission();
        double profitService2 = o2.getSum() - o2.getCommission();
        if (profitService1 > profitService2)
            return 1;
        return -1;
    }

}
