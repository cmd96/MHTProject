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
    private int milestonID;
    private int productID;
    private String milestoneName;
    private int ResponsibleWriterId;
    private Date startDate;
    private Date endDate;
    private String description;
    private int status;

    public ProductMilestone(int milestonID, int productID, String milestoneName, int responsibleWriterId, Date startDate, Date endDate, String description, int status) {
        this.milestonID = milestonID;
        this.productID = productID;
        this.milestoneName = milestoneName;
        ResponsibleWriterId = responsibleWriterId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.status = status;
    }

    public int getMilestonID(){
        return this.milestonID;
    }

    public void setmilestonID(int milestonID){
        this.milestonID = milestonID;
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

        String sql = "INSERT INTO ProductMilestons" +
                "(MilestoneName ,ProjectID ,ProductID, ResponsibleWriterID, StartDate, EndDate, Description) " +
                "VALUES ('" + insert_mile.getMilestoneName() +
                //TODO:Get Project ID
                "','" + 14 +
                "','" + insert_mile.getProductID() +
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

// TODO : Get params from DATA BASE
    public int getMilestonIDDB(){
        return getMilestonID();
    }

    public int getProductIDDB() {
        int MileID = getMilestonID();
        String sql = "SELECT ProductID from ProductMilestons where MilestoneID ='" + MileID + "'";
        int ProdID = ProdID = ProjectProduct.ExecuteInt(sql, "ProductID", -1);
        return ProdID;
    }

    public String getMilestoneNameDB() {
        int MileID = getMilestonID();
        String sql = "SELECT MilestoneName from ProductMilestons where MilestoneID ='" + MileID + "'";
        String MileName = ProjectProduct.ExecuteString(sql, "MilestoneName", null);
        return MileName;
    }

    public int getResponsibleWriterIdDB(){
        int MileID = getMilestonID();
        String sql = "SELECT ResponsibleWriterID from ProductMilestons where MilestoneID ='" + MileID + "'";
        int ResID  = -1;
        ResID = ProjectProduct.ExecuteInt(sql, "ResponsibleWriterID", -1);
        return ResID;
    }

    public Date getStartDateDB() {
        int MileID = getMilestonID();
        String sql = "SELECT DateStart from ProductMilestons where MilestoneID ='" + MileID + "'";
        Date DateStart = ProjectProduct.ExecuteDate(sql, "DateStart");

        return DateStart;
    }

    public Date getEndDateDB() {
        int MileID = getMilestonID();
        String sql = "SELECT DateToEnd from ProductMilestons where MilestoneID ='" + MileID + "'";
        Date DateToEnd = ProjectProduct.ExecuteDate(sql, "DateToEnd");
        return DateToEnd;
    }

    public String getDescriptionDB() {
        int MileID = getMilestonID();
        String sql = "SELECT Description from ProductMilestons where MilestoneID ='" + MileID + "'";
        String Description = ProjectProduct.ExecuteString(sql, "Description", null);
        return Description;
    }

    public int getStatusDB() {
        //int mileID = this.get_mile_id()???
        int MileID = getMilestonID();
        String sql = "SELECT Status from ProductMilestons where MilestoneID ='" + MileID + "'";
        int Status = -1;
        Status = ProjectProduct.ExecuteInt(sql, "Status", -1);
        return Status;
    }

//TODO: Set values in db

    public void setProductIDDB(int NewProjID) {
        int MileID = getMilestonID();
        String sql = "update ProductMilestons set ProductID = '" + NewProjID + "'where MilestoneID ='" + MileID + "'";
        try {
            Connection con = SQLConnection.getCon();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
           }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void setMilestonNameDB(String NewMileName){
        int MileID = getMilestonID();
        String sql = "update ProductMilestons set MilestoneName = '" + NewMileName + "'where MilestoneID ='" + MileID + "'";
        ProjectProduct.ExecuteUpdate(sql);

    }

    public void setResponsibleWriterIdDB(int ResponsibleWriterID){
        int MileID = getMilestonID();
        String sql = "update ProductMilestons set ResponsibleWriterID = '" + ResponsibleWriterID + "'where MilestoneID ='" + MileID + "'";
        ProjectProduct.ExecuteUpdate(sql);
    }

    public void setStartDateDB(Date NewStartDate){
        int MileID = getMilestonID();
        String sql = "update ProductMilestons set DateStart = '" + NewStartDate + "'where MilestoneID ='" + MileID + "'";
        int count = 0 ;
        ExecuteUpdate(sql);
    }

    public void setEndDateDB(Date NewEndDate){
        int MileID = getMilestonID();
        String sql = "update ProductMilestons set DateToEnd = '" + NewEndDate + "'where MilestoneID ='" + MileID + "'";
        int count = 0 ;
        ExecuteUpdate(sql);
    }

    public void setDescriptionDB(String NewDescription){
        int MileID = getMilestonID();
        String sql = "update ProductMilestons set Description = '" + NewDescription + "'where MilestoneID ='" + MileID + "'";
        int count = 0 ;
        ExecuteUpdate(sql);
    }

    public void setStatusDB(int NewStatus){
        int MileID = getMilestonID();
        String sql = "update ProductMilestons set Status = '" + NewStatus + "'where MilestoneID ='" + MileID + "'";
        int count = 0 ;
        ExecuteUpdate(sql);
    }

    static void ExecuteUpdate(String sql) {
        int count;
        try {
            Connection con = SQLConnection.getCon();
            Statement stmt = con.createStatement();
            count = stmt.executeUpdate(sql);
            System.out.println("Number of rows updated by executing query1 =  " + count);
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//
//    static int ExecuteInt(String sql, String label) {
//        int result = -1;
//        result = ProjectProduct.ExecuteInt(sql, label, result);
//        return result;
//    }

//    static String ExecuteString(String sql, String label) {
//        String result = null;
//        result = ProjectProduct.ExecuteString(sql, label, result);
//        return result;
//    }

//    static Date ExecuteDate(String sql, String label ) {
//        Date result = null;
//        try {
//            Connection con = SQLConnection.getCon();
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            System.out.println(rs);
//            while (rs.next()){
//                result = rs.getDate(label);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }


}