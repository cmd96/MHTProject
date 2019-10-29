package com.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/projectListServlet")
public class ProjectListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Products.setCurrentProjectName(request.getParameter("inputProjectName"));
        Products.setCurrentProjectID(-1);
        response.sendRedirect("products.jsp");
        return;
    }
}
