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

public class AddTask extends HttpServlet {
    public static final String ATT_FORM        = "AddTaskForm";
    public static final String URL_REDIRECTION = "/index";
    public static final String VIEW            = "/index";

    private ArrayList<Task> tasks;
    private ArrayList<TaskList> taskLists;


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AddTaskForm form = new AddTaskForm();
        String tasklist_id = form.createTask(request);

        HttpSession session = request.getSession();
        User user = (User)(session.getAttribute(Login.ATT_USER_SESSION));
        if(user != null) {
            /*
            try {
                taskLists = (ArrayList) TaskListFacade.getTaskListFacade().getTasksList(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute(Index.TASKLIST, taskLists);
            */
            //if (taskLists.get(0) != null) {
                try {
                    tasks = (ArrayList) TaskFacade.getTaskFacade().getTasks(user.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute(Index.TASKS, tasks);
            //}
        }

        if (form.getErrors().isEmpty()) {
            request.setAttribute(Index.CURRENT_TASKLIST_ID, tasklist_id);
        } else {
            request.setAttribute(ATT_FORM, form);
        }
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }
}
