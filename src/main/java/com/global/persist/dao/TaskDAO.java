package com.global.persist.dao;

import com.global.core.bean.Task;
import com.global.core.bean.TaskList;

import java.sql.SQLException;
import java.util.Collection;

public interface TaskDAO {
    public Collection<Task> getTasks(String user_id) throws SQLException;

    public void addTask(Task task) throws SQLException;

    public void deleteTask(String id) throws SQLException;

    public void updateTask(Task task) throws SQLException;
}
