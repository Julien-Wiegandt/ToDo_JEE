package com.global.persist.dao;

import com.global.core.bean.TaskList;

import java.sql.SQLException;
import java.util.Collection;

public interface TaskListDAO {
    public Collection<TaskList> getTasksList(String user_id);

    public void addTaskList(TaskList taskList);

    public void deleteTaskList(String id);

    public void updateTaskList(TaskList taskList);
}
