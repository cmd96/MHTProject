package db.handling;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import Project.MileSton.MileSton;
import Project.db.managers.MileStonManager;
import Project.exception.ProjectExeption;


class MileStonDbHandling implements MileStonManager {

    public void Update_MileSton(Connection con, MileSton mileston) throws ProjectExeption {

        MileSton mile = mileston.get_MileSton(con, mileston.get_MileStonID());

        mile.set_ProjectID(mileston.get_ProjectID());
        mile.set_ProjectManagmentID(mileston.get_ProjectManagmentID());
        mile.set_ResponsiboleWriterId(mileston.get_ResponsiboleWriterId());
        mile.set_TDescription(mileston.get_TDescription());
        mile.set_DateDone(mileston.get_DateDone());


        if (mile.get_DateStart() == null)
            mile.set_DateStart(mileston.get_DateStart());
        else
            throw new ProjectExeption("Cannot open the MileSton- already open!!");

        if (mile.get_DateToEnd() != mileston.get_DateToEnd())
            history_DateToEnd(mile, mile.get_DateToEnd(), mileston.get_DateToEnd());
//                    need permision???
        mile.set_DateToEnd(mileston.get_DateToEnd());


    }

    private void history_DateToEnd(Project.MileSton.MileSton mile, Date dateToEnd, Date dateToEnd1) {
    }

    @Override
    public void update(Connection con, MileSton mileston) throws ProjectExeption {

        String sql;

        int MileIDToChange=mileston.get_MileStonID();
        int ProjectIDTochange=mileston.get_ProjectID();
        MileSton mileToChange=get_MileSton(con,MileIDToChange,ProjectIDTochange);
        sql = "UPDATE MileSton SET ";
        sql += "ProjectManagmentID = '" + mileston.get_ProjectManagmentID() + "', ";
        sql += "ResponsiboleWriterId = '" + mileston.get_ResponsiboleWriterId() + "', ";
        sql += "TDescription = '" + mileston.get_TDescription().toString() + "', ";
        sql += "DateStart = '" + mileston.get_DateStart() + "', ";
//        sql += "DateToEnd = '" + mileston.get_DateToEnd() + "', ";
        sql += "DateDone = '" + mileston.get_DateDone() + "', ";


        try {

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new ProjectExeption("", e);
        }
    }

    private MileSton get_MileSton(Connection con, int mileIDToChange, int projectIDTochange) {
        return null;
    }

    @Override
    public void delete(Connection con, long clientId) throws MBankException {

        String sql = "DELETE FROM clients WHERE p_id = " + clientId;

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new MBankException("", e);
        }
    }







}