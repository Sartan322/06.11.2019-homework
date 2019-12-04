package ru.kpfu.itis.Servlets;

import ru.kpfu.itis.db.DbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class testClass {


    public static void main(String[] args) {
        final String SQL_SELECT_USER = "SELECT * FROM user WHERE login = ? AND passwrod = ?";

        DbController dbController = new DbController();
        dbController.connect();
        Connection connection = dbController.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_USER);
            statement.setString(1, "test@bk.ru");
            statement.setString(2, "123123");
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
