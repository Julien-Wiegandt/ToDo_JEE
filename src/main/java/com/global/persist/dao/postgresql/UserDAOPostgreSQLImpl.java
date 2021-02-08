package com.global.persist.dao.postgresql;

import com.global.core.bean.User;
import com.global.persist.dao.UserDAO;

public class UserDAOPostgreSQLImpl implements UserDAO {
    @Override
    public User findUserById(String id) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void updateUser(User user) throws Exception {

    }
}
