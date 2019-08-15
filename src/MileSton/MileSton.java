//package  MileSton;
//
//import Project.exception.ProjectExeption;
//import com.sun.org.apache.xpath.internal.operations.String;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Date;
//
//  int ID;
//     java.lang.String name;
//     int poductID;
//     int projectID ;
////     int ResponsibleWriter;
//     Date DateStart;
//     Date DateToEnd;
//     String Description;
//
//    public MileSton(int ID, java.lang.String name, int poductID, int projectID, int responsibleWriter, java.sql.Date dateStart, java.sql.Date dateToEnd, java.lang.String description) {
//        this.ID=ID;
//        this.name=name;
//        this.poductID=poductID;
//        this.projectID = projectID;
//        this.ResponsibleWriter=ResponsibleWriter;
//        this.DateStart=DateStart;
//        this.DateToEnd=DateToEnd;
//        this.Description=Description;
//    }
//
//    public static MileSton get_MileSton(Connection con, int mile_num) throws ProjectExeption {
////        qwery thart retun the reqwest mileson
//        java.lang.String sql= "Select * from MileStons WHERE ID = "+mile_num;
//        ResultSet rs;
//        try {
//
//            Statement stmt = con.createStatement();
//            rs = stmt.executeQuery(sql);
////            System.out.println(rs);
//        } catch (SQLException e) {
//            throw new ProjectExeption("Get the MileSton  faild!!", e);
//        }
//
//        return (MileSton) rs;
//    }
//    public int get_ID(){return this.ID;}
//
//    public String get_name() {
//        return name;
//    }
//    //Don't let todo set to Project ID
//    public void set_name(String name){this.name=name;}
//    public int get_poductID(){return this.poductID; }
//    public void set_poductID(int poductID) {
//        this.poductID = poductID;
//    }
//
//    public int get_projectID() {
//        return projectID;
//    }
////     Don't let todo set to Mileston ID
////    public void set_MileStonID(int MileStonID) {
////        this.MileStonID = MileStonID;
////    }
//    public void set_projectID(int projectID){this.projectID=projectID;}
//    public int get_ResponsibleWriter() {
//        return ResponsibleWriter;
//    }
//
//    public void set_ResponsibleWriter(int ResponsibleWriter) {
//        this.ResponsibleWriter = ResponsibleWriter;
//    }
//
//    public Date get_DateStart(){return DateStart;}
//    public void set_DateStart(Date DateStart) {
//        this.DateStart = DateStart;
//    }
//
//
//
//    public String get_Description() {
//        return Description;
//    }
//
//    public void set_Description(String Description) {
//        this.Description = Description;
//    }
//
//    public Date get_DateToEnd() {
//        return DateToEnd;
//    }
//// Don't let todo set in Date To End
//    public void set_DateToEnd(Date DateToEnd) {
//
//        this.DateToEnd = DateToEnd;
//    }
//
//}
