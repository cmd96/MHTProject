package  Project.MileSton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.lang.String;
import Project.exception.ProjectExeption;

public class MileSton {

//    private static int NumOfMile = 1;
    private int ProjectID;
    private int MileStonID;
    private int ProjectManagmentID ;
    private int ResponsiboleWriterId;
    private String TDescription;
    private Date DateStart;
    private Date DateToEnd;
    private Date DateDone;
    private Date DatePlan;
    private static int NumOfMile =1;

    public MileSton(int ProjectID,int MileStonID,int ProManID ,int ResWrID, String Descript,Date start,Date end,Date done,Date plan) {
        super();
        this.ProjectID=ProjectID;
        this.MileStonID=create_Mile_Id();
        this.ProjectManagmentID = ProManID;
        this.ResponsiboleWriterId=ResWrID;
        this.TDescription=Descript;
        this.DateStart=start;
        this.DateToEnd=end;
//        this.DateDone=done;  //not sure that need in the beggining!!!-- if need that implement on the milestonDBHandlling on function copy!!
        this.DatePlan=plan;

    }
    public static int create_Mile_Id(){
        NumOfMile++;
        return NumOfMile;
    }
        public MileSton() {
       // super();
    }


//SAVE

    public int get_ProjectID(){
        return ProjectID;
    }
    //Don't let todo set to Project ID
    public void set_ProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    public int get_MileStonID() {
        return MileStonID;
    }
//     Don't let todo set to Mileston ID
//    public void set_MileStonID(int MileStonID) {
//        this.MileStonID = MileStonID;
//    }
    public int get_ProjectManagmentID() {
        return ProjectManagmentID;
    }

    public void set_ProjectManagmentID(int ProjectManagmentID) {
        this.ProjectManagmentID = ProjectManagmentID;
    }

    public int get_ResponsiboleWriterId() {
        return ResponsiboleWriterId;
    }

    public void set_ResponsiboleWriterId(int ResponsiboleWriterId) {
        this.ResponsiboleWriterId = ResponsiboleWriterId;
    }

    public String get_TDescription() {
        return TDescription;
    }

    public void set_TDescription(String TDescription) {
        this.TDescription = TDescription;
    }

    public Date get_DateStart() {
        return DateStart;
    }

    public void set_DateStart(Date DateStart) {
        this.DateStart = DateStart;
    }

    public Date get_DateToEnd() {
        return DateToEnd;
    }
// Don't let todo set in Date To End
    public void set_DateToEnd(Date DateToEnd) {

        this.DateToEnd = DateToEnd;
    }

    public Date get_DateDone() {
        return DateDone;
    }

    public void set_DateDone(Date DateDone) {
        this.DateToEnd = DateDone;
    }

    public Date get_DatePlan() {
        return DatePlan;
    }

    public static MileSton  get_MileSton(Connection con, int mile_num) throws ProjectExeption {
//        qwery thart retun the reqwest mileson

        String sql;
//        String sql;
        MileSton mile = null;

        sql = "SELECT ProjectID, MileStonID, ProjectManagmentID, ResponsiboleWriterId, TDescription, DateStart, DateToEnd , DatePlan " +
                "FROM MileSton MileSton " +
                "WHERE MileStonID = " + "mile_num";

//        try {
//        MileSton found_mile=
//                            SELECT *
//                            FROM Project.MileSton.MileSton;
//                            WHERE MileStonID=mile_num
//
//
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(found_mile);
            try {

                Statement stmt = con.createStatement();
                MileSton rs = (MileSton) stmt.executeQuery(sql);
//                rs.next();
                mile.set_ProjectID(rs.get_ProjectID());
//                mile.set_MileStonID(rs.get_MileStonID());
                mile.set_ProjectManagmentID(rs.get_ProjectManagmentID());
                mile.set_ResponsiboleWriterId(rs.get_ResponsiboleWriterId());
                mile.set_TDescription(rs.get_TDescription());
                mile.set_DateStart(rs.get_DateStart());
                mile.set_DateToEnd(rs.get_DateToEnd());
                mile.set_DateDone(rs.get_DateDone());
//                mile.set_DatePlan(rs.get_DatePlan(9));
                return mile;

            }
            catch (SQLException e) {
                throw new ProjectExeption("query failed", e);

            }
//        return found_mile;
        }


    }




