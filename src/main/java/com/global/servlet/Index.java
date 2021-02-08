package com.global.servlet;

import com.global.core.bean.User;
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
            ArrayList taskLists = null;
            try {
                taskLists = (ArrayList) TaskListFacade.getTaskListFacade().getTasksList(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("taskLists", taskLists);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}