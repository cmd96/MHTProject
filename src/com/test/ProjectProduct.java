package com.test;

import java.util.List;

public class ProjectProduct {

    private int projectID;
    private String productName;
    private int productID;
    private List<ProductMilestone> productMilestone;
    private TEMPLATE_FLOW template_flow;

    public ProjectProduct(int projectID, String productName, int productID, List<ProductMilestone> productMilestone, TEMPLATE_FLOW template_flow) {
        this.projectID = projectID;
        this.productName = productName;
        this.productID = productID;
        this.productMilestone = productMilestone;
        this.template_flow = template_flow;
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

    public void setProductName(String productName) {
        this.productName = productName;
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
    public TEMPLATE_FLOW getTemplate_flow() {
        return template_flow;
    }

    public void setTemplate_flow(TEMPLATE_FLOW template_flow) {
        this.template_flow = template_flow;
    }
}
