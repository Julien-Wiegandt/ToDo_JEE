package com.global.persist.dao.mysql;

import com.global.core.bean.User;
import com.global.persist.dao.UserDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOMySQLImpl implements UserDAO {

    @Override
    public User findUserById(String id) throws SQLException {
        User user = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("SELECT * FROM User WHERE user_pk = ?;");
            statement.setString(1, id);
            rs = statement.executeQuery();
            while(rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                user = new User(id, email, password);
            }
            statement.close();
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("SELECT * FROM User WHERE email = ?;");
            statement.setString(1, email);
            rs = statement.executeQuery();
            while(rs.next()) {
                String id = rs.getString("user_pk");
                String password = rs.getString("password");
                user = new User(id, email, password);
            }
            statement.close();
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void createUser(User user) throws Exception {
        PreparedStatement statement = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("INSERT INTO User (user_pk, email, password) VALUES (null, ?, ?);");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            switch (throwables.getErrorCode()){
                case 1062:
                    throw new Exception( "E-mail address already used." );
                default:
                    break;
            }
        }
    }

    @Override
    public void updateUser(User user) throws Exception {
        PreparedStatement statement = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("UPDATE User SET email=?, password=? WHERE user_pk=?;");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            switch (throwables.getErrorCode()){
                case 1062:
                    throw new Exception( "E-mail address already used." );
                default:
                    throw new Exception( "Update User in database issue." );
            }
        }
    }
}
