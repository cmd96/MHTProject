package com.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    static private String username;
    static private String password;
    static private String firstName;
    static private String lastName;
    static private List<userProject> userProjectList;

    public User(){

    }

    public User(String un,String pw)
    {
        username=un;
        password=pw;
        //TODO:get all project and initialize them - add to list
    }
    public void exampleDataSetUp()
    {
        ProductMilestone milstoneDraft = new ProductMilestone(1, MILESTONE_NAME.DRAFT_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        ProductMilestone milstoneOutline = new ProductMilestone(1, MILESTONE_NAME.OUTLINE_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        ProductMilestone milstoneCR = new ProductMilestone(1, MILESTONE_NAME.CR_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        ProductMilestone milstoneDeliveryDate = new ProductMilestone(1, MILESTONE_NAME.DELIVERY_DATE_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        List<ProductMilestone> MilestoneList = new ArrayList<>();

        MilestoneList.add(milstoneOutline);
        MilestoneList.add(milstoneDraft);
        MilestoneList.add(milstoneCR);
        MilestoneList.add(milstoneDeliveryDate);

        ProjectProduct product = new ProjectProduct(11,"wing",111, MilestoneList, TEMPLATE_FLOW.BASIC_FLOW);
        List<ProjectProduct> productList = new ArrayList<>();
        productList.add(product);
        userProject project = new userProject("wingToFly","Chemdi",12,11,productList);
        List<userProject> projectList = new ArrayList<>();
        this.userProjectList = projectList;
    }
    //fill project
       public List get_Project(Connection con, int user_id) throws ProjectExeption {
//        qwery that return the list of project
        List<Create_Project> create_projects= new ArrayList<>();
        String sql= "Select * from Projects WHERE ProjectManager = "+ user_id;
        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
        {
            create_projects.add(new Create_Project(
                    rs.getInt("ID"),
                    rs.getString("name"),
                    rs.getInt("ProjectManager"),
                    rs.getString("Costumer"),
                    get_Products(con, rs.getInt("ID"))));
        }
            } catch (SQLException e) {
            throw new ProjectExeption("Get the MileSton  faild!!", e);
        }


        return (List) create_projects;
    }

    //}
    //fill product data
    public java.awt.List get_Products(Connection con, int project_num) throws ProjectExeption {
        List<ProjectProduct> productList = new ArrayList<>();
        List<Product> p = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE ID="+ project_num;
        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
//                productList.add(new ProjectProduct(rs.getInt("projectID"),
//                                rs.getString("productName"),
//                                rs.getInt("productID"),
//                        (java.awt.List)get_MileStons(con,rs.getInt("projectID"),rs.getInt("ID")),
//                                rs.getInt("template_flow")));

//using in my class  ->     Product BUT---
// I think that need to use with ProjectProduct

                p.add(new Product(rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getInt("projectID"),
                        get_MileStons(con, rs.getInt("projectID"), rs.getInt("ID"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (java.awt.List) productList;


    }
    //fill milestone
    public static java.awt.List get_MileStons(Connection con, int project_num,  int product_num) throws ProjectExeption {
        java.lang.String sql = "Select * from MileSton WHERE projectID = " + project_num +
                "AND poductID " + "= " + product_num;

        List<ProductMilestone> mileStonList = new ArrayList<>();
        List<MileSton> mile = new ArrayList<>();
        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
//                mileStonList.add(new ProductMilestone
//                        (rs.getInt("productID"),
//                                rs.getString("milestoneName"),
//                                rs.getInt("ResponsibleWriterId"),
//                                rs.getInt("ResponsibleWriter"),
//                                rs.getDate("startDate"),
//                                rs.getDate("endDate"),
//                                rs.getString("description"),
//                                rs.getInt("status")));
//            }
//                {
                mile.add(new MileSton(rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getInt("poductID"),
                        rs.getInt("projectID"),
                        rs.getInt("ResponsibleWriter"),
                        rs.getDate("DateStart"),
                        rs.getDate("DateToEnd"),
                        rs.getString("Description")));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return (java.awt.List) mile;
}

    public static String getUserName() throws SQLException, ClassNotFoundException {
        String fullName="";
        Connection con=SQLConnection.getCon();
        Statement stmt = con.createStatement();

        String SQL = "SELECT * FROM Users WHERE UserName like '"+username+"' and Password like '"+password+"'";
        ResultSet rs= stmt.executeQuery(SQL);
        while (rs.next()) {
            fullName=rs.getString("LastName").toString()+" "+rs.getString("FirstName").toString();
        }
        return fullName;
    }

    public static int getUserID() throws SQLException, ClassNotFoundException {
        int id = 0;
        Connection con=SQLConnection.getCon();
        Statement stmt = con.createStatement();

        String SQL = "SELECT * FROM Users WHERE UserName like '"+username+"' and Password like '"+password+"'";
        ResultSet rs= stmt.executeQuery(SQL);
        while (rs.next()) {
            id=rs.getInt("ID");
        }
        System.out.println(" /////  "+id);
        return id;
    }
    public boolean isExist() throws SQLException, ClassNotFoundException {

        boolean returnValue=false;

        Connection con=SQLConnection.getCon();
        Statement stmt = con.createStatement();

            String SQL = "SELECT * FROM Users";
            ResultSet rs= stmt.executeQuery(SQL);

            while (rs.next()) {
                if(rs.getString("UserName").equals(username) && rs.getString("Password").equals(password)){
                    returnValue=true;
                    break;
                }
            }

        return returnValue;
    }
}
