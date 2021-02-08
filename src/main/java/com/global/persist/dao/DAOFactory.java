package com.global.persist.dao;

public abstract class DAOFactory {

    public abstract UserDAO createUserDAO();

    public abstract TaskDAO createTaskDAO();

    public abstract TaskListDAO createTaskListDAO();
}
