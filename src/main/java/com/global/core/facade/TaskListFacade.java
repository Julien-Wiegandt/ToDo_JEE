package com.global.core.facade;

import com.global.core.bean.TaskList;
import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.TaskListDAO;
import com.global.persist.dao.mysql.MySQLDAOFactory;
import com.global.persist.dao.postgresql.PostgreSQLDAOFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

public class TaskListFacade {
    private static TaskListFacade instance;
    private DAOFactory daoFactory;
    private TaskListDAO taskListDAO;
    private String DATABASE_TYPE = "DATABASE_TYPE";

    private TaskListFacade() throws Exception {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");) {
            Properties prop = new Properties();
            prop.load(input);

            if (prop.getProperty(DATABASE_TYPE).equals("MySQL")) {
                this.daoFactory = new MySQLDAOFactory();
            } else {
                this.daoFactory = new PostgreSQLDAOFactory();
            }
            this.taskListDAO = daoFactory.createTaskListDAO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TaskListFacade getTaskListFacade() throws Exception{
        if (instance == null) {
            instance = new TaskListFacade();
        }
        return instance;
    }

    public Collection<TaskList> getTasksList(String user_id) {
        return this.taskListDAO.getTasksList(user_id);
    }

    public void addTaskList(String label, String user_id) {
        this.taskListDAO.addTaskList(new TaskList(null, label, user_id));
    }

    public void deleteTaskList(String id) throws SQLException {
        this.taskListDAO.deleteTaskList(id);
    }

    public void updateTaskList(String label, String user_id) {
        this.taskListDAO.updateTaskList(new TaskList(null, label, user_id));
    }
}
