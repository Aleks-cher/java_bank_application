package ru.levelup.bank.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.bank.domain.*;
import ru.levelup.bank.repository.PaymentRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@RequiredArgsConstructor
public class HibernatePaymentRepository implements PaymentRepository {

    private final SessionFactory factory;
    @Override
    public Payment createPayment(Timestamp date, BigDecimal amount, AccountEntity accountEntity1, AccountEntity accountEntity2, String paymentStatus) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Payment payment = new Payment(
                    null,
                    date,
                    amount,
                    accountEntity1,
                    accountEntity2,
                    PaymentStatus.findEnumOrNull(paymentStatus)
            );
            session.persist(payment);
            tx.commit();
            return payment;
        }
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

    @Override
    public List<Payment> byAccountId(AccountEntity accountId) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Payment where accountFrom= :test or accountTo= :test", Payment.class)
                    .setParameter("test", accountId)
                    .list();
        }
    }
}
