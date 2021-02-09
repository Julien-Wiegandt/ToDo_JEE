package com.global.persist.dao.mysql;

import com.global.core.bean.TaskList;
import com.global.core.bean.User;
import com.global.persist.dao.TaskListDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

public class TaskListDAOMySQLImpl implements TaskListDAO {
    @Override
    public Collection<TaskList> getTasksList(String user_id) throws SQLException {
        Collection<TaskList> taskLists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("SELECT * FROM TaskList WHERE user_fk = ?;");
            statement.setString(1, user_id);
            rs = statement.executeQuery();
            while(rs.next()) {
                String id = rs.getString("tasklist_pk");
                String label = rs.getString("label");
                taskLists.add(new TaskList(id, label, user_id));
            }
            statement.close();
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            System.out.println("TaskLists getted.");
        }
        return taskLists;
    }

    @Override
    public void addTaskList(TaskList taskList) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("INSERT INTO TaskList (tasklist_pk, label, user_fk) VALUES (null, ?, ?);");
            statement.setString(1, taskList.getLabel());
            statement.setString(2, taskList.getUser_fk());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            System.out.println("TaskList added.");
        }
    }

    @Override
    public void deleteTaskList(String id) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("DELETE FROM Task WHERE tasklist_fk=?;");
            statement.setString(1, id);
            statement.executeUpdate();
            statement = MySQLConnection.connection.prepareStatement("DELETE FROM TaskList WHERE tasklist_pk=?;");
            statement.setString(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            System.out.println("TaskList deleted.");
        }
    }

    @Override
    public void updateTaskList(TaskList taskList) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("UPDATE TaskList SET label=? WHERE tasklist_pk=?");
            statement.setString(1, taskList.getLabel());
            statement.setString(2, taskList.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            System.out.println("TaskList updated.");
        }
    }
}
