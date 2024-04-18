package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int IDCounter = 0;
    private static List<Integer> screwdriverId = new ArrayList<>();
    private static List<String> screwdriverHandleType = new ArrayList<>();
    private static List<String> screwdriverTipType = new ArrayList<>();
    private static List<Integer> screwdriverSize = new ArrayList<>();

    public static void createScrewdriver(String handleType, String tipType, int size) {
        int id = generateID();
        screwdriverId.add(id);
        screwdriverHandleType.add(handleType);
        screwdriverTipType.add(tipType);
        screwdriverSize.add(size);
        System.out.println("Отвертка создана с идентификатором " + id);
    }

    public static void findScrewdriverByID(int id) {
        int index = screwdriverId.indexOf(id);
        if (index != -1) {
            System.out.println("Найдена отвертка:");
            System.out.println("Идентификатор: " + screwdriverId.get(index));
            System.out.println("Тип рукоятки: " + screwdriverHandleType.get(index));
            System.out.println("Тип наконечника: " + screwdriverTipType.get(index));
            System.out.println("Размер: " + screwdriverSize.get(index));
        } else {
            System.out.println("Отвертка с указанным идентификатором не найдена.");
        }
    }

    private static int generateID() {
        return ++IDCounter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать новую отвертку");
            System.out.println("2. Найти отвертку по идентификатору");
            System.out.println("3. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите тип рукоятки:");
                    String handleType = scanner.nextLine();
                    System.out.println("Введите тип наконечника:");
                    String tipType = scanner.nextLine();
                    System.out.println("Введите размер:");
                    int size = scanner.nextInt();
                    scanner.nextLine(); // очистка буфера
                    createScrewdriver(handleType, tipType, size);
                    break;
                case 2:
                    System.out.println("Введите идентификатор отвертки:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    findScrewdriverByID(id);
                    break;
                case 3:
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите 1, 2 или 3.");
            }
        }
    }
}
