package com.test;

import java.sql.*;

public class User {
    static String username;
    static String password;

    public User(){

    }
    public User(String un,String pw){
        username=un;
        password=pw;

    }
    public static String getUserName() throws SQLException, ClassNotFoundException {
        String fullName="";
        Connection con=SQLConnection.getCon();
        Statement stmt = con.createStatement();

        String SQL = "SELECT * FROM Users WHERE UserName like '"+username+"' and Password like '"+password+"'";
        ResultSet rs= stmt.executeQuery(SQL);
        while (rs.next()) {
            fullName=rs.getString("LastName").toString()+" "+rs.getString("FirstName").toString();
        }
        return fullName;
    }
    public static int getUserID() throws SQLException, ClassNotFoundException {
        int id = 0;
        Connection con=SQLConnection.getCon();
        Statement stmt = con.createStatement();

        String SQL = "SELECT * FROM Users WHERE UserName like '"+username+"' and Password like '"+password+"'";
        ResultSet rs= stmt.executeQuery(SQL);
        while (rs.next()) {
            id=rs.getInt("ID");
        }
        System.out.println(" /////  "+id);
        return id;
    }
    public boolean isExist() throws SQLException, ClassNotFoundException {

        boolean returnValue=false;

        Connection con=SQLConnection.getCon();
        Statement stmt = con.createStatement();

            String SQL = "SELECT * FROM Users";
            ResultSet rs= stmt.executeQuery(SQL);

            while (rs.next()) {
                if(rs.getString("UserName").equals(username) && rs.getString("Password").equals(password)){
                    returnValue=true;
                    break;
                }
            }

        return returnValue;
    }
}
