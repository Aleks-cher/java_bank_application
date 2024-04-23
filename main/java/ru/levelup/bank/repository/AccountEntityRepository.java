package ru.levelup.bank.repository;

import ru.levelup.bank.domain.Account;
import ru.levelup.bank.domain.AccountEntity;
import ru.levelup.bank.domain.Customer;

import java.sql.Timestamp;
import java.util.List;

public interface AccountEntityRepository {

    List<AccountEntity> allAcc();

    AccountEntity create(
            String account_number,
            String type,
            String status,
            Timestamp open_datetime,
            Customer customer
    );

    AccountEntity byId(Integer accountId);
}
