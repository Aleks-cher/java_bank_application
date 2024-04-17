package ru.levelup.bank.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.levelup.bank.domain.Account;
import ru.levelup.bank.domain.Organization;
import ru.levelup.bank.domain.Payment;
import ru.levelup.bank.domain.PaymentStatus;
import ru.levelup.bank.repository.PaymentRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@RequiredArgsConstructor
public class HibernatePaymentRepository implements PaymentRepository {

    private final SessionFactory factory;
    @Override
    public Payment createPayment(Timestamp date, BigDecimal amount, int accountFrom, int accountTo, String paymentStatus) {
        return null;
    }

    @Override
    public List<Account> byAccountId(Payment payment) {
        return null;
    }

    @Override
    public void changeStatus(int paymentId, PaymentStatus status) {

    }

    @Override
    public void changeStatus(int paymentId, String status) {

    }

    @Override
    public List<Payment> all() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Payment", Payment.class)
                    .list();
        }
    }
}
