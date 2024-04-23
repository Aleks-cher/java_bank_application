package ru.levelup.bank.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class ConsoleMenu {

    // public static int field;
    // ConsoleMenu.field = 34;

    // public static void method() {}
    // ConsoleMenu.method();

    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void printGeneralMenu() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1. Список всех компаний");
        System.out.println("2. Список всех клиентов");
        System.out.println("3. Получить информацию о клиенте");
        System.out.println("4. Добавить компанию");
        System.out.println("5. Поиск компании по ИНН");
        System.out.println("6. Список всех платежей");
        System.out.println("7. Список всех счетов");
        System.out.println("8. Добавить новый счет");
        System.out.println("9. Добавить новый платеж");
        System.out.println("10. Поиск платежей по ID счета");
        System.out.println("0. Выход");
    }

    public static String readString(String message) {
        try {
            System.out.println(message);
            return CONSOLE_READER.readLine();
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static int readInt(String message) {
        return Integer.parseInt(readString(message));
    }

    public static BigDecimal readBigDecimal(String message) {return BigDecimal.valueOf(Long.parseLong(readString(message)));}

}
