package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomerH2Repository implements CustomerRepository {

    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:~/my_db";

    private final String USER = "sa";
    private final String PASS = "";

    public CustomerH2Repository() {
        String sql = "CREATE TABLE IF NOT EXISTS CUSTOMER  " +
                "(id BIGINT not NULL PRIMARY KEY AUTO_INCREMENT, " +
                " name VARCHAR(255), " +
                " email VARCHAR(255));";
        withStatement(stmt -> stmt.executeUpdate(sql));
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMER";
        withStatement(stmt -> withResultSet(customers, sql, stmt));
        return customers;
    }

    @Override
    public boolean createCustomer(String name, String eMail) {
        AtomicBoolean savedOrNot = new AtomicBoolean(false);
        String sql = "INSERT INTO CUSTOMER (name, email) " + "VALUES('" + name + "','" + eMail + "')";
        withStatement(stmt -> {
                    stmt.executeUpdate(sql);
                    savedOrNot.set(true);
                }
        );
        return savedOrNot.get();
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMER WHERE UPPER(NAME) LIKE '%" + name.toUpperCase(Locale.ROOT) + "%'";
        withStatement(stmt -> withResultSet(customers, sql, stmt));
        return customers;
    }


    @Override
    public void truncate() {
        String sql = "TRUNCATE TABLE CUSTOMER";
        withStatement(stmt -> stmt.executeUpdate(sql));
    }

    private void withStatement(SQLConsumer<Statement> statementConsumer) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            Class.forName(JDBC_DRIVER);
            statementConsumer.accept(stmt);
        } catch (SQLException | ClassNotFoundException se) {
            throw new RuntimeException(se);
        }
    }

    private void withResultSet(List<Customer> customers, String sql, Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            customers.add(new Customer(rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email")));
        }
        rs.close();
    }

}




