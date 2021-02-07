package com.global.core.facade;

import com.global.core.bean.User;
import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.UserDAO;
import com.global.persist.dao.mysql.MySQLDAOFactory;
import com.global.persist.dao.postgresql.PostgreSQLDAOFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class UserFacade {

    private DAOFactory daoFactory;
    private UserDAO userDAO;
    private static UserFacade instance;

    private UserFacade() throws Exception {
        try {
            Properties prop=new Properties();
            FileInputStream ip= new FileInputStream("C:\\Users\\wiega\\Google Drive\\Development\\IdeaProjects\\ToDo_JEE\\config.properties");
            prop.load(ip);
            if(prop.getProperty("databaseType").equals("MySQL")){
                this.daoFactory = new MySQLDAOFactory();
            }else{
                this.daoFactory = new PostgreSQLDAOFactory();
            }
            this.userDAO = daoFactory.createUserDAO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserFacade getUserFacade() throws Exception {
        if (instance == null) {
            instance = new UserFacade();
        }

        return instance;
    }

    public User findUserbyId(String id) throws SQLException { return this.userDAO.findUserById(id); }

    public User findUserByEmail(String email) throws SQLException {
        return this.userDAO.findUserByEmail(email);
    }

    public void createUser(String email, String password) throws Exception {
        this.userDAO.createUser(new User(null, email, password));
    }
}
