package Project.db.handling;
import Creat_Projects.Create_Project;
import Project.db.managers.ProjectManager;
import Project.exception.ProjectExeption;
import com.test.SQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class ProjectDBHandling implements ProjectManager{
    private String projectsNames= getAllProjectsNames();
    public  String  getProjectsNames(){return projectsNames;}
    public ProjectDBHandling() throws SQLException, ClassNotFoundException {
    }

    //    void tester()
//    {
//        System.out.println("ojjmufhvuihvhviuh");
//    }
    public  void  insert(Connection con, Create_Project project) throws ParseException{
    }

    public static void delete(Connection con, int Project_num) throws ProjectExeption {
        String SQL = "DELETE FROM MileStons WHERE ProjectId = " + Project_num;
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
            throw new ProjectExeption("failed to delete mile ston", e);
        }
    }
    public static String getAllProjectsNames() throws SQLException, ClassNotFoundException {
        String s="";
        Connection con = SQLConnection.getCon();
        Statement stmt = con.createStatement();

        String SQL = "SELECT * FROM Projects";
        ResultSet rs = stmt.executeQuery(SQL);
        while (rs.next()) {
            s+=rs.getString("Name");
            }
        System.out.println(s);
           return s;
        }
    }

