package ru.levelup.bank.menu.action;

import ru.levelup.bank.menu.Action;

public class ExitAction implements Action {
    @Override
    public void execute() {
        System.out.println("Пока!");
    }
}
