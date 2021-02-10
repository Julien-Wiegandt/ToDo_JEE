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

public class Index extends HttpServlet {
    public static final String VIEW = "/WEB-INF/views/index.jsp";
    public static final String URL_REDIRECTION = "/index";

    public static final String CURRENT_TASKLIST_ID = "current_tasklist_id";
    public static final String TASKS = "tasks";
    public static final String TASKLIST = "taskLists";
    public static final String TASKLIST_ID_INPUT = "taskList";

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /* getting the user session */
        HttpSession session = request.getSession();
        User user = (User) (session.getAttribute(Login.ATT_USER_SESSION));
        String current_tasklist_id = (String) session.getAttribute(CURRENT_TASKLIST_ID);

        ArrayList<TaskList> taskLists = null;
        ArrayList<Task> tasks = null;

        if (user != null) {
            /* Get the TaskLists from the current user in the database */
            try { taskLists = (ArrayList) TaskListFacade.getTaskListFacade().getTasksList(user.getId()); } catch (Exception e) { e.printStackTrace(); }

            /* Send them to the jsp */
            request.setAttribute(TASKLIST, taskLists);

            /* Get the Tasks from the current user */
            try { tasks = (ArrayList) TaskFacade.getTaskFacade().getTasks(user.getId()); } catch (Exception e) { e.printStackTrace(); }

            /* send them to the jsp */
            request.setAttribute(TASKS, tasks);

            /* set the current taskList displayed id */
            if (current_tasklist_id == null && !taskLists.isEmpty()) {
                current_tasklist_id = taskLists.get(0).getId();
            }
            session.setAttribute(CURRENT_TASKLIST_ID, current_tasklist_id);
        }
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        session.setAttribute(CURRENT_TASKLIST_ID, request.getParameter(TASKLIST_ID_INPUT));

        response.sendRedirect(URL_REDIRECTION);
    }

    public void destroy() {
    }
}