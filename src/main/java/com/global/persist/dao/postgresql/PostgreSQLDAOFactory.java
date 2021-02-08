package com.global.persist.dao.postgresql;

import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.TaskDAO;
import com.global.persist.dao.TaskListDAO;
import com.global.persist.dao.UserDAO;

public class PostgreSQLDAOFactory extends DAOFactory {

    public PostgreSQLDAOFactory(){
        //Faire connection
    }

    public UserDAO createUserDAO(){
        return new UserDAOPostgreSQLImpl();
    }

    @Override
    public TaskDAO createTaskDAO() {
        return null;
    }

    @Override
    public TaskListDAO createTaskListDAO() {
        return null;
    }
}
