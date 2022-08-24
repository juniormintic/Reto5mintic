/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author JUNIOR
 */
import java.sql.*;
public  class Conexion {
     
      private static final String user="root";
      private static final String password="escorpion920124";
      private static final String jdbcUrl ="jdbc:mysql://localhost:3306/torneo";
     // private static final Connection conn = null;  
      
     public static Connection getConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcUrl, user, password);
            if (conn != null) {
              //  System.out.println("conexion exitosa");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return conn;
    }
}
    

