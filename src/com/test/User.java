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
        exampleDataSetUp();
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
        userProject project = new userProject("wingToFly","Chemdi",1,11,productList);
        List<userProject> projectList = new ArrayList<>();
        projectList.add(project);
        this.userProjectList = projectList;
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
    //fill project
    //{
    //  for list projectList from SQLserver
    //}
    //fill product data

    //fill milestone

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
