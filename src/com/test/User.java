package com.test;

import exception.ProjectExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    static private String username;
    static private String password;
    static private String firstName;
    static private String lastName;
    static private List<userProject> userProjectList;

    public User()
    {

    }

    public User(String un,String pw)
    {
        username=un;
        password=pw;
        //TODO:get all project and initialize them - add to list
        exampleDataSetUp();
//        System.out.println(userProjectList.get(0).getProductList().get(0).getHtmlCode());
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        User.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        User.lastName = lastName;
    }

    public static List<userProject> getUserProjectList() {
        return userProjectList;
    }

    public static void setUserProjectList(List<userProject> userProjectList) {
        User.userProjectList = userProjectList;
    }

    public void exampleDataSetUp()
    {
        ProductMilestone milestoneDraft = new ProductMilestone(1, MILESTONE_NAME.DRAFT_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        ProductMilestone milestoneOutline = new ProductMilestone(1, MILESTONE_NAME.OUTLINE_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        ProductMilestone milestoneCR = new ProductMilestone(1, MILESTONE_NAME.CR_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        ProductMilestone milestoneDeliveryDate = new ProductMilestone(1, MILESTONE_NAME.DELIVERY_DATE_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        List<ProductMilestone> MilestoneList = new ArrayList<>();

        ProductMilestone milestoneDraft1 = new ProductMilestone(1, MILESTONE_NAME.DRAFT_1_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        ProductMilestone milestoneOutline1 = new ProductMilestone(1, MILESTONE_NAME.OUTLINE_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        ProductMilestone milestoneDraft2 = new ProductMilestone(1, MILESTONE_NAME.DRAFT_2_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        ProductMilestone milestoneCR1 = new ProductMilestone(1, MILESTONE_NAME.CR_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        ProductMilestone milestoneDeliveryDate1 = new ProductMilestone(1, MILESTONE_NAME.DELIVERY_DATE_STRING, 2, new Date(),new Date(),"blabla", MILESTONE_STATUS.READY );
        List<ProductMilestone> MilestoneList1 = new ArrayList<>();
        MilestoneList.add(milestoneOutline);
        MilestoneList.add(milestoneDraft);
        MilestoneList.add(milestoneCR);
        MilestoneList.add(milestoneDeliveryDate);

        MilestoneList1.add(milestoneOutline1);
        MilestoneList1.add(milestoneDraft1);
        MilestoneList1.add(milestoneDraft2);
        MilestoneList1.add(milestoneCR1);
        MilestoneList1.add(milestoneDeliveryDate1);

        ProjectProduct product = new ProjectProduct(11,"wing",1, MilestoneList, TEMPLATE_FLOW.BASIC_FLOW);
        ProjectProduct product1 = new ProjectProduct(111,"fly",2, MilestoneList1, TEMPLATE_FLOW.FULL_FLOW);
        List<ProjectProduct> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        userProject project = new userProject("wingToFlyTry","Chemdi",1,11,productList);
        userProject project1 = new userProject("wingToFlyTry2","Chemdi",1,12,productList);
        userProject project2 = new userProject("wingToFly","Chemdi",1,13,productList);
        List<userProject> projectList = new ArrayList<>();
        projectList.add(project);
        projectList.add(project1);
        projectList.add(project2);
        this.userProjectList = projectList;
        List<ProductMilestone> gm= get_MileStons(con , 1);
        System.out.println(gm);

    }
    public static String getUserMilestons(){
        String userMilestons="";

        return userMilestons;
    }

    public static String getUserProjects(){

        List<ProjectProduct> productsNamesList;
        List<ProductMilestone> milestonsNamesList;
        List<String> dataList=new ArrayList<>();
        String userNmae="";

        for (int i=0;i<userProjectList.size();i++){
            dataList.add(userProjectList.get(i).getProjectMame());
            productsNamesList = userProjectList.get(i).getProductList();
            for (int j=0;j<productsNamesList.size();j++){
                dataList.add(productsNamesList.get(j).getProductName());
                milestonsNamesList=productsNamesList.get(j).getProductMilestone();
                for (int k=0;k<milestonsNamesList.size();k++){
                    dataList.add(milestonsNamesList.get(k).getMilestoneName());
                }
            }
        }
        String data="";
        for (int l=0;l<dataList.size();l++){
            data= data+ dataList.get(l)+"  ";
        }

        //List<String> userProjects=new ArrayList<>();

        //userProjects.add();
        return data;
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
            }
        } catch (SQLException e) {
            throw new ProjectExeption("Get the MileSton  faild!!", e);
        }
        return (List<userProject>) projectsList;
    }
//    }

    //    fill product data
    public static List<ProjectProduct> get_Products(Connection con, int project_num)  {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (List<ProjectProduct>) productList;
    }

    //fill milestone
    public static List<ProductMilestone> get_MileStons(Connection con, int product_num)  {
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
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return (List<ProductMilestone>) mileStonList;
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

}
