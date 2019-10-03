package com.test;

import exception.ProjectExeption;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductMilestone {
    private int productID;
    private String milestoneName;
    private int ResponsibleWriterId;
    private Date startDate;
    private Date endDate;
    private String description;
    private int status;

    public ProductMilestone(int productID, String milestoneName, int responsibleWriterId, Date startDate, Date endDate, String description, int status) {
        this.productID = productID;
        this.milestoneName = milestoneName;
        ResponsibleWriterId = responsibleWriterId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.status = status;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public int getResponsibleWriterId() {
        return ResponsibleWriterId;
    }

    public void setResponsibleWriterId(int responsibleWriterId) {
        ResponsibleWriterId = responsibleWriterId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHtmlCode() {
        String htmlString = CONST_HTML_CODE.HTML_MILESTONE_DIV;
        String dateShort = DateFormat.getDateInstance(DateFormat.SHORT).format(getEndDate());
        htmlString = htmlString.replaceAll(CONST_HTML_CODE.PLACEHOLDER_MILESTONE_DATE_CODE, dateShort);
        htmlString = htmlString.replaceAll(CONST_HTML_CODE.PLACEHOLDER_MILESTONE_COMMENT_CODE, getMilestoneName());
        htmlString = htmlString.replaceAll(CONST_HTML_CODE.PLACEHOLDER_MILESTONE_STATUS_CODE, (status != MILESTONE_STATUS.DONE) ? CONST_HTML_CODE.PLACEHOLDER_MILESTONE_STATUS_IN_PROGRESS_CODE : CONST_HTML_CODE.PLACEHOLDER_MILESTONE_STATUS_DONE_CODE);
        htmlString = htmlString.replaceAll(CONST_HTML_CODE.PLACEHOLDER_MILESTONE_CLASS, (milestoneName.equals(MILESTONE_NAME.DELIVERY_DATE_STRING)) ? CONST_HTML_CODE.MILESTONE_END_CLASS : CONST_HTML_CODE.MILESTONE_CLASS);
        return htmlString;

    }

    //TODO: insert new milestone to current project
    public static void InsertNewMilestone(Connection con, ProductMilestone insert_mile) throws ProjectExeption {

        Date Date_Start = insert_mile.getStartDate();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
        String strDateStart = formatter.format(Date_Start);

//        System.out.println("jjjjjjjjjjjjjjjjjj "+ strDateStart);

        Date Date_End = insert_mile.getEndDate();
        String strDateEnd = formatter.format(Date_End);
//        System.out.println("kkkkkkkkkkkkkkk "+ strDateEnd);

        String sql = "INSERT INTO [dbo].[Milestons]" +
                "(Name  ,ProductID, ResponsibleWriter, DateStart, DateToEnd, Description) " +
                "VALUES ('" + insert_mile.getMilestoneName() + "','" + insert_mile.getProductID() +
                "','" + insert_mile.getResponsibleWriterId() + "','" + strDateStart +
                "','" + strDateEnd + "','" + insert_mile.getDescription() + "')";

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert_MileSton_list(Connection con, List<ProductMilestone> milestone_list, int id) throws ProjectExeption {

        for (int i = 0; i < milestone_list.size(); i++) {
            ProductMilestone insert_mile = milestone_list.get(i);
            insert_mile.setProductID(id);
            InsertNewMilestone(con, insert_mile);
        }
    }
}