package Creat_Projects;

import Project.exception.ProjectExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Create_Project {
    //    private static int NumOfMile = 1;
    private int ID;
    private int ProjectManagmentID ;
    private int ResponsiboleWriterId;
    private String TDescription;
    private int NumsOfMiles;
    private Date DateStart;
    private Date DateDone;
    private String Company_Repository;


    public Create_Project(int ProjectManagmentID,int ProjectID,int ResponsiboleWriterId , String TDescription,int NumsOfMiles,Date start,Date done, String Company_Repository) {
        super();
        this.ID=ProjectID;
        this.ProjectManagmentID=ProjectManagmentID;
        this.ResponsiboleWriterId = ResponsiboleWriterId;
        this.TDescription=TDescription;
        this.NumsOfMiles=NumsOfMiles;
        this.DateStart=start;
        this.DateDone=done;  //not sure that need in the beggining!!!-- if need that implement on the milestonDBHandlling on function copy!!
        this.Company_Repository=Company_Repository;

    }
    public Create_Project() {
        super();
    }
    public Create_Project get_Project(Connection con, int project_num) throws ProjectExeption {
//        qwery thart retun the reqwest mileson
        String sql= "Select * from Projects WHERE ID = "+ project_num;
        ResultSet rs;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(rs.getInt("ID"));


//            System.out.println(rs);
        } catch (SQLException e) {
            throw new ProjectExeption("Get the MileSton  faild!!", e);
        }

        return (Create_Project) rs;
    }

    public int getProjectManagmentID(){
        return ProjectManagmentID;
    }
    public int getProjectID() {
        return ID;
    }
    public  int getResponsiboleWriterId(){return ResponsiboleWriterId;}
    public  String  getTDescription(){return TDescription;}
    public  Date getDateStart(){return  DateStart;}
    public Date getDateDone(){return  DateDone;}
    public String getCompany_Repository(){return this.Company_Repository;}
    public int getNumsOfMiles(){return  this.NumsOfMiles;}
    public  void setNumsOfMiles(int NumsOfMiles){this.NumsOfMiles= NumsOfMiles;}
    public void setProjectManagmentID(int projectManagmentID) {
        ProjectManagmentID = projectManagmentID;
    }

    public void setProjectID(int projectID) {
        ID = projectID;
    }

    public void setResponsiboleWriterId(int responsiboleWriterId) {
        ResponsiboleWriterId = responsiboleWriterId;
    }

    public void setTDescription(String TDescription) {
        this.TDescription = TDescription;
    }

    public void setDateStart(Date dateStart) {
        DateStart = dateStart;
    }

    public void setDateDone(Date dateDone) {
        DateDone = dateDone;
    }

    public void setCompany_Repository(String company_Repository) {
        Company_Repository = company_Repository;

    }

    public  static  Create_Project getProject(Connection con,int pro_num) throws ProjectExeption{
        Create_Project project =new Create_Project();
        String sql = "SELECT * FROM Projects WHERE  ID="+pro_num;
        try {
            Statement stmt =con.createStatement();
            ResultSet rs =stmt.executeQuery(sql);
            while (rs.next()) {
                project.setProjectID(rs.getInt("ID"));
                project.setProjectManagmentID(rs.getInt("ProjectManagmentID"));
                project.setResponsiboleWriterId(rs.getInt("ResponsiboleWriterId"));
                project.setTDescription(rs.getString("TDescription"));
                project.setNumsOfMiles((rs.getInt("NumsOfMiles")));
                project.setDateStart(rs.getDate("DateStart"));
                project.setDateDone(rs.getDate("DateDone"));
                project.setCompany_Repository(rs.getString("Company_Repository"));
                }
        }catch (SQLException e){
            throw new ProjectExeption("failed to get project",e);
        }
        return project;
    }
    public static ResultSet get_project_flow(Connection con, int projectID) throws ProjectExeption, SQLException {
        Create_Project project=Create_Project.getProject(con,projectID);
        int num= project.getNumsOfMiles();

        String sql ="SELECT * FROM dbo.MileStons WHERE dbo.MileStons.ProjectId="+projectID;
        ResultSet rs;
        try {

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new ProjectExeption("Get the all MileSton for this project fail!!", e);
        }
    return (ResultSet) rs;
    }


}