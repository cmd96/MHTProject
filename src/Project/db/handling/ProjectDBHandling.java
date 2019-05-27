package Project.db.handling;

import Creat_Projects.Create_Project;
import Project.db.managers.ProjectManager;
import Project.exception.ProjectExeption;

import java.sql.*;

public class ProjectDBHandling implements ProjectManager{
    public  static void  insert(Connection con, Create_Project project) throws ProjectExeption{

    }

    public static void delete(Connection con, int Project_num) throws ProjectExeption {
    }

    public static void Update_Project(Connection con, Create_Project project) throws ProjectExeption {
    }

    public static void Copy_Project(Connection con, int project_num) throws ProjectExeption {
    }
    //I checked it

}
