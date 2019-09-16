package com.test;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.out;

public class AddProduct {

    static String name;
    static int rwID,projID;
    public AddProduct(){

    }
    public AddProduct(String n, int r, int p) {
        name=n;
        rwID=r;
        projID=p;
    }

    public static void insertProduct() throws SQLException, ClassNotFoundException {
        Connection con = SQLConnection.getCon();
        Statement stmt = con.createStatement();

        int i=stmt.executeUpdate("insert into Products values('"+name+"','"+projID+"','"+rwID+"')");
        if(i>0)
            out.println(name+" product Inserted Successfully");
        else
            out.println(name+" product Insert Unsuccessful");
        con.close();
//        while (rs.next()) {
//        }

    }
}
