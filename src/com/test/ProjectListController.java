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
        System.out.println("***************************");
//        String pn=request.getParameter("BLABLA");
//        request.getParameter("onay");
//            System.out.println(pn);
//        System.out.println(request.getParameter("inputProjectName").toString());
        return;
    }
}
