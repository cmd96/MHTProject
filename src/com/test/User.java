package com.test;

import java.sql.*;

public class User {
    private  static Connection connection_;
    private static ResultSet rs_;
    public User(){
        int i = 0;
    }
    public static String getUserFirstName(String user, int password){

        return user;
    }

    public boolean isExist(String un, String pw) throws SQLException, ClassNotFoundException {

        boolean returnValue=false;

        Connection con=SQLConnection.getCon();
        Statement stmt = con.createStatement();

            String SQL = "SELECT * FROM Users";
            ResultSet rs= stmt.executeQuery(SQL);

            while (rs.next()) {
                if(rs.getString("UserName").equals(un) && rs.getString("Password").equals(pw)){
                    returnValue=true;
                    break;
                }
            }

        return returnValue;
    }
}
