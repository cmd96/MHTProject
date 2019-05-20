package  Project.MileSton;

import Project.exception.ProjectExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

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
        super();
    }


//SAVE

    public int get_ProjectID(){
        return ProjectID;
    }
    //Don't let todo set to Project ID
    public void set_ProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }


    public void set_MileStonID(int MileStonID) {
        this.MileStonID = MileStonID;
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
    public void set_DateToEnd(Date DateToEnd) {
        this.DateToEnd = DateToEnd;
    }

    public Date get_DateDone() {
        return DateDone;
    }

    public void set_DateDone(Date DateDone) {
        this.DateDone = DateDone;
    }

    public Date get_DatePlan() {
        return DatePlan;
    }

    public void set_DatePlan(Date DatePlan) {
        this.DatePlan = DatePlan;
    }
    public void print(MileSton mileSton){
        System.out.println("projectID:" +get_ProjectID());
        System.out.println("Mile ID:"+ get_MileStonID());
        System.out.println("Project Manager Id"+ get_ProjectManagmentID());
        System.out.println("Responsibity Write Id"+ get_ResponsiboleWriterId());
        System.out.println("Desctiption"+ get_TDescription());
        System.out.println("Daate Start"+ get_DateStart());
        System.out.println("Date to end"+ get_DateToEnd());
        System.out.println("Date Plan"+ get_DatePlan());
        System.out.println("Date Done" +get_DateDone());

    }


//I CHECK IT !!!!!
    public static MileSton get_MileSton(Connection con, int mile_num) throws ProjectExeption {
//        qwery that retrun the mileson
        String sql;
        MileSton mile = new MileSton();
        sql = "SELECT * FROM MileStons " +
                "WHERE ID ="+  mile_num;
        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                mile.set_ProjectID(rs.getInt("ProjectID"));
                mile.set_MileStonID(rs.getInt("ID"));
                mile.set_ProjectManagmentID(rs.getInt("ProjectManagerId"));
                mile.set_ResponsiboleWriterId(rs.getInt("ResponsiboleWriterId"));
                mile.set_TDescription(rs.getString("Description"));
                mile.set_DateStart(rs.getDate("DateStart"));
                mile.set_DateToEnd(rs.getDate("DateToEnd"));
                mile.set_DatePlan(rs.getDate("DatePlan"));
                mile.set_DateDone(rs.getDate("DateDone"));
                }
            return mile;
        }
        catch (SQLException e) {
            throw new ProjectExeption(" failed to get mileSton", e);

        }
    }
}




