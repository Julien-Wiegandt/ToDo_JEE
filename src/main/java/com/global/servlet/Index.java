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

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User)(session.getAttribute(Login.ATT_USER_SESSION));
        if(user != null){
            ArrayList<TaskList> taskLists = null;
            try {
                taskLists = (ArrayList) TaskListFacade.getTaskListFacade().getTasksList(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("taskLists", taskLists);

            if(taskLists.get(0) != null){
                ArrayList<Task> tasks = null;
                try {
                    tasks = (ArrayList) TaskFacade.getTaskFacade().getTasks(taskLists.get(0).getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute("tasks", tasks);
            }
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User)(session.getAttribute(Login.ATT_USER_SESSION));
        if(user != null){
            ArrayList taskLists = null;
            try {
                taskLists = (ArrayList) TaskListFacade.getTaskListFacade().getTasksList(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("taskLists", taskLists);
            String taskList_id = request.getParameter("taskList");
            if(taskList_id != null){
                ArrayList tasks = null;
                try {
                    tasks = (ArrayList) TaskFacade.getTaskFacade().getTasks(taskList_id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute("tasks", tasks);
            }
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}