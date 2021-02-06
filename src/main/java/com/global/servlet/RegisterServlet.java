package com.global.servlet;

import com.global.core.facade.UserFacade;
import com.global.persist.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("get register view");
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String email = request.getParameter("inputEmail");
        String password1 = request.getParameter("inputPassword1");
        String password2 = request.getParameter("inputPassword2");
        System.out.println(email);
        System.out.println(password1);
        System.out.println(password2);
        if(password1.equals(password2)){
            UserFacade.getUserFacade().createUser(email, password1);
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
