package ru.levelup.bank.repository.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.levelup.bank.domain.Customer;
import ru.levelup.bank.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class HibernateCustomerRepositoryTest {

    private SessionFactory factory = mock(SessionFactory.class);
    private Session session = mock(Session.class);
    private Query query = mock(Query.class);
    private CustomerRepository customerRepository = new HibernateCustomerRepository(factory);

    @Test
    public void testAll() {
        // given
        List<Customer> expectedCustomers = List.of(
                new Customer(),
                new Customer()
        );

        when(factory.openSession()).thenReturn(session);
        when(session.createQuery(anyString(), any())).thenReturn(query);
        when(query.list()).thenReturn(expectedCustomers);

        // when
        List<Customer> customers = customerRepository.all();

        // then
        assertIterableEquals(expectedCustomers, customers);

        // Mockito.verify()
        verify(factory).openSession();
//        verify(session).createQuery(anyString(), eq(Customer.class));
        verify(session).createQuery("from Customer", Customer.class);
        verify(query).list();
        verify(session).close();

    }

    @ParameterizedTest
    @MethodSource("byIdSource")
    public void testByID(Integer customerID, Customer expectedResult) {
        // given
        when(factory.openSession()).thenReturn(session);
        when(session.get(any(Class.class), any())).thenReturn(expectedResult);

        // when
        Customer result = customerRepository.byId(customerID);

        // then
        assertEquals(expectedResult, result);

        verify(session).get(Customer.class, customerID);
        verify(session).close();
    }

    private static Stream<Arguments> byIdSource() {
        return Stream.of(
                Arguments.of(100, new Customer()),
                Arguments.of(101, null)
        );
    }

}