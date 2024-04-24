package ru.levelup.bank.menu;

import ru.levelup.bank.menu.action.*;

import java.util.HashMap;
import java.util.Map;

public class MenuActions {

    // int -> Action

    private static final Map<Integer, Action> ACTION_MAP = new HashMap<>();

    // Блок инициализации
//    {
//
//    }

    static {
        ACTION_MAP.put(0, new ExitAction());
        ACTION_MAP.put(1, new OrganizationListingMenuAction());
        ACTION_MAP.put(2, new CustomersListMenuAction());
        ACTION_MAP.put(3, new CustomerDetailsMenuAction());
        ACTION_MAP.put(4, new OrganizationCreateMenuAction());
        ACTION_MAP.put(5, new OrganizationByVatinMenuAction());
        ACTION_MAP.put(6, new PaymentListingMenuAction());
        ACTION_MAP.put(7, new AccountListingMenuAction());
        ACTION_MAP.put(8, new AccountCreateMenuAction());
        ACTION_MAP.put(9, new PaymentCreateMenuAction());
        ACTION_MAP.put(10, new PaymentByAccountIdMenuAction());
        ACTION_MAP.put(11, new AssignCustomerToOrganizationMenuAction());
    }

//    public static Action getAction(int actionCode) {
//        if (actionCode == 1) {
//            return new OrganizationListingMenuAction();
//        } else {
//            return null;
//        }
//    }

    public static Action getAction(int actionCode) {
        return ACTION_MAP.get(actionCode);
    }
}
