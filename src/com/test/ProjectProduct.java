package com.test;

import exception.ProjectExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class ProjectProduct {

    private int projectID;
    private String productName;
    private int productID;
    private int ResponsibleWriterId;
    private List<ProductMilestone> productMilestone;
    private int[] template_flow;


    public ProjectProduct(int projectID, String productName, int productID, int responsibleWriterId, List<ProductMilestone> productMilestone, int[] template_flow) {
        this.projectID = projectID;
        this.productName = productName;
        this.productID = productID;
        ResponsibleWriterId = responsibleWriterId;
        this.productMilestone = productMilestone;
        this.template_flow = template_flow;
    }

    public int getResponsibleWriterId() {
        return ResponsibleWriterId;
    }

    public void setResponsibleWriterId(int responsibleWriterId) {
        ResponsibleWriterId = responsibleWriterId;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product_Name) {
        productName = product_Name;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public List<ProductMilestone> getProductMilestone() {
        return productMilestone;
    }

    public void setProductMilestone(List<ProductMilestone> productMilestone) {
        this.productMilestone = productMilestone;
    }

    public int[] getTemplate_flow() {
        return template_flow;
    }

    public void setTemplate_flow(int[] template_flow) {
        this.template_flow = template_flow;
    }

    public String getHtmlCode() {
        String htmlCode = CONST_HTML_CODE.HTML_PRODUCT_UP_WRAPPER_START;
        htmlCode += CONST_HTML_CODE.HTML_PRODUCT_WRAPPER_START + CONST_HTML_CODE.HTML_PRODUCT_CODE;
        for (ProductMilestone milesotne : productMilestone) {

            htmlCode += milesotne.getHtmlCode();
        }
        htmlCode += CONST_HTML_CODE.HTML_PRODUCT_WRAPPER_END;
        htmlCode += CONST_HTML_CODE.HTML_PRODUCT_BTN;
        htmlCode += CONST_HTML_CODE.HTML_PRODUCT_UP_WRAPPER_END;
        htmlCode = htmlCode.replaceAll(CONST_HTML_CODE.PLACEHOLDER_PRODUCT_NAME, getProductName());
        return htmlCode;
    }

    //TODO: insert new product to current project
    public static void InsertNewProduct(ProjectProduct insert) throws ProjectExeption, SQLException, ClassNotFoundException {
        Connection con = SQLConnection.getCon();
        String Name = insert.getProductName();
        int ProjID = insert.getProjectID();
        int rw = insert.getResponsibleWriterId();
        List<ProductMilestone> productMilestone = insert.getProductMilestone();

        int[] template_flow = insert.getTemplate_flow();
        insert_product_db(con, Name, 14, rw);
        if (productMilestone != null) {
            int product_id = ( int ) get_product_id(con, Name, ProjID);
            ProductMilestone.insert_MileSton_list(con, productMilestone, product_id);
//            System.out.println("the new product id is :" + product_id);
        }
    }

    public static void insert_product_db(Connection con, String Name, int ProjID, int rw) {
        String sql = "INSERT INTO ProjectProduct (ProductName ,ProjectID, ResponsibleWriterID) VALUES ( '" + Name + "','" + ProjID + "','" + rw + "')";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int get_product_id(Connection con, String Name, int ProjID) {
        String sql = "Select ProductID from ProjectProduct where ProductName like '" + Name + "' and ProjectID like '" + ProjID + "'";
        int id = -1;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("ProductID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;


    }

    public int getProductIDDB(){
        return this.productID;
    }

    public  String getProductNameDB(){
        int productID = getProductID();
        String sql = "SELECT ProductName from ProjectProduct where ProductID ='" + productID + "'";
        String reault = ExecuteString(sql ,"ProductName", null);
        return reault;
    }

    public int getProjectIDDB(){
        int productID = getProductID();
        String sql = "SELECT ProjectID from ProjectProduct where ProductID ='" + productID + "'";
        int ProjID = ExecuteInt(sql, "ProjectID", -1);
        return ProjID;
    }

    public int getResponsibleWriterIDDB(){
        int ProductID = getProductID();
        String sql = "SELECT ResponsibleWriterID from ProjectProduct where ProductID ='" + productID + "'";
        int result = ExecuteInt(sql, "ResponsibleWriterID", -1);
        return result;
    }

    public int getFlowtypDB(){
        int ProductID = getProductID();
        String sql = "SELECT FlowType from ProjectProduct where ProductID ='" + productID + "'";
        int result = ExecuteInt(sql, "FlowType", -1);
        return result;
    }

    public void setProductNameDB( String NewName) {
        int ProductID = this.getProductID();
        String sql = "update ProjectProduct set ProductName = '" + NewName + "' where ProductID ='" + ProductID + "'";
        ExecuteUpdate(sql);

    }

    public void setProjectIDDB(int NewProjID) {
        int ProductID = this.getProductID();
        String sql = "update ProjectProduct set ProjectID = '" + NewProjID + "'where ProductID ='" + ProductID + "'";
        ExecuteUpdate(sql);
    }

    public void setResponsibleWriterIDDB(int NewResponsibleID) {
        int ProductID = this.getProductID();
        String sql = "update ProjectProduct set ResponsibleWriterID = '" + NewResponsibleID + "'where ProductID ='" + ProductID + "'";
        ExecuteUpdate(sql);
    }

    public void setFlowTypeDB(int NewFlowType) {
        int ProductID = this.getProductID();
        String sql = "update ProjectProduct set FlowType = '" + NewFlowType + "' where ProductID ='" + ProductID + "'";
        ExecuteUpdate(sql);
    }

    static void ExecuteUpdate(String sql) {
        try {
            Connection con = SQLConnection.getCon();
            Statement stmt = con.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println("Number of rows updated by executing query1 =  " + count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    static int ExecuteInt__(String sql, String label) {
//        int result = -1;
//        result = ExecuteInt(sql, label, result);
//        return result;
//    }

    static int ExecuteInt(String sql, String label, int result) {
        try {
            Connection con = SQLConnection.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            while (rs.next()){
                result = rs.getInt(label);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    static String ExecuteString(String sql, String label, String result) {
        try {
            Connection con = SQLConnection.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            while (rs.next()){
                result = rs.getString(label);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    static Date ExecuteDate(String sql, String label ) {
        Date result = null;
        try {
            Connection con = SQLConnection.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            while (rs.next()){
                result = rs.getDate(label);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}