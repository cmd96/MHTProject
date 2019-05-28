package  MileSton;

import Project.exception.ProjectExeption;
import com.sun.org.apache.xpath.internal.operations.String;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MileSton {

    private int ID;
    private int ProjectID;
    private int ProductID;
    private int ProjectManagmentID ;
    private int ResponsiboleWriterId;
    private String TDescription;
    private Date DateStart;
    private Date DateToEnd;
    private Date DateDone;
    private Date DatePlan;


    public MileSton(int ProjectID,int MileStonID, int ProductID,int ProManID ,int ResWrID, String Descript,Date start,Date end,Date done,Date plan) {
        super();
        this.ID=MileStonID;
        this.ProjectID=ProjectID;
        this.ProductID=ProductID;
        this.ProjectManagmentID = ProManID;
        this.ResponsiboleWriterId=ResWrID;
        this.TDescription=Descript;
        this.DateStart=start;
        this.DateToEnd=end;
        this.DateDone=done;
        this.DatePlan=plan;
    }

    public MileSton() {
       // super();
    }
    public static MileSton get_MileSton(Connection con, int mile_num) throws ProjectExeption {
//        qwery thart retun the reqwest mileson
        java.lang.String sql= "Select * from MileStons WHERE ID = "+mile_num;
        ResultSet rs;
        try {

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
//            System.out.println(rs);
        } catch (SQLException e) {
            throw new ProjectExeption("Get the MileSton  faild!!", e);
        }

        return (MileSton) rs;
    }



    public int get_ProjectID() {
        return ProjectID;
    }
    //Don't let todo set to Project ID
    public void set_ProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    public int get_MileStonID() {
        return ID;
    }
//     Don't let todo set to Mileston ID
//    public void set_MileStonID(int MileStonID) {
//        this.MileStonID = MileStonID;
//    }
    public int get_ProductId(){return  ProductID;}
    public void set_ProductId(int product_id){this.ProductID=product_id;}
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
}
