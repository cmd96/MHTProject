package Project.db.handling;

import Project.MileSton.MileSton;
import Project.db.managers.MileStonManager;
import Project.exception.ProjectExeption;

import java.sql.*;


public class MileStonDBHandling implements MileStonManager {

    public static void insert(Connection con, MileSton mileSton) throws ProjectExeption {
//       MileSton insert_mile=new MileSton(mileSton.get_ProjectID() ,mileSton.get_MileStonID(),
//                mileSton.get_ProjectManagmentID(),mileSton.get_ResponsiboleWriterId(),
//                mileSton.get_TDescription(),mileSton.get_DateStart(),mileSton.get_DateToEnd(),
//                mileSton.get_DatePlan(),mileSton.get_DateDone());
        int demo=mileSton.get_MileStonID();
////        Date d= DateFormat('2002-02-02');
//        String sql;
//        sql= "INSERT INTO MileStons VALUES " + (mileSton.get_MileStonID()+" "+mileSton.get_ProjectID()+" " +mileSton.get_ProjectManagmentID());
////        sql= "INSERT INTO MileStons (ID) VALUES" +("22");
//        sql= "INSERT INTO MileStons  ׂׂVALUES " mileSton.get_ProjectManagmentID(),(mileSton.get_DateToEnd();
        try {
            String sql;
            sql = "INSERT INTO MileStons values "+(mileSton.get_ProjectID() + mileSton.get_MileStonID()+
                    mileSton.get_ProjectManagmentID()+mileSton.get_ResponsiboleWriterId()+
                    mileSton.get_TDescription()+mileSton.get_DateStart()+ mileSton.get_DateToEnd()+
                    mileSton.get_DatePlan()+mileSton.get_DateDone());

            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            rs.insertRow();

        }
        catch (SQLException e) {
            throw new ProjectExeption("failed to inset mileSton", e);
        }
    }
    public static void Update_MileSton(Connection con, MileSton mileston) throws ProjectExeption {
//        MileSton mile = mileston.get_MileSton(con, mileston.get_MileStonID());
//        System.out.println(mile.get_DateStart());
//        System.out.println(mile.get_DateToEnd());
//        System.out.println(mileston.get_MileStonID());
//        System.out.println(mileston.get_ProjectID());
        try{
            String sql;
            sql = "UPDATE MileStons SET ";
//            sql += "ID = '" + MileSton.create_Mile_Id() + "', ";
            sql += "ProjectId = '" + mileston.get_ProjectID() + "', ";
            sql += "ProductID = '"+ 11+"', ";
            sql += "ProjectManagerId = '" + mileston.get_ProjectManagmentID() + "', ";
            sql += "ResponsiboleWriterId = '" + mileston.get_ResponsiboleWriterId() + "', ";
            sql += "Description = '" + mileston.get_TDescription() + "', ";
            sql += "DateStart = '" + mileston.get_DateStart() + "' ";
            sql += "DateToEnd = '" + mileston.get_DateToEnd().toString() + "' ";
//            sql += "DatePlan = '" + mileston.get_DatePlan() + "' ";
//            sql += "DateDone = '" + mile.get_DateDone() + "' ";
            sql += "WHERE ID = " + mileston.get_MileStonID();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }
        catch (SQLException e) {
            throw new ProjectExeption("failed to update mileston", e);
        }

    }
    //@@@I checked the delete funcuallty
    public static void delete(Connection con, int mile_num) throws ProjectExeption {

        String SQL = "DELETE FROM MileStons WHERE ID = " + mile_num;
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new ProjectExeption("failed to delete mile ston", e);
        }
    }

    private void history(MileSton mile, Date dateToEndPlan, java.util.Date dateToEndChange) {

    }

    public static void Copy_MileSton(Connection con, int mileston_num) throws ProjectExeption {
        MileSton mile_to_copy= (MileSton) MileSton.get_MileSton(con,mileston_num);
        MileSton new_mile;
        new_mile = new MileSton((int)mile_to_copy.get_ProjectID(),MileSton.create_Mile_Id(),
                (int)mile_to_copy.get_ProjectManagmentID(),mile_to_copy.get_ResponsiboleWriterId(),
                (String) mile_to_copy.get_TDescription(),(Date)mile_to_copy.get_DateStart(),(Date)mile_to_copy.get_DateToEnd(),
                (Date)mile_to_copy.get_DateDone(),(Date)mile_to_copy.get_DatePlan());
        insert(con,new_mile);
        //                #####NEED TO ADD TO THE DB TABLE!!!#####
//
//    ========not sure that needed============
//        String url = "jdbc:derby://localhost:1527/mbank_db";
//        // connecting to the mbank.db.create
//        try(Connection con = DriverManager.getConnection(url);) {
//            System.out.println("connected");
//            Statement stmt = con.createStatement();
//            stmt.execute(new_mile);
//            System.out.println("success to copy the MileSton: " + new_mile);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    //I checked it

}