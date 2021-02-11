package com.global.persist.dao;

import com.global.core.bean.User;

import java.sql.SQLException;

public interface UserDAO {

    public User findUserById(String id) throws SQLException;

    public User findUserByEmail(String email) throws SQLException;

    public Boolean verifyPassword(String id, String password);

    public void createUser(User user) throws Exception;

    public void updateUser(User user) throws Exception;

    public void deleteUser(String id);
}
