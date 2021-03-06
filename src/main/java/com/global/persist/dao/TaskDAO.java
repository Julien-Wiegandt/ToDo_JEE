package com.global.persist.dao;

import com.global.core.bean.Task;

import java.sql.SQLException;
import java.util.Collection;

public interface TaskDAO {
    public Collection<Task> getTasks(String user_id);

    public void addTask(Task task);

    public void deleteTask(String id);

    public void updateTask(Task task);
}
