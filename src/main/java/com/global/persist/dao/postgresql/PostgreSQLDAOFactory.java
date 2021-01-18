package com.global.persist.dao.postgresql;

import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.UserDAO;

public class PostgreSQLDAOFactory extends DAOFactory {

    public PostgreSQLDAOFactory(){
        //Faire connection
    }

    public UserDAO createUserDAO(){
        return new UserDAOPostgreSQLImpl();
    }
}
