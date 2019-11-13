package com.test;
import exception.ProjectExeption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/addBtnServlet")
public class AddButtons extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        if (request.getParameter("addProjectButton") != null)
        {

            String name = request.getParameter("projName");
            String customer = request.getParameter("customerName");
            try {
                int id = User.getUserID();
                AddProject a = new AddProject(name, id, customer);
                a.insertProject();
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("faild");
                e.printStackTrace();
            }
            User.refreshDB();
            response.sendRedirect("projects.jsp");
            try {
                User.getHistoryList().add(new HistoryAction(new Date(),User.getUsername() ,name,"---", "create a new project"));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //set project data
        if (request.getParameter("setProjectButton") != null) {

            String projectName = request.getParameter("projName");
            String customerName = request.getParameter("customerName");
            String projectIDString = request.getParameter("editProjectIDName");
            int projectID = Integer.parseInt(projectIDString);

            userProject.setProjectNameDB(projectName, projectID);
            userProject.setProjectCustomerDB(customerName, projectID);
            User.refreshDB();
            response.sendRedirect("projects.jsp");
            try {
                User.getHistoryList().add(new HistoryAction(new Date(),User.getUsername() ,projectName,"---", "set project Data"));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        if (request.getParameter("addProductButton") != null)
        {
            //TODO:get projectId by project name
            Connection con = null;
            try {
                con = SQLConnection.getCon();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String projectName = Products.getCurrentProjectName();
            int responsibleWriter = 1;
            int projectID = 0;
            try {
                projectID = Products.getCurrentProjectID();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //TODO:find id according name;
            int[] templateFlow = null;
            List<ProductMilestone> productMilsetones = new ArrayList<>();
            String productName = request.getParameter("productName");
            String selectFlow = request.getParameter("select");
            String productResponsibleWriterName = request.getParameter("responsibleWriterName");
            ProductMilestone tmpMilstone;

            String milestoneStartDate;
            String milestoneDueDate;
            String milestoneResponsibleWriterName;
            String milestoneDescriptionName;

            if (selectFlow.equals("Short Flow")) {
                //outline
                milestoneStartDate = request.getParameter("outlineMilestoneStartDate");
                milestoneDueDate = request.getParameter("outlineMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("outlineMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("outlineMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.OUTLINE_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                //draft
                milestoneStartDate = request.getParameter("draftMilestoneStartDate");
                milestoneDueDate = request.getParameter("draftMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("draftMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("draftMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.DRAFT_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                //CRHtmlCode
                milestoneStartDate = request.getParameter("CRMilestoneStartDate");
                milestoneDueDate = request.getParameter("CRMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("CRMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("CRMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.CR_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                templateFlow = TEMPLATE_FLOW.BASIC_FLOW;
            } else if (selectFlow.equals("Full Flow")) {
                //outline
                milestoneStartDate = request.getParameter("outlineMilestoneStartDate");
                milestoneDueDate = request.getParameter("outlineMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("outlineMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("outlineMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.OUTLINE_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                //draft1
                milestoneStartDate = request.getParameter("draft_1_MilestoneStartDate");
                milestoneDueDate = request.getParameter("draft_1_MilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("draft_1_MilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("draft_1_MilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.DRAFT_1_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                //draft2
                milestoneStartDate = request.getParameter("draft_2_MilestoneStartDate");
                milestoneDueDate = request.getParameter("draft_2_MilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("draft_2_MilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("draft_2_MilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.DRAFT_2_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                //CRHtmlCode
                milestoneStartDate = request.getParameter("CRMilestoneStartDate");
                milestoneDueDate = request.getParameter("CRMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("CRMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("CRMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.CR_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                templateFlow = TEMPLATE_FLOW.FULL_FLOW;
            } else if (selectFlow.equals("Course")) {
                //sylabus
                milestoneStartDate = request.getParameter("sylabusMilestoneStartDate");
                milestoneDueDate = request.getParameter("sylabusMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("sylabusMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("sylabusMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.SYLLABUS_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                //presentation
                milestoneStartDate = request.getParameter("presentationMilestoneStartDate");
                milestoneDueDate = request.getParameter("presentationMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("presentationMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("presentationMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.PRESENTATION_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                //test
                milestoneStartDate = request.getParameter("testMilestoneStartDate");
                milestoneDueDate = request.getParameter("testMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("testMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("testMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.TEST_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                //course
                milestoneStartDate = request.getParameter("courseMilestoneStartDate");
                milestoneDueDate = request.getParameter("courseMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("courseMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("courseMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.COURSE_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                //fixPresentation
                milestoneStartDate = request.getParameter("fixPresentationMilestoneStartDate");
                milestoneDueDate = request.getParameter("fixPresentationMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("fixPresentationMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("fixPresentationMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.PRESENTATION_CHECKING_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY, milestoneResponsibleWriterName);
                productMilsetones.add(tmpMilstone);

                templateFlow = TEMPLATE_FLOW.COURSE_FLOW;
            }

            ProjectProduct newProduct = new ProjectProduct(projectID, productName, -1, getIdbyName(productResponsibleWriterName), productMilsetones, templateFlow, productResponsibleWriterName);
            //TODO:call shira function
            try {
                ProjectProduct.InsertNewProduct(newProduct);
            } catch (ProjectExeption projectExeption) {
                projectExeption.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                User.getHistoryList().add(new HistoryAction(new Date(),User.getUsername() ,projectName,productName, "create a new product"));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            User.refreshDB();
            response.sendRedirect("products.jsp");
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        if (request.getParameter("addMilestonButton") != null)
        {
            String name = request.getParameter("mailstonName");
            String description = request.getParameter("description");

            int responsibleWriter = 1;
            int projectID = 111;
            AddMileston a = new AddMileston(name, projectID, responsibleWriter);
            try {
                a.insertMileston();
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("faild");
                e.printStackTrace();
            }
            response.sendRedirect("products.jsp");
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        if (request.getParameter("setProductButton") != null)
        {
            Connection con = null;
            try {
                con = SQLConnection.getCon();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            List<ProjectProduct> productList = null;
            ProjectProduct myCurrentProduct = null;
            String stringProductID =request.getParameter("saveIDProductName");
            stringProductID = stringProductID.replace("editBtnID", "");
            int productID = Integer.parseInt(stringProductID);
            try {
                productList = User.get_Products(con,Products.getCurrentProjectID());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //find current product
            for(ProjectProduct product: productList) {
                if(product.getProductID() == productID)
                {
                    myCurrentProduct = product;
                    break;
                }
            }
            String productName = request.getParameter("productName");
            myCurrentProduct.setProductNameDB(productName);
            String selectFlow = myCurrentProduct.getTemplate_flow_String();
            String productResponsibleWriterName = request.getParameter("responsibleWriterName");
            myCurrentProduct.setResponsibleWriterIDDB(getIdbyName(productResponsibleWriterName));
            String milestoneStartDate;
            String milestoneDueDate;
            String milestoneResponsibleWriterName;
            String milestoneDescriptionName;
            int milestoneID;
            if (selectFlow.equals("Short Flow")) {

                //outline
                myCurrentProduct.getProductMilestone().get(0).setResponsibleWriterIdDB(getIdbyName(request.getParameter("outlineMilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(0).setStartDateDB(request.getParameter("outlineMilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(0).setEndDateDB(request.getParameter("outlineMilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(0).setDescriptionDB(request.getParameter("outlineMilestoneDescriptionName"));

                //draft
                myCurrentProduct.getProductMilestone().get(1).setResponsibleWriterIdDB(getIdbyName(request.getParameter("draftMilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(1).setStartDateDB(request.getParameter("draftMilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(1).setEndDateDB(request.getParameter("draftMilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(1).setDescriptionDB(request.getParameter("draftMilestoneDescriptionName"));

                //CR
                myCurrentProduct.getProductMilestone().get(2).setResponsibleWriterIdDB(getIdbyName(request.getParameter("CRMilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(2).setStartDateDB(request.getParameter("CRMilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(2).setEndDateDB(request.getParameter("CRMilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(2).setDescriptionDB(request.getParameter("CRMilestoneDescriptionName"));

            } else if (selectFlow.equals("Full Flow")) {

                //outline
                myCurrentProduct.getProductMilestone().get(0).setResponsibleWriterIdDB(getIdbyName(request.getParameter("outlineMilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(0).setStartDateDB(request.getParameter("outlineMilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(0).setEndDateDB(request.getParameter("outlineMilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(0).setDescriptionDB(request.getParameter("outlineMilestoneDescriptionName"));

                //draft
                myCurrentProduct.getProductMilestone().get(1).setResponsibleWriterIdDB(getIdbyName(request.getParameter("draft_1_MilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(1).setStartDateDB(request.getParameter("draft_1_MilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(1).setEndDateDB(request.getParameter("draft_1_MilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(1).setDescriptionDB(request.getParameter("draft_1_MilestoneDescriptionName"));

                //draft
                myCurrentProduct.getProductMilestone().get(2).setResponsibleWriterIdDB(getIdbyName(request.getParameter("draft_2_MilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(2).setStartDateDB(request.getParameter("draft_2_MilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(2).setEndDateDB(request.getParameter("draft_2_MilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(2).setDescriptionDB(request.getParameter("draft_2_MilestoneDescriptionName"));

                //CR
                myCurrentProduct.getProductMilestone().get(3).setResponsibleWriterIdDB(getIdbyName(request.getParameter("CRMilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(3).setStartDateDB(request.getParameter("CRMilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(3).setEndDateDB(request.getParameter("CRMilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(3).setDescriptionDB(request.getParameter("CRMilestoneDescriptionName"));

            } else if (selectFlow.equals("Course")) {

                //sylabus
                myCurrentProduct.getProductMilestone().get(0).setResponsibleWriterIdDB(getIdbyName(request.getParameter("sylabusMilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(0).setStartDateDB(request.getParameter("sylabusMilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(0).setEndDateDB(request.getParameter("sylabusMilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(0).setDescriptionDB(request.getParameter("sylabusMilestoneDescriptionName"));

                //presentation
                myCurrentProduct.getProductMilestone().get(1).setResponsibleWriterIdDB(getIdbyName(request.getParameter("presentationMilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(1).setStartDateDB(request.getParameter("presentationMilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(1).setEndDateDB(request.getParameter("presentationMilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(1).setDescriptionDB(request.getParameter("presentationMilestoneDescriptionName"));

                //test

                myCurrentProduct.getProductMilestone().get(2).setResponsibleWriterIdDB(getIdbyName(request.getParameter("testMilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(2).setStartDateDB(request.getParameter("testMilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(2).setEndDateDB(request.getParameter("testMilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(2).setDescriptionDB(request.getParameter("testMilestoneDescriptionName"));

                //course
                myCurrentProduct.getProductMilestone().get(3).setResponsibleWriterIdDB(getIdbyName(request.getParameter("courseMilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(3).setStartDateDB(request.getParameter("courseMilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(3).setEndDateDB(request.getParameter("courseMilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(3).setDescriptionDB(request.getParameter("courseMilestoneDescriptionName"));

                //fixPresentation
                myCurrentProduct.getProductMilestone().get(4).setResponsibleWriterIdDB(getIdbyName(request.getParameter("fixPresentationMilestoneResponsibleWriterName")));
                myCurrentProduct.getProductMilestone().get(4).setStartDateDB(request.getParameter("fixPresentationMilestoneStartDate"));
                myCurrentProduct.getProductMilestone().get(4).setEndDateDB(request.getParameter("fixPresentationMilestoneDueDate"));
                myCurrentProduct.getProductMilestone().get(4).setDescriptionDB(request.getParameter("fixPresentationMilestoneDescriptionName"));

            }
            try {
                User.getHistoryList().add(new HistoryAction(new Date(),User.getUsername() ,Products.getCurrentProjectName() ,productName, "edit product data"));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            User.refreshDB();
            response.sendRedirect("products.jsp");
        }

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        if (request.getParameter("addMilestonButton") != null) {
            String name = request.getParameter("mailstonName");
            String description = request.getParameter("description");

            int responsibleWriter = 1;
            int projectID = 111;
            AddMileston a = new AddMileston(name, projectID, responsibleWriter);
            try {
                a.insertMileston();
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("faild");
                e.printStackTrace();
            }
            response.sendRedirect("products.jsp");
        }
    }

    public static Date stringToDate(String outlineMilestoneStartDate) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = null;
        try {
            date = simpleDateFormat.parse(outlineMilestoneStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    //get userID by name
    public static int getIdbyName(String userName) {
        String sql = "SELECT ID from Users where UserName like '"+userName+"'";
        int id = -1 ;
        try {
            Connection con = SQLConnection.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                id = rs.getInt("ID");
                System.out.println(id);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }
}
