package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Products {
    private String projectsNames= getAllProjectsNames();
    static private String currentProjectName;
    static private int currentProjectID = -1 ;
    public Products() throws SQLException, ClassNotFoundException {
    }

    public  String  getProjectsNames(){return projectsNames;}
    public static String getAllProjectsNames() throws SQLException, ClassNotFoundException {
        String s="";
        Connection con = SQLConnection.getCon();
        Statement stmt = con.createStatement();

        String SQL = "SELECT * FROM UserProjects";
        ResultSet rs = stmt.executeQuery(SQL);
        while (rs.next()) {
            s+=rs.getString("ProjectName")+" ";
        }
        return s;
    }
    public static void setCurrentProjectName(String inputProjectName) {
        currentProjectName = inputProjectName;
    }
    public static String getCurrentProjectName() {
        return currentProjectName;
    }
    public static void setCurrentProjectID(int inputProjectID) {
        currentProjectID = inputProjectID;
    }
    public static int getCurrentProjectID() throws SQLException, ClassNotFoundException {

        if(currentProjectID != -1)
        {
            return currentProjectID;
        }

        String sql = "SELECT ProjectID from UserProjects where ProjectName like '"+currentProjectName+"'";
        int id = -1 ;
        try {
            Connection con = SQLConnection.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                id = rs.getInt("ProjectID");
//                System.out.println(id);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        currentProjectID = id;
        return id;

    }
}
