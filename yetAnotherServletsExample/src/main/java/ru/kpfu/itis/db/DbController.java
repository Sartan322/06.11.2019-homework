package ru.kpfu.itis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbController {
    String username = "sartan";
    String password = "123456";
    String url = "jdbc:postgresql://localhost:5432/postgres";


    Connection connection;

    public void connect(){
        {
            try {
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
