package ru.levelup.bank.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.bank.domain.AccountEntity;
import ru.levelup.bank.domain.Customer;
import ru.levelup.bank.repository.AccountEntityRepository;

import java.sql.Timestamp;
import java.util.List;
@RequiredArgsConstructor
public class HibernateAccountRepository implements AccountEntityRepository {

    private final SessionFactory factory;
    @Override
    public List<AccountEntity> allAcc() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from AccountEntity", AccountEntity.class)
                    .list();
        }
    }

    @Override
    public AccountEntity create(String account_number, String type, String status, Timestamp open_datetime, Customer customer) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            AccountEntity accountEntity = new AccountEntity(
                    null,
                    account_number,
                    type,
                    status,
                    open_datetime,
                    customer
            );
            session.persist(accountEntity);
            tx.commit();
            return accountEntity;
        }
    }

    @Override
    public AccountEntity byId(Integer accountId) {
        try (Session session = factory.openSession()) {
            return session.get(AccountEntity.class, accountId);
        }
    }
}
