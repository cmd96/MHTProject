package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hello {
    private String projectsNames= getAllProjectsNames();
    static private String currentProjectName;
    public Hello() throws SQLException, ClassNotFoundException {
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
}
