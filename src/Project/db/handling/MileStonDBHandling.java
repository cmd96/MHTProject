//package Project.db.handling;
//
//import MileSton.MileSton;
//import Project.db.managers.MileStonManager;
//import Project.exception.ProjectExeption;
//import java.sql.Statement;
//
//import java.sql.*;
//
//
//public class MileStonDBHandling implements MileStonManager {
//
//    public static void insert(Connection con, MileSton mileSton) throws ProjectExeption {
////       MileSton insert_mile=new MileSton(mileSton.get_ProjectID() ,mileSton.get_MileStonID(),
////                mileSton.get_ProjectManagmentID(),mileSton.get_ResponsiboleWriterId(),
////                mileSton.get_TDescription(),mileSton.get_DateStart(),mileSton.get_DateToEnd(),
////                mileSton.get_DatePlan(),mileSton.get_DateDone());
////        int demo=mileSton.get_MileStoncon,mileSton.get_ID());
//////        Date d= DateFormat('2002-02-02');
////        String sql;
////        sql= "INSERT INTO MileStons VALUES " + (mileSton.get_MileStonID()+" "+mileSton.get_ProjectID()+" " +mileSton.get_ProjectManagmentID());
//////        sql= "INSERT INTO MileStons (ID) VALUES" +("22");
////        sql= "INSERT INTO MileStons  ×‚×‚VALUES " mileSton.get_ProjectManagmentID(),(mileSton.get_DateToEnd();
//        int isExist = 0;
//        String qes = "SELECT * FROM Project WHERE ID= " + mileSton.get_projectID();//check if there is a current project
//        String sql = "INSERT INTO MileSton  values (";
//
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(qes);
//            if (rs.next())
////       {
//                sql += "'" + mileSton.get_name() + "', ";
//            sql += "'" + mileSton.get_poductID() + "', ";
//            sql += "'" + mileSton.get_projectID() + "', ";
//            sql += "'" + mileSton.get_ResponsibleWriter() + "', ";
//            sql += "'" + mileSton.get_DateStart() + "', ";
//            sql += "'" + mileSton.get_DateToEnd() + "', ";
//            sql += "'" + mileSton.get_Description() + "')";
//
//            try {
//                stmt = con.createStatement();
//                stmt.executeUpdate(sql);
////            rs.insertRow();
//
//            } catch (SQLException e) {
//                throw new ProjectExeption("failed to inset mileSton", e);
//            }
//        } catch (SQLException e) {
//            throw new ProjectExeption("The Project is not exist!", e);
//        }
//    }
//
//    public static void Update_MileSton(Connection con, MileSton mileston) throws ProjectExeption {
////        MileSton mile = mileston.get_MileSton(con, mileston.get_MileStonID());
////        System.out.println(mile.get_DateStart());
////        System.out.println(mile.get_DateToEnd());
////        System.out.println(mileston.get_MileStonID());
////        System.out.println(mileston.get_ProjectID());
//        try {
//            java.lang.String sql;
//            sql = "UPDATE MileStons SET ";
////            sql += "ID = '" + MileSton.create_Mile_Id() + "', ";
//            sql += "name = '" + mileston.get_name() + "', ";
//            sql += "poductID = '" + mileston.get_poductID() + "', ";
//            sql += "projectID = '" + mileston.get_projectID() + "', ";
//            sql += "ResponsibleWriter = '" + mileston.get_ResponsibleWriter() + "', ";
//            sql += "DateStart = '" + mileston.get_DateStart() + "' ";
//            sql += "DateToEnd = '" + mileston.get_DateToEnd().toString() + "' ";
//            sql += "Description = '" + mileston.get_Description() + "' ";
//            sql += "WHERE ID = " + mileston.get_ID();
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(sql);
//        } catch (SQLException e) {
//            throw new ProjectExeption("failed to update mileston", e);
//        }
//
//    }
//
//    //@@@I checked the delete funcuallty
//    public static void delete(Connection con, int mile_num) throws ProjectExeption {
//
//        java.lang.String sql = "DELETE FROM MileStons WHERE ID = " + mile_num;
//        try {
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(sql);
//        } catch (SQLException e) {
//            throw new ProjectExeption("failed to delete mile ston", e);
//        }
//    }
//    //    private void history(MileSton mile, Date dateToEndPlan, java.util.Date dateToEndChange) {
//    public static void Copy_MileSton(Connection con, int mileston_num) throws ProjectExeption {
//        MileSton mile_to_copy = (MileSton) MileSton.get_MileSton(con, mileston_num);
//        MileSton new_mile;
//        new_mile = new MileSton(mile_to_copy.get_name(), (int) mile_to_copy.get_poductID(), (int) mile_to_copy.get_projectID(),
//                (int) mile_to_copy.get_ResponsibleWriter(), (Date) mile_to_copy.get_DateStart(), (Date) mile_to_copy.get_DateToEnd(),
//                mile_to_copy.get_Description());
//        insert(con, new_mile);
//    }
//}
////    ========not sure that needed============
////        String url = "jdbc:derby://localhost:1527/mbank_db";
////        // connecting to the mbank.db.create
////        try(Connection con = DriverManager.getConnection(url);) {
////            System.out.println("connected");
////            Statement stmt = con.createStatement();
////            stmt.execute(new_mile);
////            System.out.println("success to copy the MileSton: " + new_mile);
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////I checked it
//
////}