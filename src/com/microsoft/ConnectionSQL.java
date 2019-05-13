//public class ConnectionSQL
package com.microsoft;
import java.sql.*;
import java.sql.DriverManager;

public class ConnectionSQL {


    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Project;integratedSecurity=true;";

        try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {
            String SQL = "SELECT * FROM User ";
//            String SQL = "SELECT ProjectID, MileStonID, ProjectManagmentID, ResponsiboleWriterId, TDescription, DateStart, DateToEnd , DatePlan " +
//                    "FROM MileSton MileSton " +
//                    "WHERE MileStonID = " + "mile_num";
            ResultSet rs = stmt.executeQuery(SQL);
            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}