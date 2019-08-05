package Product;

import Project.exception.ProjectExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product {
    int ID;
    String name;
    int projectID;
    private List mileStons;


    public Product(int ID, String name, int ProjectID, List MileSton){
        this.ID= ID;
        this.name=name;
        this.projectID=projectID;
        this.mileStons = MileSton;
    }
    public Product get_Product(Connection con, int ID) throws ProjectExeption {
        String sql = "SELECT * FROM Product WHERE ID="+ID;
        ResultSet rs;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
//            System.out.println(rs);
        } catch (SQLException e) {
            throw new ProjectExeption("Get the History by ID  faild!!", e);
        }
        return (Product) rs;

    }

    public String get_name(){return this.name;}
    public int get_ProjectID(){return this.projectID;}
    public void set_name(String name){this.name=name;}
    public  void set_projectID(int projectID){this.projectID=projectID;}
}
