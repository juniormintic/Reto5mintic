/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Gol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @author JUNIOR
 */
public class SqlGol {
    public static final String SQL_SELECT = "SELECT * FROM gol";

    public static final String SQL_UPDATE = "UPDATE gol SET minuto=?,descripcion=? ,codigo_partido=?  ,identificacion_jugador=? WHERE codigo=?";

    public static final String SQL_INSERT = "INSERT INTO gol(codigo,minuto,descripcion,codigo_partido,identificacion_jugador)values(?,?,?,?,?);";

    public static final String SQL_ELIMINAR = "DELETE FROM gol  WHERE codigo=?";
    //pendiente
    public static final String SQL_QUERY = "SELECT * FROM gol WHERE codigo=?";
    
    
    public static Gol consulta(Gol gl) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        Gol res=null;
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_QUERY);            
            stm.setInt(1, gl.getCodigo());
             rs= stm.executeQuery();
             while(rs.next()){
              int codigo=rs.getInt(1);
              int mn=rs.getInt(2);
              String desc=rs.getString(3);
              int cp= rs.getInt(4); 
              String id=rs.getString(5);         
             res =new Gol(codigo,mn,desc,cp,id);
            }
                      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);           
        } finally {
            try {
                rs.close();
               stm.close();
               conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return res;
    }
    
   
    
    
    public static boolean eliminar(Gol gl) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_ELIMINAR);            
            stm.setInt(1, gl.getCodigo());
            stm.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        } finally {

            try {
               stm.close();
               conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

    }
    public static boolean actualizar(Gol gl) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);           
            stm.setInt(1, gl.getMinuto() );
            stm.setString(2, gl.getDescripcion());
            stm.setInt(3, gl.getCodPartido());
            stm.setString(4, gl.getJugador() );     
             stm.setInt(5, gl.getCodigo());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        } finally {

            try {
               stm.close();
               conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

    }
    
    
    
    public static boolean registrar(Gol gl) {
        Connection conn = null;
        PreparedStatement stm = null;   
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT);           
            stm.setInt(1, gl.getCodigo());
            stm.setInt(2, gl.getMinuto() );
            stm.setString(3, gl.getDescripcion());
            stm.setInt(4, gl.getCodPartido());
            stm.setString(5, gl.getJugador() );           
            stm.execute();          
               return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        } finally {

            try {
               stm.close();
               conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

    }
    
    
    
    
    public static List<Gol> listar() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<Gol> goles=new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs=stm.executeQuery();
            while(rs.next()){
              int codigo=rs.getInt(1);
              int mn=rs.getInt(2);
              String desc=rs.getString(3);
              int cp= rs.getInt(4); 
              String id=rs.getString(5);
              
             goles.add(new Gol(codigo,mn,desc,cp,id));
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        } finally {

            try {
               rs.close();
               stm.close();
               conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       return goles;
     }
}
