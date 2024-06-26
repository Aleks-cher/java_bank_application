package ru.levelup.bank.repository.jdbc;

import lombok.RequiredArgsConstructor;
import ru.levelup.bank.domain.Account;
import ru.levelup.bank.domain.AccountEntity;
import ru.levelup.bank.domain.Payment;
import ru.levelup.bank.domain.PaymentStatus;
import ru.levelup.bank.jdbc.JdbcConnectionManager;
import ru.levelup.bank.repository.PaymentRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class JdbcPaymentRepository implements PaymentRepository {

    private final JdbcConnectionManager cm;

//    @Override
//    public Payment createPayment(Timestamp date, BigDecimal amount, int accountFrom, int accountTo, String paymentStatus) {
//        try (Connection conn = cm.openConnection()) {
//            PreparedStatement stmt = conn.prepareStatement("insert into payments (date, amount, account_from, account_to, status) values (?, ?, ?, ?, ?)",
//                    Statement.RETURN_GENERATED_KEYS
//            );
//            stmt.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
//            stmt.setBigDecimal(2, amount);
//            stmt.setInt(3, accountFrom);
//            stmt.setInt(4, accountTo);
//            stmt.setString(5, paymentStatus.toString());
//
//            int rowsAffected = stmt.executeUpdate();
//            System.out.println("Added rows: " + rowsAffected);
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            int generratedPaymentId = rs.getInt(1);
//
//            return new Payment(generratedPaymentId, Timestamp.valueOf(LocalDateTime.now()), amount, accountFrom, accountTo, paymentStatus);
//
//        } catch (SQLException exc) {
//            throw new RuntimeException(exc);
//        }
//    }

    @Override
    public Payment createPayment(Timestamp date, BigDecimal amount, AccountEntity accountEntity1, AccountEntity accountEntity2, String paymentStatus) {
        return null;
    }

    @Override
    public List<Account> byAccountId(Payment payment) {
        return null;
    }

//    @Override
//    public List<Account> byAccountId(Payment payment) {
//        try (Connection conn = cm.openConnection()) {
//            PreparedStatement stmt = conn.prepareStatement("select * from accounts where id = ? or id = ?");
//            stmt.setInt(1, payment.getAccountFrom());
//            stmt.setInt(2, payment.getAccountTo());
//
//            List<Account> accounts = new ArrayList<>();
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String accountNumber = rs.getString("account_number");
//                String type = rs.getString("type");
//                String status = rs.getString("status");
//                Date openDatetime = rs.getDate("open_datetime");
//                long bd_id = rs.getLong("bd_id");
//
//                Account a = new Account(
//                        id,
//                        accountNumber,
//                        type,
//                        status,
//                        openDatetime,
//                        bd_id
//                );
//                accounts.add(a);
//            }
//            return accounts;
//
//        } catch (SQLException exc) {
//            throw new RuntimeException(exc);
//        }
//    }



    @Override
    public void changeStatus(int paymentId, PaymentStatus status) {

    }

    @Override
    public void changeStatus(int paymentId, String status) {

    }


    @Override
    public List<Payment> all() {
        return null;
    }

    @Override
    public List<Payment> byAccountId(AccountEntity accountId) {
        return null;
    }
}
