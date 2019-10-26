package com.test;

import exception.ProjectExeption;

import java.sql.*;
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

    public static void setProductNameDB(Connection con, String NewName) {
        String sql = "update ProjectProduct set ProductName = '" + NewName + "'";
        try {
            Statement stmt = con.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println("Number of rows updated by executing query1 =  " + count);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void setProjectIDDB(Connection con, int NewProjID) {
        String sql = "update ProjectProduct set ProjectID = '" + NewProjID + "'";
        try {
            Statement stmt = con.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println("Number of rows updated by executing query1 =  " + count);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setResponsibleWriterIDDB(Connection con, int NewResponsibleID) {
        String sql = "update ProjectProduct set ResponsibleWriterID = '" + NewResponsibleID + "'";
        try {
            Statement stmt = con.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println("Number of rows updated by executing query1 =  " + count);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void setFlowTypeDB(Connection con, int NewFlowType) {
        String sql = "update ProjectProduct set FlowType = '" + NewFlowType + "'";
        try {
            Statement stmt = con.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println("Number of rows updated by executing query1 =  " + count);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}