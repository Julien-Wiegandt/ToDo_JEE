package com.global.servlet;

import com.global.core.bean.User;
import com.global.core.facade.UserFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Login extends HttpServlet {
    public static final String ATT_USER         = "user";
    public static final String ATT_FORM         = "form";
    public static final String ATT_USER_SESSION = "userSession";
    public static final String VIEW              = "/WEB-INF/views/login.jsp";

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
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
        LoginForm form = new LoginForm();

        User user = form.connectUser(request);

        HttpSession session = request.getSession();

        if ( form.getErrors().isEmpty() ) {
            session.setAttribute( ATT_USER_SESSION, user );
        } else {
            session.setAttribute( ATT_USER_SESSION, null );
        }
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, user );

        this.getServletContext().getRequestDispatcher(VIEW).forward( request, response );
    }

    public void destroy() {
    }
}
