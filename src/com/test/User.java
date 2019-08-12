package com.test;

import Project.exception.ProjectExeption;

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

//    User u = new User("Shirad","123","Shira","David",userproject1);

    public User(){

    }

    public User(String un,String pw)
    {
        username=un;
        password=pw;
        //TODO:get all project and initialize them - add to list
    }
    public void exampleDataSetUp() throws SQLException, ProjectExeption {
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Project;integratedSecurity=true;";
        Connection con = DriverManager.getConnection(url);

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
        List<ProductMilestone> gm= get_MileStons(con , 1);
        System.out.println(gm);

    }
    //fill project

    //fill project
    //{
    //  for list projectList from SQLserver
    public static List<userProject> get_Project(Connection con, int user_id) throws ProjectExeption {
//        qwery that return the list of project
        List<userProject> projectsList= new ArrayList<>();
        String sql= "Select * from userProject WHERE projectManagerID = "+ user_id;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                projectsList.add(new userProject(
                        rs.getString("projectMame"),
                        rs.getString("projectCustomer"),
                        rs.getInt("projectManagerID"),
                        rs.getInt("projectID"),
                        (List<ProjectProduct>)get_Products(con, rs.getInt("projectID"))));
                        System.out.println(rs.getString("projectMame"));
            }
        } catch (SQLException e) {
            throw new ProjectExeption("Get the MileSton  faild!!", e);
        }
        return (List<userProject>) projectsList;
    }
//    }

//    fill product data
    public static List<ProjectProduct> get_Products(Connection con, int project_num) throws ProjectExeption {
        List<ProjectProduct> productList = new ArrayList<>();
        String sql = "SELECT * FROM ProjectProduct WHERE projectID="+ project_num;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                      productList.add(new ProjectProduct(
   							    rs.getInt("projectID"),
                                rs.getString("productName"),
                                rs.getInt("productID"),
                                (List<ProductMilestone>)get_MileStons(con,rs.getInt("productID")),
                                  null));

                System.out.println(rs.getInt("projectID")+" "+
                        rs.getString("productName")+" "+
                        rs.getInt("productID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (List<ProjectProduct>) productList;
    }

    //fill milestone
    public static List<ProductMilestone> get_MileStons(Connection con, int product_num) throws ProjectExeption {
        List <ProductMilestone> mileStonList = new ArrayList<>();
        String sql = "SELECT * FROM ProductMilestone WHERE productID="+ product_num;

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                mileStonList.add(new ProductMilestone
	                            (rs.getInt("productID"),
                                rs.getString("milestoneName"),
                                rs.getInt("ResponsibleWriterId"),
                                rs.getDate("startDate"),
                                rs.getDate("endDate"),
                                rs.getString("description"),
                                rs.getInt("status")));

                System.out.println(rs.getInt("productID" )+" "+
                                        rs.getString("milestoneName")+" "+
                        rs.getInt("ResponsibleWriterId")+" "+
                        rs.getDate("startDate")+ " "+
                        rs.getDate("endDate")+ " "+
                        rs.getString("description")+" "+
                        rs.getInt("status"));
//                //                print(3,null,null,mileStonList);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return (List<ProductMilestone>) mileStonList;
}
//
//public  void  print(int num, userProject up,  ProjectProduct PP,ProductMilestone PM)
//{
//    if (num ==1){
//
//    }
//    if (num==2) {
//
//    }
//    if (num ==3){
//        System.out.println(
//                PM.getProductID()+" "+
//                PM.getMilestoneName()+" "+
//                PM.getProductID()+" "+
//                PM.getStartDate()+" "+
//                PM.getEndDate()+" "+
//                PM.getDescription()+" "+
//                PM.getStatus());
//    }
//}
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
