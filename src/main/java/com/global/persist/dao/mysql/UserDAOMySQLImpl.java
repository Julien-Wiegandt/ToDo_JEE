package com.global.persist.dao.mysql;

import com.global.core.bean.User;
import com.global.persist.dao.UserDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOMySQLImpl implements UserDAO {

    @Override
    public User findUserById(String id) {
        User user = null;
        try {
            PreparedStatement statement = MySQLConnection.connection.prepareStatement("SELECT * FROM User WHERE user_pk = ?;");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            statement.close();
            String email = rs.getString("email");
            String password = rs.getString("password");
            rs.close();
            user = new User(id, email, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = null;
        try {
            PreparedStatement statement = MySQLConnection.connection.prepareStatement("SELECT * FROM User WHERE email = ?;");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            statement.close();
            String id = rs.getString("user_pk");
            String password = rs.getString("password");
            rs.close();
            user = new User(id, email, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void createUser(User user) {
        try {
            PreparedStatement statement = MySQLConnection.connection.prepareStatement("INSERT INTO User (user_pk, email, password) VALUES (null, ?, ?);");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
