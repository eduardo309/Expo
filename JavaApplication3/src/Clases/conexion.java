/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.*;

public class conexion {

     private Connection cn;
    
    public Connection conexion() {
        {
        cn = null;
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://EDUARDO\\SQLEXPRESS;databaseName=Expo_2;integratedSecurity=true;");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Hay una error en la conexion");
        }
        return cn;
        }
    }

    Connection conectar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
