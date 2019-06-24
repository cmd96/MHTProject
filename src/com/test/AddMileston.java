package com.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.out;

public class AddMileston {
    static String name;
    static int rwID,projID;
    public AddMileston(){

    }
    public AddMileston(String n, int r, int p) {
        name=n;
        rwID=r;
        projID=p;
    }

    public static void insertMileston() throws SQLException, ClassNotFoundException {
        Connection con = SQLConnection.getCon();
        Statement stmt = con.createStatement();

        int i=stmt.executeUpdate("insert into Milestons values('"+name+"','"+projID+"','"+rwID+"')");
        if(i>0)
            out.println(name+" mileston Inserted Successfully");
        else
            out.println(name+" mileston Insert Unsuccessful");
        con.close();


    }
}
