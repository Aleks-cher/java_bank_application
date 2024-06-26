package ru.levelup.bank.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.levelup.bank.domain.*;

import java.util.Properties;

public class HibernateConfiguration {

    private static SessionFactory factory;

    public static void initializeSessionFactory() {
        if (factory != null) {
            throw new RuntimeException("SessionFactory has been already initialized");
        }

        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");  // Driver.class.getName();
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/lk-bank");
        properties.setProperty("hibernate.connection.username", "postgres");
        properties.setProperty("hibernate.connection.password", "23472");

        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");

        // validate
        // update
        // create
        // create-drop
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(properties)
                .build();

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Organization.class)
                .addAnnotatedClass(AccountEntity.class)
                .addAnnotatedClass(Payment.class);


        factory = configuration.buildSessionFactory(registry);

    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
