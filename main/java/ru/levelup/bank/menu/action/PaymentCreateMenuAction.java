package ru.levelup.bank.menu.action;

import ru.levelup.bank.configuration.HibernateConfiguration;
import ru.levelup.bank.domain.AccountEntity;
import ru.levelup.bank.domain.Payment;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.menu.ConsoleMenu;
import ru.levelup.bank.repository.AccountEntityRepository;
import ru.levelup.bank.repository.PaymentRepository;
import ru.levelup.bank.repository.hbm.HibernateAccountRepository;
import ru.levelup.bank.repository.hbm.HibernatePaymentRepository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PaymentCreateMenuAction implements Action {

    private PaymentRepository paymentRepository;
    private AccountEntityRepository accountEntityRepository;

    public PaymentCreateMenuAction() {
        this.paymentRepository = new HibernatePaymentRepository(HibernateConfiguration.getFactory());
        this.accountEntityRepository = new HibernateAccountRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        Timestamp paymentOpenDateTime = Timestamp.valueOf(LocalDateTime.now());
        BigDecimal amount = ConsoleMenu.readBigDecimal("Введите сумму платежа");
        int accountIdFrom = ConsoleMenu.readInt("Введите ID счета с которого произойдет платеж");
        AccountEntity accountFrom = accountEntityRepository.byId(accountIdFrom);
        int accountIdTo = ConsoleMenu.readInt("Введите ID счета на который произойдет платеж");
        AccountEntity accountTo = accountEntityRepository.byId(accountIdTo);
        String paymentStatus = ConsoleMenu.readString("Введите статус платежа");

        Payment payment = paymentRepository.createPayment(paymentOpenDateTime, amount, accountFrom, accountTo, paymentStatus);
        System.out.println("Платеж: " + payment + " добавлен!");
    }
}
