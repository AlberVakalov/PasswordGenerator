package org.example;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/passwordgenerator";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "RootTest";

    public static Connection getConnection() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(DB_URL);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);

        return dataSource.getConnection();
    }
}
