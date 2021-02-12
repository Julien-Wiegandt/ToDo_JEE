package com.global.core.facade;

import com.global.core.bean.Task;
import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.TaskDAO;
import com.global.persist.dao.mysql.MySQLDAOFactory;
import com.global.persist.dao.postgresql.PostgreSQLDAOFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

public class TaskFacade {
    private static TaskFacade instance;
    private DAOFactory daoFactory;
    private TaskDAO taskDAO;
    private String DATABASE_TYPE = "DATABASE_TYPE";

    private TaskFacade() throws Exception {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");) {
            Properties prop = new Properties();
            prop.load(input);

            if (prop.getProperty(DATABASE_TYPE).equals("MySQL")) {
                this.daoFactory = new MySQLDAOFactory();
            } else {
                this.daoFactory = new PostgreSQLDAOFactory();
            }
            this.taskDAO = daoFactory.createTaskDAO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TaskFacade getTaskFacade() throws Exception{
        if (instance == null) {
            instance = new TaskFacade();
        }
        return instance;
    }

    public Collection<Task> getTasks(String user_id) {
        return this.taskDAO.getTasks(user_id);
    }

    public void addTask(String label, String user_id) {
        this.taskDAO.addTask(new Task(null, label, user_id));
    }

    public void deleteTask(String id) {
        this.taskDAO.deleteTask(id);
    }

    public void updateTask(String label, String user_id) {
        this.taskDAO.updateTask(new Task(null, label, user_id));
    }
}
