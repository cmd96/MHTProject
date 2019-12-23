package com.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryAction {


    private String personName;
    private String projectName;
    private String productName;
    private String description;
    private String HTMLCode;
    private int  historyID;
    private Date actionDate;
    public static String HISTORY_BASIC_CODE = "<tr><td>#DATE#</td><td>#PERSON#</td><td>#PROJECT_NAME#</td><td>#PRODUCT_NAME#</td><td>#DESCRIPTION#</td></tr>";

    public HistoryAction(int historyID, String personName, String projectName, String productName, String description, Date actionDate) {
        this.personName = personName;
        this.projectName = projectName;
        this.productName = productName;
        this.description = description;
        this.historyID = historyID;
        this.actionDate = actionDate;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
        String strActionDate = formatter.format(actionDate);
        this.HTMLCode = HISTORY_BASIC_CODE;
        this.HTMLCode = this.HTMLCode.replaceAll("#DATE#",strActionDate);
        this.HTMLCode = this.HTMLCode.replaceAll("#PERSON#",personName);
        this.HTMLCode = this.HTMLCode.replaceAll("#PROJECT_NAME#",projectName);
        this.HTMLCode = this.HTMLCode.replaceAll("#PRODUCT_NAME#",productName);
        this.HTMLCode = this.HTMLCode.replaceAll("#DESCRIPTION#",description);
    }

    public HistoryAction(Date actionDate, String personName, String projectName, String productName, String description) throws SQLException, ClassNotFoundException {
        this.actionDate = actionDate;
        this.personName = personName;
        this.projectName = projectName;
        this.productName = productName;
        this.description = description;
        this.HTMLCode = HISTORY_BASIC_CODE;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
        String strActionDate = formatter.format(actionDate);
        this.HTMLCode = this.HTMLCode.replaceAll("#DATE#",strActionDate);
        this.HTMLCode = this.HTMLCode.replaceAll("#PERSON#",personName);
        this.HTMLCode = this.HTMLCode.replaceAll("#PROJECT_NAME#",projectName);
        this.HTMLCode = this.HTMLCode.replaceAll("#PRODUCT_NAME#",productName);
        this.HTMLCode = this.HTMLCode.replaceAll("#DESCRIPTION#",description);

        insertHistoryDB();
    }
    public int getHistoryID() {
        return historyID;
    }

    public void setHistoryID(int historyID) {
        this.historyID = historyID;
    }

    private void insertHistoryDB() throws SQLException, ClassNotFoundException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
        String strActionDate = formatter.format(actionDate);
        Connection con = SQLConnection.getCon();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into History values('"+personName+"','"+projectName+"','"+productName+"','"+description+"','"+strActionDate+"')");
        con.close();
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHTMLCode() {
        return HTMLCode;
    }

    public void setHTMLCode(String HTMLCode) {
        this.HTMLCode = HTMLCode;
    }

}
