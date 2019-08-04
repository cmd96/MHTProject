package com.test;

import java.util.Date;

public class ProductMilestone
{
    private int productID;
    private MILESTONE_NAME milestoneName;
    private int ResponsibleWriterId;
    private Date startDate;
    private Date endDate;
    private String description;
    MILESTONE_STATUS status;

    public ProductMilestone(int productID, MILESTONE_NAME milestoneName, int responsibleWriterId, Date startDate, Date endDate, String description, MILESTONE_STATUS status) {
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

    public MILESTONE_NAME getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(MILESTONE_NAME milestoneName) {
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

    public MILESTONE_STATUS getStatus() {
        return status;
    }

    public void setStatus(MILESTONE_STATUS status) {
        this.status = status;
    }
}
