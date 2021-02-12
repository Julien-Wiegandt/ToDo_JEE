package com.global.core.facade;

import com.global.core.bean.User;
import com.global.persist.dao.DAOFactory;
import com.global.persist.dao.UserDAO;
import com.global.persist.dao.mysql.MySQLDAOFactory;
import com.global.persist.dao.postgresql.PostgreSQLDAOFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class UserFacade {

    private static UserFacade instance;
    private DAOFactory daoFactory;
    private UserDAO userDAO;
    private String DATABASE_TYPE = "DATABASE_TYPE";

    private UserFacade() throws Exception {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("/database.properties");) {
            Properties prop = new Properties();
            prop.load(input);

            if (prop.getProperty(DATABASE_TYPE).equals("MySQL")) {
                this.daoFactory = new MySQLDAOFactory();
            } else {
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

    public User findUserbyId(String id) throws SQLException {
        return this.userDAO.findUserById(id);
    }

    public User findUserByEmail(String email) throws SQLException {
        return this.userDAO.findUserByEmail(email);
    }

    public void createUser(String email, String password) throws Exception {
        this.userDAO.createUser(new User(null, email, password));
    }

    public void updateUser(String id, String email, String password) throws Exception {
        this.userDAO.updateUser(new User(id, email, password));
    }

    public Boolean verifyPassword(String id, String password){
        return this.userDAO.verifyPassword(id, password);
    }

    public void deleteUser(String id) {
        this.userDAO.deleteUser(id);
    }
}
