package History;

public class History {
    private int ID;
    private int ProjectOrMile; //if ==1-> become from Project if==2-> become from milesston
    private int IDChanged;
    private String RowChanged;
    private  String CFrom;
    private String CTo;

    public History(int ID, int ProjectOrMileID,int IDChanged,String RowChanged, String CFrom,String CTo){
        super();
        this.ID=ID;
        this.ProjectOrMile = ProjectOrMile;
        this.IDChanged =IDChanged;
        this.RowChanged= RowChanged;
        this.CFrom= CFrom;
        this.CTo= CTo;
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

    public int getProjectOrMile() {
        return ProjectOrMile;
    }

    public int getIDChanged() {
        return IDChanged;
    }

    public String getRowChanged() {
        return RowChanged;
    }

    public String getCFrom() {
        return CFrom;
    }

    public String getCTo() {
        return CTo;
    }


}
