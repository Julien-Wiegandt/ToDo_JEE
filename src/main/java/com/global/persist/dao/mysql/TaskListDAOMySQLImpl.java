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
        }
        return taskLists;
    }
}
