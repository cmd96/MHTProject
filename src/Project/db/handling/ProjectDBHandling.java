//package Project.db.handling;
//
//import Creat_Projects.Create_Project;
//import Project.db.managers.ProjectManager;
//import Project.exception.ProjectExeption;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class ProjectDBHandling implements ProjectManager{
//    public  static void  insert(Connection con, Create_Project project) throws ProjectExeption{
////        String qes="SELECT * FROM User Where UserID= " +project.get_ProjectManager()+" AND"+ User.getGetUserRoll()  ;
//
//        String sql = "INSERT INTO Project  values (";
//        sql += "'" + project.get_name()+ "', ";
//        sql += "'" + project.get_ProjectManager()+ "', ";
//        sql += "'" + project.get_Costumer()+ "')";
////        try{
////            Statement stmt = con.createStatement();
////            ResultSet rs= stmt.executeQuery(qes);
////            if (rs.next()){
////                stmt = con.createStatement();
////                stmt.executeUpdate(sql);
////            rs.insertRow();
////            }
//
////        } catch (SQLException e) {
////            throw new ProjectExeption("failed to inset Project to DB", e);
////        }
//
//    }
//
//
//    public static void delete(Connection con, int Project_num) throws ProjectExeption {
//        String SQL = "DELETE FROM MileStons WHERE ID = " + Project_num;
//        try {
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(SQL);
//        } catch (
//                SQLException e) {
//            throw new ProjectExeption("failed to delete mile ston", e);
//        }
//        String sql = "DELETE FROM Projects WHERE ID = " + Project_num;
//        try {
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(sql);
//        } catch (
//                SQLException e) {
//            throw new ProjectExeption("failed to delete project- but delete the all mileston that connect to this project", e);
//        }
//
//
//
//    }
//
//    public static void Update_Project(Connection con, Create_Project project) throws ProjectExeption {
//
////        Create_Project pro = project.get_Project(con, project.getProjectID());
////        System.out.println(project.getNumsOfMiles());
////        System.out.println(project.getCompany_Repository());
////        System.out.println(project.getDateDone());
////        System.out.println(project.getTDescription());
////        System.out.println(project.getProjectManagmentID());
////        System.out.println("in update " +project.getProjectID());
//        try{
//            String sql = "UPDATE Projects SET ";
////            sql += "ID = '" + MileSton.create_Mile_Id() + "', ";
//            sql += "name = '" + project.get_name() + "', ";
//            sql += "ProjectManager = '" + project.get_ProjectManager() + "', ";
//            sql += "Costumer = '" + project.get_Costumer() + "' ";
//            sql += "WHERE ID = " + project.get_ID();
//            System.out.println("id "+ project.get_ID());
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(sql);
//        } catch (SQLException e) {
//            throw new ProjectExeption("failed to update Project", e);
//        }
//
//    }
//
//    public static void Copy_Project(Connection con, int project_num) throws ProjectExeption {
//        Create_Project projet_to_copy = Create_Project.getProject(con, project_num);
//        Create_Project new_pro;
//        new_pro = new Create_Project(projet_to_copy.get_name(), projet_to_copy.get_ProjectManager(), projet_to_copy.get_Costumer());
//        insert(con, new_pro);
//        new_pro.get_ID();
//        String sql = "INSERT into MileSton values (name,poductID,projectID,ResponsibleWriterDateStart,DateToEnd,Description)" +
//                "from MileSton where projectID=" + project_num;
//        try {
////            String sql= "SELECT ID FROM MileStons where ProjectId= " +project_num;
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            rs.getInt("projectID");
////            MileStonDBHandling.Copy_MileSton(con, rs.getInt("ID"));
////            MileStonDBHandling.Update_MileSton(con,rs.);
////            rs.insertRow();
//
//        } catch (
//                SQLException e) {
//            throw new ProjectExeption("failed to copy mile ston", e);
//        }
////        //                #####NEED TO ADD TO THE DB TABLE!!!#####
////
//        //I checked it
//
//    }}
