package History;

import Project.exception.ProjectExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class History {
    private int ID;
    private int LavelChange; //if ==1-> become from Project if==2-> become from product if==3->mileston
    private int IdItem;
    private String RowChanged;
    private  String ChagedFrom;
    private String ChangedTo;

    public History( int LavelChange,int IdItem,String RowChanged, String ChagedFrom,String ChangedTo){
        super();
//        this.ID=ID;
        this.LavelChange = LavelChange;
        this.IdItem =IdItem;
        this.RowChanged= RowChanged;
        this.ChagedFrom= ChagedFrom;
        this.ChangedTo= ChangedTo;
    }
    public  History(){
//        super();
    }


    public  History get_History_by_id(Connection con, int ID) throws ProjectExeption{
        System.out.println("GETTTTT");
        java.lang.String sql= "Select * from History WHERE ID = "+ID;
        ResultSet rs;
        try {

            Statement stmt = con.createStatement();
            rs= stmt.executeQuery(sql);
//            System.out.println(rs);
        } catch (SQLException e) {
            throw new ProjectExeption("Get the History by ID  faild!!", e);
        }
        return (History) rs;

    }

    public static History get_History_by_type_changed(Connection con, int ProOrMile, int IDChanged) throws ProjectExeption{
        java.lang.String sql= "Select * from History WHERE IDChanged = "+IDChanged ;
        sql +="AND ProjectOrMile= "+ProOrMile;
        ResultSet rs;
        try {

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
//            System.out.println(rs);
        } catch (SQLException e) {
            throw new ProjectExeption("Get the History by ID  faild!!", e);
        }

        return (History) rs;

    }
    public  int getID(){return this.ID;}

    public int get_LavelChange() {
        return LavelChange;
    }

    public int get_IdItem() {
        return IdItem;
    }

    public String RowChanged() {
        return RowChanged;
    }

    public String ChagedFrom() {
        return ChagedFrom;
    }

    public String ChangedTo() {
        return ChangedTo;
    }


}
