package ru.levelup.bank.menu.action;

import lombok.RequiredArgsConstructor;
import ru.levelup.bank.domain.Customer;
import ru.levelup.bank.jdbc.JdbcConnectionManager;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.menu.ConsoleMenu;
import ru.levelup.bank.repository.CustomerRepository;
import ru.levelup.bank.repository.jdbc.JdbcCustomerRepository;


public class CustomerDetailsMenuAction implements Action {

    private final CustomerRepository customerRepository;

    public CustomerDetailsMenuAction() {
        this.customerRepository = new JdbcCustomerRepository(new JdbcConnectionManager());
    }
    @Override
    public void execute() {
        int customerId = ConsoleMenu.readInt("Введите ID клиента");

        Customer customer = customerRepository.byId(customerId);
        if (customer == null) {
            System.out.println("Клиент с ID " + customerId + " не существует");
        } else {
            System.out.println(customer);
        }
    }
}
