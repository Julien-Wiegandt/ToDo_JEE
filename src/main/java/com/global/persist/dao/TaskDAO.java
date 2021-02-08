package com.global.persist.dao;

import com.global.core.bean.Task;

import java.sql.SQLException;
import java.util.Collection;

public interface TaskDAO {
    public Collection<Task> getTasks(String taskList_id) throws SQLException;
}
