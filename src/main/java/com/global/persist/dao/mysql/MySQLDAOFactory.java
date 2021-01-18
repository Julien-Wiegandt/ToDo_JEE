package com.global.persist.dao.mysql;

import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.UserDAO;

public class MySQLDAOFactory extends DAOFactory {
    public MySQLDAOFactory(){
        //Faire la connection
    }

    public UserDAO createUserDAO(){
        return new UserDAOMySQLImpl();
    }
}
