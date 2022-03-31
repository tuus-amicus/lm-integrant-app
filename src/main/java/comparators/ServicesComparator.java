package comparators;

import ru.leroymerlin.data.Service;

import java.math.BigDecimal;
import java.util.Comparator;

public class ServicesComparator implements Comparator<Service> {
    @Override
    public int compare(Service service1, Service service2) {
        BigDecimal bigDecimal1 =
                service1.getSum()
                        .multiply(service1.getCommission())
                        .multiply(BigDecimal.valueOf(100));
        BigDecimal bigDecimal2 =
                service2.getSum()
                        .multiply(service2.getCommission())
                        .multiply(BigDecimal.valueOf(100));
        return bigDecimal1.intValue() - bigDecimal2.intValue();
    }
}
