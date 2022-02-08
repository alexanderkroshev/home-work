package com.sbrf.reboot.jdbc;


import java.sql.*;
import java.util.Optional;

public class FromLesson {

    public Optional<String> selectTwoColumns() throws SQLException {
        try (Connection connection = getConnection().orElseThrow(RuntimeException::new)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("select name, age from animal")) {
                    if (resultSet.next()) {
                        return Optional.of(String.format("Name: %s, age: %d", resultSet.getString("NAME"), resultSet.getInt("age")));
                    } else {
                        return Optional.empty();
                    }
                }
            }
        }
    }

    private Optional<Connection> getConnection() throws SQLException {
        return Optional.ofNullable(DriverManager.getConnection("jdbc:h2:mem:testdb"));
    }
}
