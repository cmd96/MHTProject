package com.test;

import java.util.List;

public class userProject
{
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


}
