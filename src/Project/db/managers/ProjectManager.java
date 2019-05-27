package Project.db.managers;

import Creat_Projects.Create_Project;
import Project.exception.ProjectExeption;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public interface  ProjectManager {
    public interface MileStonManager {

        static void insert(Connection con, Create_Project project) throws ProjectExeption {
        }

        static void Update_Project(Connection con, Create_Project project) throws ProjectExeption {
            //        Create_Project pro = project.get_Project(con, project.getProjectID());
            System.out.println(project.getNumsOfMiles());
            System.out.println(project.getCompany_Repository());
            System.out.println(project.getDateDone());
            System.out.println(project.getTDescription());
            System.out.println(project.getProjectManagmentID());
            System.out.println("in update " +project.getProjectID());
            try{
                String sql;
                sql = "UPDATE Projects SET ";
//            sql += "ID = '" + MileSton.create_Mile_Id() + "', ";
                sql += "ProjectManagmentID = '" + project.getProjectManagmentID() + "', ";
                sql += "ResponsiboleWriterId = '" + project.getResponsiboleWriterId() + "', ";
                sql += "TDescription = '" + project.getTDescription() + "', ";
                sql += "NumsOfMiles = '" + project.getNumsOfMiles() + "', ";
//            sql += "DateStart = '" + project.getDateStart() + "' ";
//            sql += "DateDone = '" + project.getDateDone();
                sql += "Company_Repository = '" + project.getCompany_Repository() + "' ";
                sql += "WHERE ID = " + project.getProjectID();
                System.out.println("id "+ project.getProjectID());
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
            }
            catch (SQLException e) {
                throw new ProjectExeption("failed to update Project", e);
            }


        }

        static void Copy_Project(Connection con, int project_num) throws ProjectExeption {
            Create_Project projet_to_copy= (Create_Project) Create_Project.getProject(con,project_num);
            Create_Project new_pro;
            new_pro = new Create_Project((int)projet_to_copy.getProjectID(),
                    (int)projet_to_copy.getProjectManagmentID(),projet_to_copy.getResponsiboleWriterId(),
                    (String) projet_to_copy.getTDescription(),projet_to_copy.getNumsOfMiles(),(Date) projet_to_copy.getDateStart(),(Date)projet_to_copy.getDateDone(),
                    (String)projet_to_copy.getCompany_Repository());
            insert(con,new_pro);
//        try {
//            String sql= "SELECT ID FROM MileStons where ProjectId= " +project_num;
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            MileStonDBHandling.Copy_MileSton(con, rs.getInt("ID"));
////            MileStonDBHandling.Update_MileSton(con,rs.);
//            rs.insertRow();
//
//        } catch (
//                SQLException e) {
//            throw new ProjectExeption("failed to copy mile ston", e);
//        }
//        //                #####NEED TO ADD TO THE DB TABLE!!!#####
//

        }

        static void delete_Project(Connection con, int Project_num) throws ProjectExeption {
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
                throw new ProjectExeption("failed to delete proect", e);
            }



        }
//    Client query (Connection con, long id) throws ProjectExeption;
//    Client[] queryAllClients(Connection con);

    }
}
