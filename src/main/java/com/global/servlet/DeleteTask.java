package com.global.servlet;

import com.global.core.facade.TaskFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTask extends HttpServlet {
    public static final String URL_REDIRECTION = "/index";
    public static final String VIEW = "/WEB-INF/views/index.jsp";
    private static final String TASK_INPUT = "deleteTask";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String task_id = request.getParameter(TASK_INPUT);

        try {
            TaskFacade.getTaskFacade().deleteTask(task_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(URL_REDIRECTION);
    }
}
