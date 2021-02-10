package com.global.persist.dao.mysql;

import com.global.core.bean.Task;
import com.global.persist.dao.TaskDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class TaskDAOMySQLImpl implements TaskDAO {
    @Override
    public Collection<Task> getTasks(String user_id) {
        Collection<Task> tasks = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("SELECT * FROM Task, TaskList WHERE  user_fk=? AND tasklist_fk=tasklist_pk;");
            statement.setInt(1, Integer.valueOf(user_id));
            rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("task_pk");
                String label = rs.getString("label");
                String taskList_id = rs.getString("tasklist_fk");
                tasks.add(new Task(id, label, taskList_id));
            }
            statement.close();
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            System.out.println("Tasks getted.");
        }
        return tasks;
    }


    @Override
    public void addTask(Task task) {
        PreparedStatement statement = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("INSERT INTO Task (task_pk, label, tasklist_fk) VALUES (null, ?, ?);");
            statement.setString(1, task.getLabel());
            statement.setInt(2, Integer.valueOf(task.getList_fk()));
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            System.out.println("Task added.");
        }
    }

    @Override
    public void deleteTask(String id) {
        PreparedStatement statement = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("DELETE FROM Task WHERE task_pk=?;");
            statement.setString(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            System.out.println("Task deleted.");
        }
    }

    @Override
    public void updateTask(Task task) {
        PreparedStatement statement = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("UPDATE Task SET label=? WHERE task_pk=?");
            statement.setString(1, task.getLabel());
            statement.setString(2, task.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            System.out.println("Task updated.");
        }
    }
}
