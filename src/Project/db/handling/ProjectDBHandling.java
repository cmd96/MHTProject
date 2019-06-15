package Project.db.handling;
import Creat_Projects.Create_Project;
import Project.db.managers.ProjectManager;
import Project.exception.ProjectExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class ProjectDBHandling implements ProjectManager{

    public ProjectDBHandling() throws SQLException, ClassNotFoundException {
    }

    //    void tester()
//    {
//        System.out.println("ojjmufhvuihvhviuh");
//    }
    public static void  insert(Connection con, Create_Project project) throws ParseException{
    }

    public static void delete(Connection con, int Project_num) throws ProjectExeption {
        String SQL = "DELETE FROM MileStons WHERE ID = " + Project_num;
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (
                SQLException e) {
            throw new ProjectExeption("failed to delete mile ston", e);
        }
        String sql = "DELETE FROM Projects WHERE ID = " + Project_num;
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (
                SQLException e) {
            throw new ProjectExeption("failed to delete proect", e);
        }



    }

    public static void Update_Project(Connection con, Create_Project project) throws ProjectExeption {

//        Create_Project pro = project.get_Project(con, project.getProjectID());
//        System.out.println(project.getNumsOfMiles());
//        System.out.println(project.getCompany_Repository());
//        System.out.println(project.getDateDone());
//        System.out.println(project.getTDescription());
//        System.out.println(project.getProjectManagmentID());
//        System.out.println("in update " +project.getProjectID());
        try{
        String sql = "UPDATE Projects SET ";
//            sql += "ID = '" + MileSton.create_Mile_Id() + "', ";
            sql += "name = '" + project.get_name() + "', ";
            sql += "ProjectManager = '" + project.get_ProjectManager() + "', ";
            sql += "Costumer = '" + project.get_Costumer() + "' ";
            sql += "WHERE ID = " + project.get_ID();
            System.out.println("id "+ project.get_ID());
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new ProjectExeption("failed to update Project", e);
        }

    }




    public static void Copy_Project(Connection con, int project_num) throws ProjectExeption, ParseException {
        Create_Project projet_to_copy = Create_Project.getProject(con, project_num);
        Create_Project new_pro;
        new_pro = new Create_Project(projet_to_copy.get_name(), projet_to_copy.get_ProjectManager(), projet_to_copy.get_Costumer());
        insert(con, new_pro);
        String sql = "insert into MileSton select (name,poductID,projectID,ResponsibleWriterDateStart,DateToEnd,Description)" +
                " from MileSton where projectID=" + project_num;
        try {
//            String sql= "SELECT ID FROM MileStons where ProjectId= " +project_num;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
//            MileStonDBHandling.Copy_MileSton(con, rs.getInt("ID"));
//            MileStonDBHandling.Update_MileSton(con,rs.);
//            rs.insertRow();

        } catch (
                SQLException e) {
            throw new ProjectExeption("failed to copy mile ston", e);
        }
//        //                #####NEED TO ADD TO THE DB TABLE!!!#####
//
        //I checked it

    }
}
