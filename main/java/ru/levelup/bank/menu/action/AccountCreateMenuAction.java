package ru.levelup.bank.menu.action;

import ru.levelup.bank.configuration.HibernateConfiguration;
import ru.levelup.bank.domain.AccountEntity;
import ru.levelup.bank.domain.Customer;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.menu.ConsoleMenu;
import ru.levelup.bank.repository.AccountEntityRepository;
import ru.levelup.bank.repository.CustomerRepository;
import ru.levelup.bank.repository.hbm.HibernateAccountRepository;
import ru.levelup.bank.repository.hbm.HibernateCustomerRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AccountCreateMenuAction implements Action {

    private AccountEntityRepository accountEntityRepository;
    private final CustomerRepository customerRepository;

    public AccountCreateMenuAction() {
        this.accountEntityRepository = new HibernateAccountRepository(HibernateConfiguration.getFactory());
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        String accountNumber = ConsoleMenu.readString("Введите номер счета");
        String accountType = ConsoleMenu.readString("Введите тип счета");
        String accountStatus = ConsoleMenu.readString("Введите статус счета");
        Timestamp accountOpenDateTime = Timestamp.valueOf(LocalDateTime.now());

        int customerId = ConsoleMenu.readInt("Введите ID клиента");
        Customer customer = customerRepository.byId(customerId);

        AccountEntity accountEntity = accountEntityRepository.create(accountNumber, accountType, accountStatus, accountOpenDateTime, customer);
        System.out.println("Счет: " + accountEntity + " добавлен");
    }
}
