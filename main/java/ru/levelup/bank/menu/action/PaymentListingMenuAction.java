package ru.levelup.bank.menu.action;

import ru.levelup.bank.configuration.HibernateConfiguration;
import ru.levelup.bank.domain.Organization;
import ru.levelup.bank.domain.Payment;
import ru.levelup.bank.menu.Action;
import ru.levelup.bank.repository.PaymentRepository;
import ru.levelup.bank.repository.hbm.HibernatePaymentRepository;

import java.util.List;

public class PaymentListingMenuAction implements Action {

    private PaymentRepository paymentRepository;

    public PaymentListingMenuAction() {
        this.paymentRepository = new HibernatePaymentRepository(HibernateConfiguration.getFactory());
    }
    @Override
    public void execute() {
        List<Payment> payments = paymentRepository.all();

        payments.forEach(payment -> System.out.println(payment));
    }
}
