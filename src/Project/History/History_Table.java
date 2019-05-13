package Project.History;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.lang.String;
import Project.exception.ProjectExeption;

public class History_Table {
        private int Level_Change;    //LC=1->change in Project , LC=2->change in mileStopn
        private int ID;             //if LC=1->  ID= IS PROJECT_ID ; if ID=2-> IS MILESton_id
        private String proparties_Change;
        private Date DateChange;
        private int User_Change;



    public History_Table(int Level_Change, int ID, String proparties_Change,Date DateChange, int User_Change){
        super();
        this.Level_Change=Level_Change;
        this.ID=ID;
        this.proparties_Change=proparties_Change;
        this.DateChange=DateChange;
        this.User_Change=User_Change;

//        public History_Table(){
//        //    super();
//            }

}


    }
