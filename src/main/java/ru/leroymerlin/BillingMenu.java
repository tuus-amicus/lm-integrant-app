package ru.leroymerlin;

import java.util.Scanner;

public class BillingMenu {

    public static void greeting() {
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
                    break;
                }
                case "2": {
                    // todo: ваша реализация тут
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
