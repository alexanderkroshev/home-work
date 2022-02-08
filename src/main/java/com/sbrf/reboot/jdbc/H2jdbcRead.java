package com.sbrf.reboot.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2jdbcRead {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/testdb";

    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        create();
       // read();
    }

    public static List<Registration> read() {
        List<Registration> registrationList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            Class.forName(JDBC_DRIVER);

            String sql = "SELECT id, first, last, age FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

               registrationList.add(new Registration(id, age, first, last));
            }
            rs.close();
            return registrationList;

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }

        return registrationList;
    }

    public static void insert() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            Class.forName(JDBC_DRIVER);

            String sql;

            sql = "INSERT INTO registration " + "VALUES(105, 'Naum', 'Sergo', 26)";
            stmt.executeUpdate(sql);

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }

    public static void create() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            Class.forName(JDBC_DRIVER);

            String sql = "CREATE TABLE IF NOT EXISTS CUSTOMER  " +
                    "(id BIGINT not NULL, " +
                    " name VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }
}

@Data
@AllArgsConstructor
@ToString
class Registration {
    private int id;
    private int Age;
    private String First;
    private String Last;

}

