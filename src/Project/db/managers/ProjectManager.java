package Project.db.managers;

import Creat_Projects.Create_Project;
import Project.exception.ProjectExeption;

import java.sql.Connection;

public interface  ProjectManager {
    public interface MileStonManager {

        static void insert(Connection con, Create_Project project) throws ProjectExeption {
        }

        static void Update_Project(Connection con, Create_Project project) throws ProjectExeption {
        }

        static void Copy_Project(Connection con, int mileston_num) throws ProjectExeption {
        }

        static void delete_Project(Connection con, int mile_num) throws ProjectExeption {
        }
//    Client query (Connection con, long id) throws ProjectExeption;
//    Client[] queryAllClients(Connection con);

    }
}
