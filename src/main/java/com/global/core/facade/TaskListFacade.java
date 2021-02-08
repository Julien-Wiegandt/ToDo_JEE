package com.global.core.facade;

import com.global.core.bean.User;
import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.TaskListDAO;
import com.global.persist.dao.UserDAO;
import com.global.persist.dao.mysql.MySQLDAOFactory;
import com.global.persist.dao.postgresql.PostgreSQLDAOFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class TaskListFacade {
    private DAOFactory daoFactory;
    private TaskListDAO taskListDAO;
    private static UserFacade instance;

    private TaskListFacade() throws Exception {
        try {
            Properties prop=new Properties();
            FileInputStream ip= new FileInputStream("C:\\Users\\wiega\\Google Drive\\Development\\IdeaProjects\\ToDo_JEE\\config.properties");
            prop.load(ip);
            if(prop.getProperty("databaseType").equals("MySQL")){
                this.daoFactory = new MySQLDAOFactory();
            }else{
                this.daoFactory = new PostgreSQLDAOFactory();
            }
            this.taskListDAO = daoFactory.createTaskListDAO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TaskListFacade getUserFacade() throws Exception {
        if (instance == null) {
            instance = new TaskListFacade();
        }
        return instance;
    }

    public User getTasksList(String user_id) throws SQLException { return this.taskListDAO.getTasksList(user_id); }
}
