package com.test;

import java.sql.*;

public class User {
    public User(){
        int i = 0;
    }
    public static String getUserFirstName(String user, int password){

        return user;
    }

    public boolean isExist(String un, String pw,Connection con,Statement stmt) throws SQLException {
        boolean returnValue=true;
        System.out.println("try connection");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FinalProject;integratedSecurity=true;";

            System.out.println("try connection 1");
            String SQL = "SELECT * FROM Users";
            System.out.println("try connection 2");
            ResultSet rs = stmt.executeQuery(SQL);
            System.out.println("try connection 3");

            while (rs.next()) {
                System.out.println("try connection 4");
                if(rs.getString("UserName").equals(un) && rs.getString("Password").equals(pw)){
                    System.out.println("try connection 5");
                    returnValue=true;
                    break;
                }
//                System.out.println(rs.getString("UserName") + " " + rs.getString("Password"));
            }

        return returnValue;
    }
}
