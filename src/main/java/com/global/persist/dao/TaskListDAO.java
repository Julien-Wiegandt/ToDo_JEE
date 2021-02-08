package com.global.persist.dao;

import com.global.core.bean.User;

import java.sql.SQLException;

public interface TaskListDAO {
    public User getTasksList(String user_id) throws SQLException;
}
