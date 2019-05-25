package com.test;
//package com.microsoft;
//public class ConnectionSQL

import Project.db.handling.ProjectDBHandling;
import Project.exception.ProjectExeption;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {


<<<<<<< HEAD
    public static void main(String[] args) throws ProjectExeption, SQLException {
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Project;integratedSecurity=true;";
=======
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=MHTProject;integratedSecurity=true;";
>>>>>>> change DB name

        try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement();) {
//            MileSton mileSton = MileSton.get_MileSton(con,16);
            ProjectDBHandling.delete(con,2);
            //            int jj = mileSton.get_MileStonID();
//            String  sql= "INSERT INTO MileStons (ID,ProjectId,ProductID,ProjectManagerId,ResponsiboleWriterId) VALUES (2,2,2,2,2)";
//            System.out.println(sql);
//            MileStonDBHandling.delete(con,3);
//            stmt.executeQuery("INSERT INTO MileStons (ID,ProjectId,ProductID,ProjectManagerId,ResponsiboleWriterId) VALUES (2,2,2,2,2)");
        }
            catch (SQLException e) {
                throw new ProjectExeption("failed to inset mileSton", e);
            }
            //              MileSton.get_MileSton(con,16);
//            ResultSet rs= (ResultSet) Create_Project.get_project_flow(con,2);
//            while (rs.next()) {
//                System.out.println(rs.getString("Description") + " " + rs.getInt("ID")+" "+ rs.getInt("ProjectId"));
//            }
//            MileSton trying = MileSton.get_MileSton(con, 16);
//            MileStonDBHandling.insert(con,mile);
//            trying.set_ProjectID(55555);
//            trying.set_MileStonID(MileSton.create_Mile_Id());
//            trying.set_ResponsiboleWriterId(555555);
//            System.out.println(trying.get_DateToEnd());
//
//            String sql;
//            sql = "INSERT INTO MileStons values(";
////            sql += "ID" +8 + ",";
//            sql += 1 + ", ";
//            sql += 11 + ", ";
//            sql += 1 + ", ";
//            sql += 1+ ", ";
//            sql += 1 +",";
//            sql += String.format("%d", 10-10-2010)+",";
//            sql += String.format("%d", 10-10-2010)+",";
//            sql += String.format("%d", 10-10-2010)+",";
//            sql += String.format("%d", 10-10-2010)+")";
//            sql= "INSERT INTO MileStons"+ mile;
//            stmt.execute(sql);
////            MileStonDBHandling.Update_MileSton(con,trying);
//            MileStonDBHandling.insert(con,trying);
//            MileStonDBHandling.delete(con,trying.get_MileStonID());
//            MileStonDBHandling.Copy_MileSton(con,trying.get_MileStonID());

        }
//            trying.set_MileStonID(MileSton.create_Mile_Id());
//            trying.set_ProjectID(345);
//            System.out.println(trying.get_MileStonID());
//            MileStonDBHandling.delete(con,11);
//            MileStonDBHandling.Update_MileSton(con,trying);
//            String sql = "DELETE * FROM MileSton WHERE MileStonID = " + trying.get_MileStonID();

////            MileStonDBHandling.delete(con, 18 );
//            MileStonDBHandling.Update_MileSton( con, trying);
        //            String SQL = "SELECT * FROM Users";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }


//
//             Iterate through the data in the result set and display it.
//            while (rs.next()) {
//                System.out.println(rs.getString("UserName") + " " + rs.getString("Password"));
//            }
//
//            print(trying);

//        }
//        try {
//            Desktop desktop = java.awt.Desktop.getDesktop();
//            URI oURL = new URI("http://localhost:8000/index.jsp");
//            desktop.browse(oURL);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


////// package com.microsoft;
//////public class ConnectionSQL
////
////import java.sql.*;
////
////
////public class SQLConnection {
////
////    public static void main(String[] args) {
////
////        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FinalProject;integratedSecurity=true;";
//////
//        try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement();) {
//            String SQL = "SELECT * FROM Users";
//            ResultSet rs = stmt.executeQuery(SQL);
//
//            // Iterate through the data in the result set and display it.
//            while (rs.next()) {
//                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//////
////
////    }}
////
////
////
//
//
//
//
//
//
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.*;
//
//public class SQLConnection {
//    public static Connection getConnetion() throws SQLException {
//        //String st= FinalProject.dbo.Users.LastName;
//
//        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=FinalProject";
//        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        Connection con =null;
//        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(connectionUrl);
//            //Statement stmt = con.createStatement();
//            //String SQL = "SELECT * FROM FinalProject.Users;";
//            //ResultSet rs = stmt.executeQuery(SQL);
//            //name=displayRow(rs);
//
//        }
//        catch (Exception e){
//            System.out.println(con);
//
//        }
//
//        // Handle any errors that may have occurred.
//
//        return con;
//    }
//
//    private static String displayRow(ResultSet rs) throws SQLException {
//        String s="";
//        while (rs.next()) {
//            s+=(rs.getString("FirstName") + " : " + rs.getString("Name"));
//        }
//        return s;
//    }
//
//}
