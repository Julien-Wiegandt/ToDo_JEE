package com.global.servlet;

import com.global.core.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {
    public static final String ATT_FORM = "form";
    public static final String ATT_USER_SESSION = "userSession";
    public static final String URL_REDIRECTION = "/";
    public static final String VIEW = "/WEB-INF/views/login.jsp";

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginForm form = new LoginForm();

        User user = form.connectUser(request);

        HttpSession session = request.getSession();

        if (form.getErrors().isEmpty()) {
            session.setAttribute(ATT_USER_SESSION, user);
            response.sendRedirect(URL_REDIRECTION);
        } else {
            request.setAttribute(ATT_FORM, form);
            this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
        }
    }

    public void destroy() {
    }
}
