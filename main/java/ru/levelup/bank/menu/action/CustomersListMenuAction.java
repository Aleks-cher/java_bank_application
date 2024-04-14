package ru.levelup.bank.menu.action;

import ru.levelup.bank.configuration.HibernateConfiguration;
import ru.levelup.bank.domain.Customer;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.repository.CustomerRepository;
import ru.levelup.bank.repository.hbm.HibernateCustomerRepository;
import ru.levelup.bank.repository.jdbc.JdbcCustomerRepository;

import java.util.List;

public class CustomersListMenuAction implements Action {

    private final CustomerRepository customerRepository;

    public CustomersListMenuAction() {
        this.customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());

    }
    @Override
    public void execute() {
        List<Customer> customers = customerRepository.all();

        customers.forEach(customer -> System.out.println(customer));
    }
}
