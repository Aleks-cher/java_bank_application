package ru.levelup.bank.repository.jdbc;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.levelup.bank.domain.Customer;
import ru.levelup.bank.jdbc.JdbcConnectionManager;
import ru.levelup.bank.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//@AllArgsConstructor создает конструктор со всеми полями
@RequiredArgsConstructor // создает конструктор с финал полями
public class JdbcCustomerRepository implements CustomerRepository {

    private final JdbcConnectionManager cm;



    //    public JdbcCustomerRepository(JdbcConnectionManager cm) {
//        this.cm = cm;
//    }
    @Override
    public List<Customer> all() {
        try (Connection conn = cm.openConnection()) {

            Statement stmt = conn.createStatement(); // Statement интерфейс через который можно исполнять Sql запросы
            ResultSet rs = stmt.executeQuery("select * from customers"); // executeQuery метод который позволяет исполнить SELECT запросы

            List<Customer> allCustomers = new ArrayList<>();


            // boolean ResultSet#next();
            // true если есть еще строки в результирующей таблице, false если нет
            // next сдвигает курсор дальше по результирующей таблице

            while (rs.next()) {
//                int id = rs.getInt("id");
//                long bankDocumentId = rs.getLong("bank_document_id");
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                Date birthday = rs.getDate("birthday");
//                String passportSeria = rs.getString("passport_seria");
//                String passportNumber = rs.getString("passport_number");
//
//                Customer c = new Customer(
//                        id,
//                        bankDocumentId,
//                        firstName,
//                        lastName,
//                        birthday,
//                        passportSeria,
//                        passportNumber
//                );
                Customer c = map(rs);
                allCustomers.add(c);

            }

            return allCustomers;

        } catch (SQLException exc) {
            System.err.println("Error during loading customers from database");
            System.err.println("Sql error: " + exc.getSQLState());
            throw new RuntimeException(exc);
        }



    }

    @Override
    public Customer byId(Integer customerId) {
        try (Connection conn = cm.openConnection()){
            PreparedStatement stmt = conn.prepareStatement("select * from customers where id = ?");
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

//            if (rs.next()) {
//                return map(rs);
//            } else {
//                return null;
//            }
            // тоже что и выше
            return rs.next() ? map(rs) : null;

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }

    private Customer map(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        long bankDocumentId = rs.getLong("bank_document_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Date birthday = rs.getDate("birthday");
        String passportSeria = rs.getString("passport_seria");
        String passportNumber = rs.getString("passport_number");

        return new Customer (
                id,
                bankDocumentId,
                firstName,
                lastName,
                birthday,
                passportSeria,
                passportNumber
        );
    }

    @Override
    public Customer create(
            long bdId,
            String firstName,
            String lastName,
            Date birthday,
            String passportSeria,
            String passportNumber
    ) {
        try (Connection conn = cm.openConnection()) {
            PreparedStatement stmt = conn.prepareStatement("insert into customers (bank_document_id, first_name, last_name, birthday, passport_seria, passport_number) values (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            stmt.setLong(1, bdId);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setDate(4, birthday);
            stmt.setString(5, passportSeria);
            stmt.setString(6, passportNumber);

            int rowsAffected = stmt.executeUpdate(); // используется для insert, delete, update ddl команд
            System.out.println("Added rows: " + rowsAffected);

            // получение сгунерированный ID после create
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int generratedCustomerId = rs.getInt(1);

            return new Customer(
                    generratedCustomerId,
                    bdId,
                    firstName,
                    lastName,
                    birthday,
                    passportSeria,
                    passportNumber
            );


        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }
}
