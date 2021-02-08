package com.global.persist.dao;

public abstract class DAOFactory {

    public abstract UserDAO createUserDAO();

    public abstract UserDAO createTaskDAO();

    public abstract UserDAO createTaskListDAO();
}
