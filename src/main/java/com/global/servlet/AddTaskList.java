package com.global.servlet;

import com.global.core.bean.User;
import com.global.core.facade.TaskFacade;
import com.global.core.facade.TaskListFacade;
import com.global.core.facade.UserFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddTaskList extends HttpServlet {
    public static final String ATT_FORM        = "AddTaskListForm";
    public static final String URL_REDIRECTION = "/";
    public static final String VIEW            = "/";


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AddTaskListForm form = new AddTaskListForm();

        form.createTaskList(request);

        if (form.getErrors().isEmpty()) {
            response.sendRedirect(URL_REDIRECTION);
        } else {
            request.setAttribute(ATT_FORM, form);
            this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
        }
    }
}
