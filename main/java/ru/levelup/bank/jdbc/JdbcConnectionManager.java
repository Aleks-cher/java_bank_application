package ru.levelup.bank.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Отвечает за подключение к БД
public class JdbcConnectionManager {

    // JDBC - java database Connectivity
    // Drivers

    public Connection openConnection() throws SQLException {
        // getConnection устанавливает новое соединение из программы к БД
        // url подключение к БД
        // jdbc:<vendor_name>://<host>:<port>/<db_name>
        return DriverManager.getConnection(
               "jdbc:postgresql://127.0.0.1:5432/lk-bank",
                "postgres",
                "23472"
        );
    }
}
