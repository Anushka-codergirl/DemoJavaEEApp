package code;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Class to initialize DB Connection
public class DatabaseConnection {

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
    //Initialize all information - DB Connection
        
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        String dbName = "demoprj";
        String dbUsername ="root";
        String dbPassword = "anushka@1107";
        
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName , dbUsername, dbPassword);
        
        return con;
                
    }
}
