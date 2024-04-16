package ru.levelup.bank.repository.hbm;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.bank.domain.Customer;
import ru.levelup.bank.domain.Organization;
import ru.levelup.bank.repository.OrganizationRepository;

import java.util.List;
@RequiredArgsConstructor
public class HibernateOrganizationRepository implements OrganizationRepository {

    private final SessionFactory factory;

    @Override
    public List<Organization> all() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Organization", Organization.class)
                    .list();
        }
    }

    @Override
    public void update(Organization organization) {
        try (Session session = factory.openSession()) {
            // ACID
            // A - Atomicity
            // C - Consistency
            // I - Isolation
            // D - Durability
            Transaction tx = session.beginTransaction();

            // 1 var
//            session.merge(organization); //  делаеt update
            // 2 var
            Organization organizationFromDB = session.get(Organization.class, organization.getId());
            organizationFromDB.setName(organization.getName());
            organizationFromDB.setVatin(organization.getVatin());
            // session.merge() - нет необходимости вызывать метод merge

            tx.commit();
        }
    }

    @Override
    public Organization byVatin(String vatin) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Organization where vatin= :paramVatin", Organization.class)
                    .setParameter("paramVatin", vatin)
                    .uniqueResult();
        }
    }

    @Override
    public List<Organization> byName(String name) {
        return null;
    }

    @Override
    public Organization create(
            String name,
            String vatin) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Organization organization = new Organization(
                    null,
                    name,
                    vatin
            );
            session.persist(organization);
            tx.commit();
            return organization;
        }
    }
}
