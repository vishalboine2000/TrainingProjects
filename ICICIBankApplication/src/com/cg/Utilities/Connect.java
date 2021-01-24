package com.cg.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	Connection con=null;
    public static Connection ConnectDB(){
    try{
            Class.forName("java.sql.Driver");
            String database = "jdbc:mysql://localhost:3306/bank_db";
            Connection con = DriverManager.getConnection(database, "root", "Vishal90040");
            return con;
        }
        catch(ClassNotFoundException | SQLException e) {
        return null;
    }      
}

}
