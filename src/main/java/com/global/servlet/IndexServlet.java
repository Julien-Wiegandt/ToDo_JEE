package com.global.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class IndexServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}