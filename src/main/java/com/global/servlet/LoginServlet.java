package com.global.servlet;

import com.global.core.bean.User;
import com.global.core.facade.UserFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @// TODO: 06/02/2021 handle exception 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");

        User user = null;
        try {
            user = UserFacade.getUserFacade().findUserByEmail(email);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(user != null && user.getPassword().equals(password)){
            request.setAttribute("user", user);
            System.out.println("Login lunched");
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
        }else{
            System.out.println("Login issue");
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}
