package com.global.servlet;

import com.global.core.bean.Task;
import com.global.core.bean.TaskList;
import com.global.core.bean.User;
import com.global.core.facade.TaskFacade;
import com.global.core.facade.TaskListFacade;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Index extends HttpServlet {
    public static final String CURRENT_TASKLIST_ID = "current_tasklist_id";
    public static final String VIEW           = "/WEB-INF/views/index.jsp";
    public static final String TASKS          = "tasks";
    public static final String TASKLIST       = "taskLists";
    public static final String TASKLIST_ID_INPUT = "taskList";

    private ArrayList<Task> tasks;
    private ArrayList<TaskList> taskLists;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User)(session.getAttribute(Login.ATT_USER_SESSION));
        if(user != null){
            try {
                taskLists = (ArrayList) TaskListFacade.getTaskListFacade().getTasksList(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute(TASKLIST, taskLists);

            if(taskLists.get(0) != null){
                try {
                    tasks = (ArrayList) TaskFacade.getTaskFacade().getTasks(user.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute(TASKS, tasks);
                request.setAttribute(CURRENT_TASKLIST_ID, taskLists.get(0));
            }
        }
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String taskList_id = request.getParameter(TASKLIST_ID_INPUT);
        HttpSession session = request.getSession();
        User user = (User)(session.getAttribute(Login.ATT_USER_SESSION));
        if(user != null) {
            try {
                taskLists = (ArrayList) TaskListFacade.getTaskListFacade().getTasksList(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute(TASKLIST, taskLists);

            if (taskLists.get(0) != null) {
                try {
                    tasks = (ArrayList) TaskFacade.getTaskFacade().getTasks(user.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute(TASKS, tasks);
                request.setAttribute(CURRENT_TASKLIST_ID, taskList_id);
            }
        }
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }

    public void destroy() {
    }
}