package com.global.persist.dao.mysql;

import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.TaskDAO;
import com.global.persist.dao.TaskListDAO;
import com.global.persist.dao.UserDAO;

public class MySQLDAOFactory extends DAOFactory {
    public MySQLDAOFactory() throws Exception {
        new MySQLConnection();
    }

    public UserDAO createUserDAO(){
        return new UserDAOMySQLImpl();
    }

    public TaskDAO createTaskDAO(){
        return new TaskDAOMySQLImpl();
    }

    public TaskListDAO createTaskListDAO(){
        return new TaskListDAOMySQLImpl();
    }
}
