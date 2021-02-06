package com.global.core.facade;

import com.global.core.bean.User;
import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.UserDAO;
import com.global.persist.dao.mysql.MySQLDAOFactory;
import com.global.persist.dao.postgresql.PostgreSQLDAOFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserFacade {

    private DAOFactory daoFactory;
    private UserDAO userDAO;
    private static UserFacade instance;

    private UserFacade(){
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

    public static UserFacade getUserFacade() {
        if (instance == null) {
            instance = new UserFacade();
        }

        return instance;
    }

    public User findUserbyId(String id){ return this.userDAO.findUserById(id); }

    public User findUserByEmail(String email){
        return this.userDAO.findUserByEmail(email);
    }

    public void createUser(String email, String password){
        this.userDAO.createUser(new User(null, email, password));
    }
}
