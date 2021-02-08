package com.global.persist.dao.mysql;

import com.global.core.bean.Task;
import com.global.core.bean.TaskList;
import com.global.persist.dao.TaskDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class TaskDAOMySQLImpl implements TaskDAO {
    @Override
    public Collection<Task> getTasks(String taskList_id) throws SQLException {
        Collection<Task> tasks = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = MySQLConnection.connection.prepareStatement("SELECT * FROM Task WHERE tasklist_fk = ?;");
            statement.setString(1, taskList_id);
            rs = statement.executeQuery();
            while(rs.next()) {
                String id = rs.getString("task_pk");
                String label = rs.getString("label");
                tasks.add(new Task(id, label, taskList_id));
            }
            statement.close();
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tasks;
    }
}
