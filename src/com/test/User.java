package com.test;

import java.sql.*;

public class User {
    private  static Connection connection_;
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
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Project;integratedSecurity=true;";

        try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement();) {
            connection_ = con;
            System.out.println("gjsikasljikpsfld['jiklofadsklad");
            System.out.println(con);
            String SQL = "SELECT * FROM Users";
            ResultSet rs = stmt.executeQuery(SQL);
//            commonConnection = con;
            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public boolean isExist(String un, String pw) throws SQLException {
//        Connection con = SQLConnection.commonConnection;

        boolean returnValue=true;
        System.out.println("try connection");

            System.out.println("try connection 1");
            String SQL = "SELECT * FROM Users";
            System.out.println("try connection 2");
            Statement stmt = connection_.createStatement();
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
