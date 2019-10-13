package com.test;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        if (request.getParameter("addProductButton") != null){

            //TODO:get projectId by project name
            int responsibleWriter = 1;
            int projectID = 0;
            int [] templateFlow = null;
            List<ProductMilestone> productMilsetones =  new ArrayList<>();
            String productName = request.getParameter("productName");
            System.out.println("product name is : "+productName+"!!!!!!!!!!!!!!!!!!!!!!!!");

            String responsibleWriterName = request.getParameter("responsibleWriterName");
            System.out.println("product name is : "+responsibleWriterName+"!!!!!!!!!!!!!!!!!!!!!!!!");

            String selectFlow = request.getParameter("select");
            ProductMilestone tmpMilstone;
            if(selectFlow.equals("Short Folw"))
            {
                String outlineMilestoneStartDate = request.getParameter("outlineMilestone");
                System.out.println(outlineMilestoneStartDate);
                Date startDate = stringToDate(outlineMilestoneStartDate);
                //TODO: for end date
                Date endDate = stringToDate(outlineMilestoneStartDate);
//                String description = request.getParameter("outlineMilestone");
                String description = "description";
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.OUTLINE_STRING, responsibleWriter, startDate, endDate, description, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                String draftMilestone = request.getParameter("draftMilestone");
                System.out.println(draftMilestone);
                tmpMilstone = new ProductMilestone(-1,MILESTONE_NAME.DRAFT_STRING, responsibleWriter, new Date(), new Date(), description, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                String CRMilestone = request.getParameter("CRMilestone");
                System.out.println(CRMilestone);
                tmpMilstone = new ProductMilestone(-1,MILESTONE_NAME.CR_STRING, responsibleWriter ,new Date(), new Date(), description, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                templateFlow = TEMPLATE_FLOW.BASIC_FLOW;
            }
            else if(selectFlow.equals("Full Flow"))
            {

                String outlineMilestone = request.getParameter("outlineMilestone");
                String draft_1_Milestone = request.getParameter("draft_1_Milestone");
                String draft_2_Milestone = request.getParameter("draft_2_Milestone");
                String CRMilestone = request.getParameter("CRMilestone");
                templateFlow = TEMPLATE_FLOW.FULL_FLOW;
            }
                else if(selectFlow.equals("Course"))
                {
                    String sylabusName = request.getParameter("sylabusName");
                    String presentationName = request.getParameter("presentationName");
                    String testName = request.getParameter("testName");
                    String courseName = request.getParameter("courseName");
                    String fixPresentationName = request.getParameter("fixPresentationName");
                    templateFlow = TEMPLATE_FLOW.COURSE_FLOW;
                }
            System.out.println("product name is : "+productName+" and Selected is : "+selectFlow);

            ProjectProduct newProduct = new ProjectProduct(projectID, productName , -1, productMilsetones, templateFlow);
            //TODO:call shira function
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

    private Date stringToDate(String outlineMilestoneStartDate) {
        return null;
    }
}
