package ru.levelup.bank.repository;

import ru.levelup.bank.domain.Account;
import ru.levelup.bank.domain.Customer;

import java.sql.Date;
import java.util.List;

public interface AccountRepository {

    List<Account> allAcc();

    Account create(
            String account_number,
            String type,
            String status,
            Customer customer
    );

    void update(Account account);

    void remove(Integer id);
}
