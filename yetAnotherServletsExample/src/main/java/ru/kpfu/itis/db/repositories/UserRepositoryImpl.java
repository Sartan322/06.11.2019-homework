package ru.kpfu.itis.db.repositories;

import db.models.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private Connection connection;

    private final String SQL_INSERT_USER = "INSERT INTO users (login, password, avatar, name, self_name, self_information, city, bDay) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final String SQL_SELECT_LOG_AND_PASS = "SELECT login, password FROM users WHERE login = ? AND password = ?";
    private final String SQL_DELETE_USER = "DELETE FROM users WHERE login = ? AND password = ?;";
    private final String SQL_UPDATE_USER = "UPDATE users SET name = ?, self_name = ?, self_information = ? WHERE login = ? AND password = ?";
    private final String SQL_SELECT_CITY = "SELECT city_name FROM citys WHERE city_id = ?";
    private final String SQL_SELECT_URL = "SELECT avatar_url FROM avatar_urls  WHERE avatar_name = ?";
    private final String SQL_SELECT_USER = "SELECT * FROM user WHERE login = ? AND passwrod = ?";


    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<User> userRowMapper = row -> {
        long id = row.getLong("user_id");
        String login = row.getString("login");
        String password = row.getString("password");
        String avatar = row.getString("avatar");
        String name = row.getString("name");
        String selfName = row.getString("self_name");
        String selfInformation = row.getString("self_information");
        int city = row.getInt("city");
        String bDay = row.getString("bDay");

        return new User(id, login, password, avatar, name, selfName, selfInformation, city, bDay);
    };

    @Override
    public boolean checkValidation(String testLogin, String testPass) {
        User user;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_LOG_AND_PASS);
            statement.setString(1, testLogin);
            statement.setString(2, testPass);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("pravilno");
                return true;
            } else {
                System.out.println("nepravilno");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String findCity(String id)    {
        String result = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CITY);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.getString("city_name");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String findUrl(String name) {
        String result = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_URL);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.getString("avatar_url");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void save(User model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getAvatar());
            statement.setString(4, model.getName());
            statement.setString(5, model.getSelfName());
            statement.setString(6, model.getSelfInformation());
            statement.setInt(7, model.getCity());
            statement.setString(8, model.getbDay());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(String login, String password, String name, String secondName, String information) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER);
            statement.setString(1, name);
            statement.setString(2, secondName);
            statement.setString(3, information);
            statement.setString(4,login);
            statement.setString(5,password);
            statement.executeQuery();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String login, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER);
            statement.setString(1,login);
            statement.setString(2,password);
            statement.executeQuery();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> find(Long id) {
        return null;
    }

    @Override
    public Optional<User> find(String login, String password) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = userRowMapper.mapRow(resultSet);
            }
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.ofNullable(user);
    }



    @Override
    public List<User> findAll() {
        return null;
    }

}
