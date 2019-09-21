package com.test;

import java.util.List;

public class ProjectProduct {

    private int projectID;
    private String productName;
     private int productID;
     private List<ProductMilestone> productMilestone;
    private int [] template_flow;

    public ProjectProduct(int projectID, String productName, int productID, List<ProductMilestone> productMilestone, int[] template_flow) {
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

    public String getHtmlCode()
    {
        String htmlCode = CONST_HTML_CODE.HTML_PRODUCT_UP_WRAPPER_START;
        htmlCode+= CONST_HTML_CODE.HTML_PRODUCT_WRAPPER_START + CONST_HTML_CODE.HTML_PRODUCT_CODE ;
        for (ProductMilestone milesotne: productMilestone) {

            htmlCode+=milesotne.getHtmlCode();
        }
        htmlCode+=CONST_HTML_CODE.HTML_PRODUCT_WRAPPER_END;
        htmlCode+=CONST_HTML_CODE.HTML_PRODUCT_BTN;
        htmlCode+=CONST_HTML_CODE.HTML_PRODUCT_UP_WRAPPER_END;
        htmlCode = htmlCode.replaceAll(CONST_HTML_CODE.PLACEHOLDER_PRODUCT_NAME, getProductName());
        return htmlCode;
    }
}
