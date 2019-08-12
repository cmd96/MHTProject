package com.test;

import java.util.Date;

public class ProductMilestone
{
    private int productID;
    private String milestoneName;
    private int ResponsibleWriterId;
    private Date startDate;
    private Date endDate;
    private String description;
    private int status;

    public ProductMilestone(int productID, String milestoneName, int responsibleWriterId, Date startDate, Date endDate, String description, int status) {
        this.productID = productID;
        this.milestoneName = milestoneName;
        ResponsibleWriterId = responsibleWriterId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.status = status;
    }
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public int getResponsibleWriterId() {
        return ResponsibleWriterId;
    }

    public void setResponsibleWriterId(int responsibleWriterId) {
        ResponsibleWriterId = responsibleWriterId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public  String getHtmlCode()
    {
        String htmlString = CONST_HTML_CODE.HTML_MILESTONE_DIV;
        htmlString.replaceAll(CONST_HTML_CODE.PLACEHOLDER_MILESTONE_DATE_CODE, getEndDate().toString());
        htmlString.replaceAll(CONST_HTML_CODE.PLACEHOLDER_MILESTONE_COMMENT_CODE, getDescription());
        htmlString.replaceAll(CONST_HTML_CODE.PLACEHOLDER_MILESTONE_STATUS_CODE, (status != MILESTONE_STATUS.DONE) ? CONST_HTML_CODE.PLACEHOLDER_MILESTONE_STATUS_IN_PROGRESS_CODE : CONST_HTML_CODE.PLACEHOLDER_MILESTONE_STATUS_DONE_CODE);
        htmlString.replaceAll(CONST_HTML_CODE.PLACEHOLDER_MILESTONE_CLASS, (!description.equals(MILESTONE_NAME.DELIVERY_DATE_STRING)) ? CONST_HTML_CODE.MILESTONE_END_CLASS : CONST_HTML_CODE.PLACEHOLDER_MILESTONE_CLASS);
        return htmlString;
    }
}
