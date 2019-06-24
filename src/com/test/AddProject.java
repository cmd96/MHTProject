package com.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.out;

public class AddProject{
    static String name;
    static int pmID;
    static String customer;
    public AddProject(){

    }

    public AddProject(String n, int p, String c) {
        name=n;
        pmID=p;
        customer=c;
    }

    public static void insertProject() throws SQLException, ClassNotFoundException {
        Connection con = SQLConnection.getCon();
        Statement stmt = con.createStatement();

        int i=stmt.executeUpdate("insert into Projects values('"+name+"','"+pmID+"','"+customer+"')");
        if(i>0)
            out.println(name+" project Inserted Successfully");
        else
            out.println(name+" project Insert Unsuccessful");
        con.close();
//        while (rs.next()) {
//        }

    }
}
