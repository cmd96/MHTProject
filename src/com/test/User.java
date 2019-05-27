package com.test;

import java.sql.*;

public class User {
    public User(){
        int i = 0;
    }
    public static String getUserFirstName(String user, int password){

        return user;
    }
    void tester ()
    {
        System.out.println("joigfjroigjeroijierj");
    }
    public boolean isExist(String un, String pw) throws SQLException {
        Connection con = SQLConnection.commonConnection;

        boolean returnValue=true;
        System.out.println("try connection");

            System.out.println("try connection 1");
            String SQL = "SELECT * FROM Users";
            System.out.println("try connection 2");
            Statement stmt = con.createStatement();
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
