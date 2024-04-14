package ru.levelup.bank.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.bank.domain.Customer;
import ru.levelup.bank.repository.CustomerRepository;

import java.sql.Date;
import java.util.List;
@RequiredArgsConstructor
public class HibernateCustomerRepository implements CustomerRepository {

    private final SessionFactory factory;

    @Override
    public List<Customer> all() {
        try (Session session = factory.openSession()) {
            // чтение можно проводить без транзакций
            return session.createQuery("from Customer", Customer.class)
                    .list();
        }

    }

    @Override
    public Customer byId(Integer customerId) {
        try (Session session = factory.openSession()) {

//            session.createQuery("from Customer where id = :id", Customer.class)
//                    .setParameter("id", customerId)
//                    .uniqueResult();
            // чтение можно проводить без транзакций
            return session.get(Customer.class, customerId);
        }
    }

    @Override
    public Customer create(
            long bdId,
            String firstName,
            String lastName,
            Date birthday,
            String passportSeria,
            String passportNumber) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();  // начало транзакции

            Customer customer = new Customer(
                    null,
                    bdId,
                    firstName,
                    lastName,
                    birthday,
                    passportSeria,
                    passportNumber
            );

            session.persist(customer); // insert into ...

            tx.commit();  //  фиксация транзакции (успешное завершение транзакции)
            return customer;
        }

    }
}
