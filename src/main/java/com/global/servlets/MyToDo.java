package com.global.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MyToDo extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String [] lists = {"Liste 1", "SE", "BDNG", "AyoubTaGM"};
        request.setAttribute("lists", lists);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/mytodo.jsp").forward(request, response);
    }

    public void destroy() {
    }
}