package comparators;

import ru.leroymerlin.data.Item;

import java.math.BigDecimal;
import java.util.Comparator;

public class ItemsComparator implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        BigDecimal bigDecimal1 =
                item1.getSum()
                        .multiply(BigDecimal.valueOf(item1.getQuantity()))
                        .multiply(item1.getCommission())
                        .multiply(BigDecimal.valueOf(100));
        BigDecimal bigDecimal2 =
                item2.getSum()
                        .multiply(BigDecimal.valueOf(item2.getQuantity()))
                        .multiply(item2.getCommission())
                        .multiply(BigDecimal.valueOf(100));
        return bigDecimal1.intValue() - bigDecimal2.intValue();
    }
}
