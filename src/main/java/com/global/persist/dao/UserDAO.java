package com.global.persist.dao;

import com.global.core.bean.User;

public interface UserDAO {

    public User findUserById(String id);

    public User findUserByEmail(String email);

    public void createUser(User user);
}
