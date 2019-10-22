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
            String selectFlow = request.getParameter("select");
            ProductMilestone tmpMilstone;

            String milestoneStartDate;
            String milestoneDueDate;
            String milestoneResponsibleWriterName;
            String milestoneDescriptionName;

            if(selectFlow.equals("Short Flow"))
            {
                //outline
                milestoneStartDate = request.getParameter("outlineMilestoneStartDate");
                milestoneDueDate = request.getParameter("outlineMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("outlineMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("outlineMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.OUTLINE_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                //draft
                milestoneStartDate = request.getParameter("draftMilestoneStartDate");
                milestoneDueDate = request.getParameter("draftMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("draftMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("draftMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.DRAFT_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                //CRHtmlCode
                milestoneStartDate = request.getParameter("CRMilestoneStartDate");
                milestoneDueDate = request.getParameter("CRMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("CRMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("CRMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.CR_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                templateFlow = TEMPLATE_FLOW.BASIC_FLOW;
            }
            else if(selectFlow.equals("Full Flow"))
            {
                //outline
                milestoneStartDate = request.getParameter("outlineMilestoneStartDate");
                milestoneDueDate = request.getParameter("outlineMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("outlineMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("outlineMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.OUTLINE_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                //draft1
                milestoneStartDate = request.getParameter("draft_1_MilestoneStartDate");
                milestoneDueDate = request.getParameter("draft_1_MilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("draft_1_MilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("draft_1_MilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.DRAFT_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                //draft1
                milestoneStartDate = request.getParameter("draft_2_MilestoneStartDate");
                milestoneDueDate = request.getParameter("draft_2_MilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("draft_2_MilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("draft_2_MilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.DRAFT_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                //CRHtmlCode
                milestoneStartDate = request.getParameter("CRMilestoneStartDate");
                milestoneDueDate = request.getParameter("CRMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("CRMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("CRMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.CR_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                templateFlow = TEMPLATE_FLOW.FULL_FLOW;
            }
            else if(selectFlow.equals("Course"))
            {
                //sylabus
                milestoneStartDate = request.getParameter("sylabusMilestoneStartDate");
                milestoneDueDate = request.getParameter("sylabusMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("sylabusMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("sylabusMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.CR_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                //presentation
                milestoneStartDate = request.getParameter("presentationMilestoneStartDate");
                milestoneDueDate = request.getParameter("presentationMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("presentationMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("presentationMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.CR_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                //test
                milestoneStartDate = request.getParameter("testMilestoneStartDate");
                milestoneDueDate = request.getParameter("testMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("testMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("testMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.CR_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                //course
                milestoneStartDate = request.getParameter("courseMilestoneStartDate");
                milestoneDueDate = request.getParameter("courseMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("courseMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("courseMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.CR_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                //fixPresentation
                milestoneStartDate = request.getParameter("fixPresentationMilestoneStartDate");
                milestoneDueDate = request.getParameter("fixPresentationMilestoneDueDate");
                milestoneResponsibleWriterName = request.getParameter("fixPresentationMilestoneResponsibleWriterName");
                milestoneDescriptionName = request.getParameter("fixPresentationMilestoneDescriptionName");
                tmpMilstone = new ProductMilestone(-1, MILESTONE_NAME.CR_STRING, getIdbyName(milestoneResponsibleWriterName), stringToDate(milestoneStartDate), stringToDate(milestoneDueDate), milestoneDescriptionName, MILESTONE_STATUS.READY );
                productMilsetones.add(tmpMilstone);

                templateFlow = TEMPLATE_FLOW.COURSE_FLOW;
            }

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

    private Date stringToDate(String outlineMilestoneStartDate)
    {
        return null;
    }

    private int  getIdbyName(String name)
    {
        return 0;
    }
}
