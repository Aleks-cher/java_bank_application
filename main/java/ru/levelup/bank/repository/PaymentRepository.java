package ru.levelup.bank.repository;

import ru.levelup.bank.domain.Account;
import ru.levelup.bank.domain.AccountEntity;
import ru.levelup.bank.domain.Payment;
import ru.levelup.bank.domain.PaymentStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface PaymentRepository {

    Payment createPayment (

            Timestamp date,
            BigDecimal amount,
            AccountEntity accountEntity1,
            AccountEntity accountEntity2,
            String paymentStatus
    );

    List<Account> byAccountId (Payment payment);

    void changeStatus(int paymentId, PaymentStatus status);
    void changeStatus(int paymentId, String status);

    List<Payment> all();

    List<Payment> byAccountId(AccountEntity accountId);
}
