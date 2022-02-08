package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerH2Repository implements CustomerRepository {

    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:~/my_db";

    private final String USER = "sa";
    private final String PASS = "";

    public CustomerH2Repository() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            Class.forName(JDBC_DRIVER);
            String sql = "CREATE TABLE IF NOT EXISTS CUSTOMER  " +
                    "(id BIGINT not NULL PRIMARY KEY AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " email VARCHAR(255));";
            stmt.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM CUSTOMER";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                customers.add(new Customer(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")));
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean createCustomer(String name, String eMail) {
        boolean savedOrNot = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            String sql;
            sql = "INSERT INTO CUSTOMER (name, email) " + "VALUES('" + name + "','" + eMail + "')";
            stmt.executeUpdate(sql);
            savedOrNot = true;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return savedOrNot;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            String sql;
            sql = "SELECT * FROM CUSTOMER WHERE NAME = '" + name + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                customers.add(new Customer(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}




