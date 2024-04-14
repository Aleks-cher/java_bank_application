package ru.levelup.bank.repository;

import ru.levelup.bank.domain.Customer;


import java.sql.Date;
import java.util.List;

public interface CustomerRepository {

    List<Customer> all();


    // поиск кастомера по айди
    Customer byId(Integer customerId);

    Customer create(
            long bdId,
            String firstName,
            String lastName,
            Date birthday,
            String passportSeria,
            String passportNumber
    );
}
