package com.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addBtnServlet")
public class AddButtons extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("addProjectButton") != null){

            String name=request.getParameter("projName");
            String customer=request.getParameter("customerName");
            try {
                int id = User.getUserID();
                AddProject a=new AddProject(name,id,customer);
                a.insertProject();
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("faild");
                e.printStackTrace();
            }
            User.refreshDB();
            response.sendRedirect("projects.jsp");

        }
        if (request.getParameter("addProductButton") != null){

            String productName = request.getParameter("productName");
            System.out.println("product name is : "+productName+"!!!!!!!!!!!!!!!!!!!!!!!!");

            String responsibleWriterName = request.getParameter("responsibleWriterName");
            System.out.println("product name is : "+responsibleWriterName+"!!!!!!!!!!!!!!!!!!!!!!!!");

            String selectFlow = request.getParameter("select");

            System.out.println("product name is : "+productName+" and Selected is : "+selectFlow);
            int responsibleWriter=1;
            int projectID=1;
//            AddProduct a=new AddProduct(name,projectID,responsibleWriter);
//            try {
//                a.insertProduct();
//            } catch (SQLException | ClassNotFoundException e) {
//                System.out.println("faild");
//                e.printStackTrace();
//            }
            response.sendRedirect("products.jsp");
        }
        if (request.getParameter("addMilestonButton") != null){
            String name=request.getParameter("mailstonName");
            String description=request.getParameter("description");

            int responsibleWriter=1;
            int projectID=111;
            AddMileston a=new AddMileston(name,projectID,responsibleWriter);
            try {
                a.insertMileston();
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("faild");
                e.printStackTrace();
            }
            response.sendRedirect("products.jsp");
        }


    }
}
