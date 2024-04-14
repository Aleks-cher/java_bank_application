package ru.levelup.bank.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

}