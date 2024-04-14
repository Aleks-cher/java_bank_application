package ru.levelup.bank;

import ru.levelup.bank.configuration.HibernateConfiguration;
import ru.levelup.bank.domain.Account;
import ru.levelup.bank.domain.Customer;
import ru.levelup.bank.domain.Organization;
import ru.levelup.bank.domain.PaymentStatus;
import ru.levelup.bank.jdbc.JdbcConnectionManager;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.menu.ConsoleMenu;
import ru.levelup.bank.menu.MenuActions;
import ru.levelup.bank.repository.AccountRepository;
import ru.levelup.bank.repository.CustomerRepository;
import ru.levelup.bank.repository.OrganizationRepository;
import ru.levelup.bank.repository.PaymentRepository;
import ru.levelup.bank.repository.jdbc.JdbcAccountRepository;
import ru.levelup.bank.repository.jdbc.JdbcOrganizationRepository;
import ru.levelup.bank.repository.jdbc.JdbcCustomerRepository;
import ru.levelup.bank.repository.jdbc.JdbcPaymentRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class BankApplication {

//    public static void main(String[] args) {
//
//        // 19 урок, надо создать меню
//        //
//
//        JdbcConnectionManager cm = new JdbcConnectionManager();
//
//        CustomerRepository customerRepository = new JdbcCustomerRepository(cm);
//
////        List<Customer> all = customerRepository.all();
////        for (Customer customer : all) {
////            System.out.println(customer);
////        }
////
////        System.out.println();
////
////        AccountRepository accountRepository = new JdbcAccountRepository(cm);
////
////        List<Account> allAcc = accountRepository.allAcc();
////        for (Account account : allAcc) {
////            System.out.println(account);
////        }
////
//        System.out.println();
//        Customer customer = customerRepository.byId(3);
//        System.out.println(customer);
////
////        System.out.println();
////
////        Customer createdCustomer = customerRepository.create(
////                35364746473l,
////                "Vasia",
////                "Petrov",
////                Date.valueOf(LocalDate.of(1992, 3, 30)),
////                "4001",
////                "546987"
////        );
////        System.out.println(createdCustomer);
//
//        System.out.println();
//
//        OrganizationRepository organizationRepository = new JdbcOrganizationRepository(cm);
//        List<Organization> organizations = organizationRepository.byName("ЗАО");
//        organizations.forEach(org -> System.out.println(org));
//        System.out.println();
//        Organization organizationVatin = organizationRepository.byVatin("7777888840683035");
//        System.out.println(organizationVatin);
//        System.out.println();
//        List<Organization> organizationsAll = organizationRepository.all();
//        for (Organization organization : organizationsAll) {
//            System.out.println(organization);
//        }
//        System.out.println();
//        AccountRepository accountRepository = new JdbcAccountRepository(cm);
////        Account createAcc = accountRepository.create("6666666666666", "Расчетный", "Действующий", customer);
////        accountRepository.remove(14);
//
//        PaymentRepository paymentRepository = new JdbcPaymentRepository(cm);
//        paymentRepository.changeStatus(1, PaymentStatus.NEW);
//
//    }

    // 19 lessons
    // create menu
    public static void main(String[] args) {
        HibernateConfiguration.initializeSessionFactory();

        int actionCode = 0;
        do {
            ConsoleMenu.printGeneralMenu();
            actionCode = ConsoleMenu.readInt("Введите номер действия:");

            Action action = MenuActions.getAction(actionCode);
            if (action == null) {
                System.out.println("Такого действия не существует");
            } else {
                action.execute();
            }

        } while (actionCode != 0);

        HibernateConfiguration.getFactory().close();


    }
}
