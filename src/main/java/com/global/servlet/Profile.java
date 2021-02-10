package com.global.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Profile extends HttpServlet {
    public static final String ATT_FORM = "form";
    public static final String VIEW = "/WEB-INF/views/profile.jsp";
    public static final String URL_REDIRECTION = "/profile";


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProfileForm form = new ProfileForm();

        form.updateUser(request);

        if (form.getErrors().isEmpty()) {
            response.sendRedirect(URL_REDIRECTION);
        } else {
            request.setAttribute(ATT_FORM, form);
            this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
        }
    }
}
