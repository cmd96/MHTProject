package Project.db.handling;//package Project.db.handling;

import Project.exception.ProjectExeption;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//
//import Project.db.managers.MileStonManager;
//import Project.exception.ProjectExeption;
//
public class HistoryDBHandling {
    int LavelChange;
    int IdItem;
    String RowChanged;
    String ChagedFrom;
    String ChangedTo;

    public void insert(Connection con, int LavelChanged ,int IdItem, String RowChanged,String CF, String CT) throws ProjectExeption {
        String sql = "INSERT INTO Project  values (";
        sql += "'" +LavelChanged + "', ";
        sql += "'" + IdItem + "', ";
        sql += "'" + RowChanged + "', ";
        sql += "'" + CF + "', ";
        sql += "'" + CT + "')";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
//            rs.insertRow();


        } catch (SQLException e) {
            throw new ProjectExeption("failed to inset Project to DB", e);
        }
    }

}

//    public void Update_History(Connection con, MileSton mileston) throws ProjectExeption {
//
//        MileSton mile = mileston.get_MileSton(con, mileston.get_MileStonID());
//        mile.set_ProjectID(mileston.get_ProjectID());
//        mile.set_ProjectManagmentID(mileston.get_ProjectManagmentID());
//        mile.set_ResponsiboleWriterId(mileston.get_ResponsiboleWriterId());
//        mile.set_TDescription(mileston.get_TDescription());
//        mile.set_DateDone(mileston.get_DateDone());
//
//
//        if (mile.get_DateStart() == null)
//            mile.set_DateStart(mileston.get_DateStart());
//        else
//            throw new ProjectExeption("Cannot open the MileSton- already open!!");
//
//        if (mile.get_DateToEnd() != mileston.get_DateToEnd())
//            history_DateToEnd(mile, mile.get_DateToEnd(), mileston.get_DateToEnd());
////                    need permision???
//        mile.set_DateToEnd(mileston.get_DateToEnd());
////IN SQL QES:
//        String sql;
//
//        sql = "UPDATE MileSton SET ";
//        sql += "ProjectID = '" + mileston.get_ProjectID() + "', ";
//        sql += "get_ProjectManagmentID = '" + mileston.get_ProjectManagmentID() + "', ";
//        sql += "ResponsiboleWriterId = '" + mileston.get_ResponsiboleWriterId() + "', ";
//        sql += "get_TDescription = '" + mileston.get_TDescription() + "', ";
//        sql += "DateDone = '" + mileston.get_DateDone() + "', ";
//        sql += "WHERE MileStonID = " + mileston.get_MileStonID();
//
//        try {
//
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(sql);
//
//        } catch (SQLException e) {
//            throw new ProjectExeption("fail to update MileSton", e);
//        }
////========================who did the change==========================
////   =======maybe the update need to be:
////
////        String sql;
////
////        sql = "UPDATE MileSton SET ";
////        sql += "ProjectID = '" + mileston.get_ProjectID() + "', ";
////        sql += "MileStonID = '" + new int + "', ";
////        sql += "ProjectManagmentID = '" + mileston.get_ProjectManagmentID() + "', ";
////        sql += "ResponsiboleWriterId = '" + mileston.getResponsiboleWriterId() + "', ";
////        sql += "TDescription = '" + mileston.get_TDescription() + "', ";
////        sql += "get_DateDone = '" + mileston.get_DateDone() + "' ";
////        sql += "WHERE MileStonID = " + mileston.getMileStonID();
////
////        try {
////
////            Statement stmt = con.createStatement();
////            stmt.executeUpdate(sql);
////
////        } catch (SQLException e) {
////            throw new MBankException("", e);
////        }
//    }
//    public void delete(Connection con, int mile_num) throws ProjectExeption {
//
//        String sql = "DELETE FROM MileSton WHERE MileStonID = " + mile_num;
//
//        try {
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(sql);
//        } catch (SQLException e) {
//            throw new ProjectExeption("", e);
//        }
//    }

//    private void history_DateToEnd(MileSton mile, Date dateToEndPlan, java.util.Date dateToEndChange) {
//
//    }

//    public void Copy_MileSton(Connection con, int mileston_num) throws ProjectExeption {
//        MileSton mile_to_copy= (MileSton) MileSton.get_MileSton(con,mileston_num);
//        MileSton new_mile;
//        new_mile = new MileSton((int)mile_to_copy.get_ProjectID(),MileSton.create_Mile_Id(),
//                (int)mile_to_copy.get_ProjectManagmentID(),mile_to_copy.get_ResponsiboleWriterId(),
//                (String) mile_to_copy.get_TDescription(),(Date)mile_to_copy.get_DateStart(),(Date)mile_to_copy.get_DateToEnd(),
//                (Date)mile_to_copy.get_DateDone(),(Date)mile_to_copy.get_DatePlan());
//        insert(con,new_mile);
//        //                #####NEED TO ADD TO THE DB TABLE!!!#####
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
//    }

