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
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String email = request.getParameter("inputEmail");
        String password1 = request.getParameter("inputPassword1");
        String password2 = request.getParameter("inputPassword2");

        if(password1.equals(password2)){
            UserFacade.get
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
