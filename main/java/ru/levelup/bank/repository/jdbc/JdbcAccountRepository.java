package ru.levelup.bank.repository.jdbc;

import lombok.RequiredArgsConstructor;
import ru.levelup.bank.domain.Account;
import ru.levelup.bank.domain.Customer;
import ru.levelup.bank.jdbc.JdbcConnectionManager;
import ru.levelup.bank.repository.AccountRepository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class JdbcAccountRepository implements AccountRepository {

    private final JdbcConnectionManager cm;

    @Override
    public List<Account> allAcc() {
        try (Connection conn = cm.openConnection()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from accounts");

            List<Account> allAccount = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String accountNumber = rs.getString("account_number");
                String type = rs.getString("type");
                String status = rs.getString("status");
                Date openDatetime = rs.getDate("open_datetime");
                long bd_id = rs.getLong("bd_id");

                Account a = new Account(
                        id,
                        accountNumber,
                        type,
                        status,
                        openDatetime,
                        bd_id
                );
                allAccount.add(a);

            }
            return allAccount;

        } catch (SQLException exc) {
            System.err.println("Error during loading accounts from database");
            System.err.println("Sql error: " + exc.getSQLState());
            throw new RuntimeException(exc);
        }
    }


    @Override
    public Account create(String account_number, String type, String status, Customer customer) {
        try (Connection conn = cm.openConnection()) {
            PreparedStatement stmt = conn.prepareStatement("insert into accounts (account_number, open_datetime, type, status, bd_id) values (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            stmt.setString(1, account_number);
            stmt.setDate(2, Date.valueOf(LocalDate.now()));
            stmt.setString(3, type);
            stmt.setString(4, status);
            stmt.setLong(5, customer.getBankDocumentId());


            int rowsAffected = stmt.executeUpdate();
            System.out.println("Added rows: " + rowsAffected);

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int generratedAccountId = rs.getInt(1);

            return new Account(generratedAccountId, account_number, type, status, Date.valueOf(LocalDate.now()), customer.getBankDocumentId());

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void update(Account account) {
        try (Connection conn = cm.openConnection()) {
            PreparedStatement stmt = conn.prepareStatement("update accounts set account_number = ?, type = ?, status = ?, open_datetime = ?, bd_id = ?");
            stmt.setString(1, account.getAccount_number());
            stmt.setString(2, account.getType());
            stmt.setString(3, account.getStatus());
            stmt.setDate(4, account.getOpen_datetime());
            stmt.setLong(5, account.getBd_id());
            stmt.executeUpdate();

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void remove(Integer id) {
        try (Connection conn = cm.openConnection()) {
            PreparedStatement stmt = conn.prepareStatement("delete from accounts where id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Account id delete: " + id);

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }

    private Account map(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String account_number = rs.getString("account_number");
        String type = rs.getString("type");
        String status = rs.getString("status");
        Date open_datetime = rs.getDate("open_datetime");
        long bd_id = rs.getLong("bd_id");

        return new Account(id, account_number, type, status, open_datetime, bd_id);
    }
}
