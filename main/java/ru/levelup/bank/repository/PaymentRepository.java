package ru.levelup.bank.repository;

import ru.levelup.bank.domain.Account;
import ru.levelup.bank.domain.Payment;
import ru.levelup.bank.domain.PaymentStatus;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface PaymentRepository {

    Payment createPayment (

            Timestamp date,
            BigDecimal amount,
            int accountFrom,
            int accountTo,
            String paymentStatus
    );

    List<Account> byAccountId (Payment payment);

    void changeStatus(int paymentId, PaymentStatus status);
    void changeStatus(int paymentId, String status);

    List<Payment> all();
}
