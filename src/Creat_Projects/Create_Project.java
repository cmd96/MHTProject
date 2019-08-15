//package Creat_Projects;
//
//import Project.exception.ProjectExeption;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//  private int ID;
//    private String name ;
//    private int ProjectManager;
//    private String Costumer;
//    private java.util.List<Product> productL;
//
//    public Create_Project(int ID , String name, int ProjectManager, java.util.List<Product> product, String Costumer ) {
//        super();
//        this.ID=ID;
//        this.name=name;
//        this.ProjectManager = ProjectManager;
//        this.productL = product;
//        this.Costumer=Costumer;
//
//    }
//
//    public Create_Project(String name,int ProjectManager,String Costumer) {
//        super();
////        this.ID=ProjectID;
//        this.name=name;
//        this.ProjectManager = ProjectManager;
//        this.Costumer=Costumer;
//    }
//    public Create_Project() {
//        super();
//    }
//    public Create_Project get_Project(Connection con, int project_num) throws ProjectExeption {
////        qwery thart retun the reqwest mileson
//        String sql= "Select * from Projects WHERE ID = "+ project_num;
//        ResultSet rs;
//        try {
//            Statement stmt = con.createStatement();
//            rs = stmt.executeQuery(sql);
//            System.out.println(rs.getInt("ID"));
//
//
////            System.out.println(rs);
//        } catch (SQLException e) {
//            throw new ProjectExeption("Get the MileSton  faild!!", e);
//        }
//
//        return (Create_Project) rs;
//    }
//    public void set_ProjectID(int id){this.ID=id;}
//    public int get_ID(){
//        return ID;
//    }
//    public String get_name() {
//        return name;
//    }
//    public  int get_ProjectManager(){return ProjectManager;}
//    public  String  get_Costumer(){return Costumer;}
//
//    public void set_name(String name) {
//        this.name = name;
//    }
//    public  void set_ProjectManager(int ProjectManager){this.ProjectManager= ProjectManager;}
//
//    public void set_Costumer(String Costumer) {
//        Costumer = Costumer;
//    }
//
//
//    public  static  Create_Project getProject(Connection con,int pro_num) throws ProjectExeption{
//        Create_Project project =new Create_Project();
//        String sql = "SELECT * FROM Projects WHERE  ID="+pro_num;
//        try {
//            Statement stmt =con.createStatement();
//            ResultSet rs =stmt.executeQuery(sql);
//            while (rs.next()) {
//                project.set_ProjectID(rs.getInt("ID"));
//                project.set_name(rs.getString("name"));
//                project.set_ProjectManager(rs.getInt("ProjectManager"));
//                project.set_Costumer(rs.getString("Costumer"));}
//        }catch (SQLException e){
//            throw new ProjectExeption("failed to get project",e);
//        }
//        return project;
//    }
//    public static ResultSet get_project_flow(Connection con, int projectID) throws ProjectExeption, SQLException {
//        Create_Project project=Create_Project.getProject(con,projectID);
////        int num= project.getNumsOfMiles();
//
//        String sql ="SELECT * FROM dbo.MileStons WHERE dbo.MileStons.ProjectId="+projectID;
//        ResultSet rs;
//        try {
//
//            Statement stmt = con.createStatement();
//            rs = stmt.executeQuery(sql);
//        } catch (SQLException e) {
//            throw new ProjectExeption("Get the all MileSton for this project fail!!", e);
//        }
//    return (ResultSet) rs;
//    }
//}
