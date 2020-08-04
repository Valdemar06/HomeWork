package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        print(resp, "This method (Get)");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        print(resp, "This method (Post)");
    }

    private static  void print(HttpServletResponse response, String name) throws IOException {
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<h1>"+ name +"</h1>");
        writer.println("</html>");
    }
}
