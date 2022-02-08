package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerH2Repository implements CustomerRepository {

    public static void main(String[] args) {
        CustomerH2Repository repository = new CustomerH2Repository();
        //   repository.createCustomer();
        //("Bob", "bob@email.ru");
        List<Customer> customers = repository.getAll();
        System.out.println(customers);
        System.out.println(customers.stream().map(x -> x.getId()).collect(Collectors.toList()));
    }

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

            Class.forName(JDBC_DRIVER);

            // String sql = "SELECT name, email FROM CUSTOMER";
            String sql = "SELECT * FROM CUSTOMER";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String eMail = rs.getString("email");

                customers.add(new Customer(id, name, eMail));
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
        return customers;
    }


    //  public boolean createCustomer(String name, String eMail) {
    @Override
    public void createCustomer() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            Class.forName(JDBC_DRIVER);

            String sql;

            sql = "INSERT INTO CUSTOMER (name, email) " + "VALUES('Krosh', 'krosh@mail')";
            stmt.executeUpdate(sql);

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
        //return true;
    }
}




