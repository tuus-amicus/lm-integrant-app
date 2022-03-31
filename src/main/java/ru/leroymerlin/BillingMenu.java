package ru.leroymerlin;

import ru.leroymerlin.data.Item;
import ru.leroymerlin.data.Service;
import ru.leroymerlin.protocol.ReportType;
import ru.leroymerlin.reader.ItemReader;
import ru.leroymerlin.reader.RevenueReader;
import ru.leroymerlin.reader.ServiceReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BillingMenu {
    private static List<Item> listOfItems;
    private static List<Service> listOfService;

    public static void greeting() throws URISyntaxException, IOException {
        System.out.println("Приветствуем в билинговой системе! Что вам требуется?");
        BillingMenu.print();

        listOfItems = ItemReader.getItems();
        listOfService = ServiceReader.getServices();

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();

            switch (input) {
                case "q": {
                    System.out.println("Надеемся, вам понравилось наше приложение!");
                    return;
                }
                case "1": {
                    printMinItem();
                    printMinService();
                    break;
                }
                case "2": {
                    printReconciliationOfProfitItems();
                    printReconciliationOfProfitService();
                    break;
                }
                default: {
                    System.out.println("Команды не существует");
                }
            }
        }
    }

    private static void print() {
        System.out.println("Рассчёты: ");
        System.out.println("1 - Подсчёт минимальной прибыли по товару и услуге");
        System.out.println("2 - Сверка прибыли по услугам и товарам");
        System.out.println("Для завершения работы, нажмите 'q'");
    }

    private static void printMinItem() throws URISyntaxException, IOException {
        Item minProfitItem = listOfItems.get(0);
        // Немного не понял, у нас в файле items.csv лежит sum 1-ой штуки или это sum за все N штук.
        // И так же не понятно коммиссия берется за 1 штуку или за весь заказ
        // На всякий случай считал профит с одной штуки(sum - commission) и умножал на их колиечество
        double minProfit = minProfitItem.getQuantity() * (minProfitItem.getSum() - minProfitItem.getCommission());
        for (Item item : listOfItems) {
            double profit = item.getQuantity() * (item.getSum() - item.getCommission());
            if (minProfit > profit) {
                minProfitItem = item;
                minProfit = profit;
            }
        }
        System.out.println("Минимальная выручка " + minProfit + " по товару " + minProfitItem.getItemName() +
                " , с комиссией " + minProfitItem.getCommission()*minProfitItem.getQuantity());
    }

    private static void printMinService() throws URISyntaxException, IOException {
        Service minProfitService = listOfService.stream()
                .min(Service::compare)
                .get();
        double profit=minProfitService.getSum()- minProfitService.getCommission();
        System.out.println("Минимальная выручка " + profit + " по услуге "
                + minProfitService.getItemName() + ", с комиссией " + minProfitService.getCommission());
    }

    private static void printReconciliationOfProfitItems() throws URISyntaxException, IOException {
        // Считается сумма дохода по формуле(sum - commissionPercent) * quantity
        double sumOfItemsFromFile = listOfItems.stream()
                .mapToDouble(i -> (i.getSum() - i.getCommission()) * i.getQuantity())
                .sum();
        Map<ReportType, Double> sumOfItemsFromRevenue = RevenueReader.getRevenue();
        if (sumOfItemsFromRevenue.get(ReportType.ITEM).equals(sumOfItemsFromFile))
            System.out.println("Выручка по товарам " + sumOfItemsFromFile + " совпадает с выручкой из отчёта " +
                    sumOfItemsFromRevenue.get(ReportType.ITEM));
        else
            System.out.println("Выручка по товарам " + sumOfItemsFromFile + " не совпадает с выручкой из отчёта " +
                    sumOfItemsFromRevenue.get(ReportType.ITEM));
    }

    private static void printReconciliationOfProfitService() throws URISyntaxException, IOException {
        double sumOfServiceFromFile = listOfService.stream()
                .mapToDouble(i -> i.getSum() - i.getCommission())
                .sum();
        Map<ReportType, Double> sumOfServiceFromRevenue = RevenueReader.getRevenue();
        if (sumOfServiceFromRevenue.get(ReportType.SERVICE).equals(sumOfServiceFromFile))
            System.out.println("Выручка по услугам " + sumOfServiceFromFile + " совпадает с выручкой из отчёта " + sumOfServiceFromRevenue.get(ReportType.SERVICE));
        else
            System.out.println("Выручка по услугам " + sumOfServiceFromFile + " не совпадает с выручкой из отчёта " + sumOfServiceFromRevenue.get(ReportType.SERVICE));
    }
}
