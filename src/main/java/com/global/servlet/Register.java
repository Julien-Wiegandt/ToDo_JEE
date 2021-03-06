package com.global.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet {
    public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String URL_REDIRECTION = "/login";
    public static final String VIEW = "/WEB-INF/views/register.jsp";

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RegisterForm form = new RegisterForm();

        form.createUser(request);

        if (form.getErrors().isEmpty()) {
            response.sendRedirect(URL_REDIRECTION);
        } else {
            request.setAttribute(ATT_FORM, form);
            this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
        }
    }

    public void destroy() {
    }
}
