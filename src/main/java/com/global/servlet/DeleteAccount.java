package com.global.servlet;

import com.global.core.bean.User;
import com.global.core.facade.TaskListFacade;
import com.global.core.facade.UserFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteAccount extends HttpServlet {
    public static final String URL_REDIRECTION = "/";
    public static final String VIEW = "/";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Login.ATT_USER_SESSION);
        try {
            UserFacade.getUserFacade().deleteUser(user.getId());
            session.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(URL_REDIRECTION);
    }
}
