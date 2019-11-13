package com.test;

import exception.ProjectExeption;

import java.util.List;

public class userProject {
    private String projectMame;
    private String projectCustomer;
    private int projectManagerID;
    private int projectID;
    List<ProjectProduct> productList;
    public userProject(String projectMame, String projectCustomer, int projectManagerID, int projectID, List<ProjectProduct> productList) {
        this.projectMame = projectMame;
        this.projectCustomer = projectCustomer;
        this.projectManagerID = projectManagerID;
        this.projectID = projectID;
        this.productList = productList;
    }

    public String getProjectMame() {
        return projectMame;
    }

    public void setProjectMame(String projectMame) {
        this.projectMame = projectMame;
    }

    public String getProjectCustomer() {
        return projectCustomer;
    }

    public void setProjectCustomer(String projectCustomer) {
        this.projectCustomer = projectCustomer;
    }

    public int getProjectManagerID() {
        return projectManagerID;
    }

    public void setProjectManagerID(int projectManagerID) {
        this.projectManagerID = projectManagerID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public List<ProjectProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<ProjectProduct> productList) {
        this.productList = productList;
    }

    //TODO: get values from db
    public String getProjectNameDB(){
        int ProjectID = getProjectID();
        String sql = "SELECT ProjectName from UserProjects where ProjectID ='" + ProjectID + "'";
        String result = ProjectProduct.ExecuteString(sql, "ProjectName", null);
        return result;
    }

    public int getProjectManagerIDDB(){
        int ProjectID = getProjectID();
        String sql = "SELECT ProjectManagerID from UserProjects where ProductID ='" + ProjectID + "'";
        int result = ProjectProduct.ExecuteInt(sql, "ProjectManagerID", -1);
        return result;
    }

    public String getProjectCustomerDB(){
        int ProjectID = getProjectID();
        String sql = "SELECT ProjectCustomer from UserProjects where ProductID ='" + ProjectID + "'";
        String result = ProjectProduct.ExecuteString(sql, "ProjectManagerID", null);
        return result;
    }

    //TODO: set values in db
    public static void setProjectNameDB(String NewName, int ProjectID) {
        String sql = "update UserProjects set ProjectName = '" + NewName + "' where ProjectID ='" + ProjectID + "'";
        ProjectProduct.ExecuteUpdate(sql);

    }

    public  void setProjectManagerIDDB(int NewProjectManagerID) {
        int ProjectID = this.getProjectID();
        String sql = "update UserProjects set ProjectManagerID = '" + NewProjectManagerID + "' where ProjectID ='" + ProjectID + "'";
        ProjectProduct.ExecuteUpdate(sql);

    }

    public static void setProjectCustomerDB(String NewProjectCustomer, int ProjectID) {
        String sql = "update UserProjects set ProjectCustomer = '" + NewProjectCustomer + "' where ProjectID ='" + ProjectID + "'";
        ProjectProduct.ExecuteUpdate(sql);

    }

    public void deleteProject(int ProjectID) throws ProjectExeption {
        String name =  getProjectNameDB();
//        System.out.println(name+ "  "+ ProjectID);
        String sql = "delete from UserProjects where ProjectID = "+ ProjectID;
        ProjectProduct.deleteProductList(ProjectID);
        ProjectProduct.ExecuteUpdate(sql);

    }

}