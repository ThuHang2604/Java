/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hang.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hoa Doan
 */
//public class DBUtils {
//    public static Connection getConnection() throws ClassNotFoundException, SQLException{
//        Connection conn= null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url= "jdbc:sqlserver://localhost:1433;databaseName=Assigment";
//        conn= DriverManager.getConnection(url, "sa", "12345");
//        return conn;
//    }
//}

public class DBUtils implements Serializable {
    public static Connection makeConnection() {
        try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          String url = "jdbc:sqlserver://localhost:1433;databaseName=Assigment;user=sa;password=12345";
          Connection con = DriverManager.getConnection(url, "sa", "12345");
          return con;
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}