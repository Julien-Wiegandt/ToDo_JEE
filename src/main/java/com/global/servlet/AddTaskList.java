package com.global.servlet;

import com.global.core.bean.Task;
import com.global.core.bean.TaskList;
import com.global.core.bean.User;
import com.global.core.facade.TaskFacade;
import com.global.core.facade.TaskListFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class AddTaskList extends HttpServlet {
    public static final String ATT_FORM = "AddTaskListForm";
    public static final String URL_REDIRECTION = "/index";
    public static final String VIEW = "/WEB-INF/views/index.jsp";


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AddTaskListForm form = new AddTaskListForm();

        form.createTaskList(request);

        HttpSession session = request.getSession();
        User user = (User) (session.getAttribute(Login.ATT_USER_SESSION));

        ArrayList<TaskList> taskLists = null;
        ArrayList<Task> tasks = null;

        if (user != null) {

            try {
                taskLists = (ArrayList) TaskListFacade.getTaskListFacade().getTasksList(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute(Index.TASKLIST, taskLists);

            if (!taskLists.isEmpty()) {
                try {
                    tasks = (ArrayList) TaskFacade.getTaskFacade().getTasks(user.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute(Index.TASKS, tasks);
            }
        }

        if (!form.getErrors().isEmpty()) {
            request.setAttribute(ATT_FORM, form);
        }

        session.setAttribute(Index.CURRENT_TASKLIST_ID, taskLists.get(taskLists.size()-1).getId());
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }
}
