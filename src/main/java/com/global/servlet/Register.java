package com.global.servlet;

import com.global.core.facade.UserFacade;
import com.global.persist.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Register extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @// TODO: 06/02/2021 handle exception 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String email = request.getParameter("inputEmail");
        String password1 = request.getParameter("inputPassword1");
        String password2 = request.getParameter("inputPassword2");
        if(password1.equals(password2)){
            try {
                UserFacade.getUserFacade().createUser(email, password1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("Register lunched");
        }
        else{
            System.out.println("Register issue");
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
