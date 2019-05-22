package Project.db.handling;

import Creat_Projects.Create_Project;
import Project.db.managers.ProjectManager;
import Project.exception.ProjectExeption;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class ProjectDBHandling implements ProjectManager{
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
    }
}
