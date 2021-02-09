package com.global.core.facade;

import com.global.core.bean.Task;
import com.global.core.bean.TaskList;
import com.global.core.bean.User;
import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.TaskDAO;
import com.global.persist.dao.UserDAO;
import com.global.persist.dao.mysql.MySQLDAOFactory;
import com.global.persist.dao.postgresql.PostgreSQLDAOFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

public class TaskFacade {
    private DAOFactory daoFactory;
    private TaskDAO taskDAO;
    private static TaskFacade instance;

    private TaskFacade() throws Exception {
        try {
            Properties prop=new Properties();
            FileInputStream ip= new FileInputStream("C:\\Users\\wiega\\Google Drive\\Development\\IdeaProjects\\ToDo_JEE\\config.properties");
            prop.load(ip);
            if(prop.getProperty("databaseType").equals("MySQL")){
                this.daoFactory = new MySQLDAOFactory();
            }else{
                this.daoFactory = new PostgreSQLDAOFactory();
            }
            this.taskDAO = daoFactory.createTaskDAO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TaskFacade getTaskFacade() throws Exception {
        if (instance == null) {
            instance = new TaskFacade();
        }
        return instance;
    }

    public Collection<Task> getTasks(String user_id) throws SQLException { return this.taskDAO.getTasks(user_id); }

    public void addTask(String label, String user_id) throws SQLException {
        this.taskDAO.addTask(new Task(null, label, user_id));
    }

    public void deleteTask(String id) throws SQLException{
        this.taskDAO.deleteTask(id);
    }

    public void updateTask(String label, String user_id) throws SQLException{
        this.taskDAO.updateTask(new Task(null, label, user_id));
    }
}