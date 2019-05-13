package com.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String un=request.getParameter("username");
        String pw=request.getParameter("password");

        User user=new User();
//        boolean isUserExist=user.isExist(un,pw);
//        if(isUserExist){
//            System.out.println("hello");
//            response.sendRedirect("hello.jsp");
//        }
//
//        else {
//            System.out.println("faild");
//            response.sendRedirect("loginFaild.jsp");
//        }

        return;
    }
}