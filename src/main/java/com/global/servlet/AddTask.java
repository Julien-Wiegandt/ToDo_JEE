package com.global.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTask extends HttpServlet {
    public static final String ATT_FORM        = "AddTaskForm";
    public static final String URL_REDIRECTION = "/index";
    public static final String VIEW            = "/index";


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AddTaskForm form = new AddTaskForm();

        String tasklist_id = form.createTask(request);

        if (form.getErrors().isEmpty()) {
            request.setAttribute(Index.CURRENT_TASKLIST_ID, tasklist_id);
        } else {
            request.setAttribute(ATT_FORM, form);
        }
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }
}
