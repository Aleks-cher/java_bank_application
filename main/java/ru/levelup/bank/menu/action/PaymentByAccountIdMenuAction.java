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

import java.util.List;

public class PaymentByAccountIdMenuAction implements Action {

    private PaymentRepository paymentRepository;
    private AccountEntityRepository accountEntityRepository;

    public PaymentByAccountIdMenuAction() {
        this.paymentRepository = new HibernatePaymentRepository(HibernateConfiguration.getFactory());
        this.accountEntityRepository = new HibernateAccountRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        int accountId = ConsoleMenu.readInt("Введите номер ID счета");
        AccountEntity accountEntity = accountEntityRepository.byId(accountId);
        List<Payment> payments = paymentRepository.byAccountId(accountEntity);
        payments.forEach(payment -> System.out.println(payment));

    }
}
