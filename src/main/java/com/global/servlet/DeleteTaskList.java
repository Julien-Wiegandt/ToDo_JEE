package com.global.servlet;

import com.global.core.bean.TaskList;
import com.global.core.facade.TaskListFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTaskList extends HttpServlet {
    private static final String TASKLIST_INPUT = "deleteTaskList";
    public static final String URL_REDIRECTION = "/";
    public static final String VIEW            = "/";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String taskList_id = request.getParameter(TASKLIST_INPUT);

        try {
            TaskListFacade.getTaskListFacade().deleteTaskList(taskList_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }
}
