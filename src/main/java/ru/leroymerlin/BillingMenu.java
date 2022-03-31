package ru.leroymerlin;

import comparators.ItemsComparator;
import comparators.ServicesComparator;
import ru.leroymerlin.data.Item;
import ru.leroymerlin.data.Service;
import ru.leroymerlin.protocol.ReportType;
import ru.leroymerlin.reader.ItemReader;
import ru.leroymerlin.reader.RevenueReader;
import ru.leroymerlin.reader.ServiceReader;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class BillingMenu {

    public static void greeting() throws URISyntaxException, IOException {
        System.out.println("Приветствуем в билинговой системе! Что вам требуется?");
        BillingMenu.print();

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
                    // todo: ваша реализация тут
                    Optional<Item> itemMin = ItemReader.getItems().stream().min(new ItemsComparator());
                    if (itemMin.isPresent()) {
                        BigDecimal itemMinRevenue =
                                itemMin.get().getSum()
                                        .multiply(BigDecimal.valueOf(itemMin.get().getQuantity()))
                                        .multiply(itemMin.get().getCommission())
                                        .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP)
                                        .setScale(2, RoundingMode.HALF_UP);
                        System.out.println(
                                "Минимальная выручка <" + itemMinRevenue +
                                        "> по товару <" + itemMin.get().getItemName() +
                                        ">, с комиссией <" + itemMin.get().getCommission() + ">");
                    }
                    Optional<Service> serviceMin = ServiceReader.getServices().stream().min(new ServicesComparator());
                    if (serviceMin.isPresent()) {
                        BigDecimal serviceMinRevenue =
                                serviceMin.get().getSum()
                                        .multiply(serviceMin.get().getCommission())
                                        .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP)
                                        .setScale(2, RoundingMode.HALF_UP);
                        System.out.println(
                                "Минимальная выручка <" + serviceMinRevenue +
                                        "> по услуге <" + serviceMin.get().getItemName() +
                                        ">, с комиссией <" + serviceMin.get().getCommission() + ">");
                    }
                    break;
                }
                case "2": {
                    // todo: ваша реализация тут
                    Map<ReportType, BigDecimal> revenue = RevenueReader.getRevenue();
                    Optional<BigDecimal> itemsRevenueOptional = ItemReader.getItems().stream()
                            .map(item ->
                                    item.getSum()
                                            .multiply(item.getCommission())
                                            .multiply(BigDecimal.valueOf(item.getQuantity()))
                                            .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP))
                            .reduce(BigDecimal::add);
                    if (itemsRevenueOptional.isPresent()) {
                        BigDecimal itemsRevenue = itemsRevenueOptional.get();
                        if (itemsRevenue.compareTo(revenue.get(ReportType.ITEM)) != 0) {
                            System.out.println(
                                    "Выручка по товарам <" + itemsRevenue.setScale(2, RoundingMode.HALF_UP) +
                                            "> не совпадает с выручкой из отчета <" + revenue.get(ReportType.ITEM) + ">"
                            );
                        }
                    }
                    Optional<BigDecimal> serviceRevenueOptional = ServiceReader.getServices().stream()
                            .map(service ->
                                    service.getSum()
                                            .multiply(service.getCommission())
                                            .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP))
                            .reduce(BigDecimal::add);
                    if (serviceRevenueOptional.isPresent()) {
                        BigDecimal servicesRevenue = serviceRevenueOptional.get();
                        if (servicesRevenue.compareTo(revenue.get(ReportType.SERVICE)) != 0) {
                            System.out.println(
                                    "Выручка по услугам <" + servicesRevenue +
                                            "> не совпадает с выручкой из отчета <" + revenue.get(ReportType.SERVICE) + ">"
                            );
                        }
                    }
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
}