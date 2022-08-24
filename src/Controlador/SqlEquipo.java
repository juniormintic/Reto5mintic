/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Equipo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUNIOR
 */
public class SqlEquipo {
    public static final String SQL_SELECT ="SELECT * FROM equipo";
    public static final String SQL_INSERT="INSERT INTO equipo (codigo,nombre,ciudad,nombre_estadio,anio_fundacion,identificacion_dr_tecnico)values(?,?,?,?,?,?)";
    public static final String SQL_UPDATE="UPDATE equipo SET codigo=?,nombre=?,ciudad=?,nombre_estadio=?,anio_fundacion=?,identificacion_dr_tecnico=? WHERE codigo=?";
    public static final String SQL_ELIMINAR="DELETE FROM equipo WHERE codigo=?";
    public static final String SQL_CONSULTA ="SELECT * FROM equipo WHERE codigo=?";
    
     public static Equipo consulta(Equipo eq) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        Equipo res=null;
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_CONSULTA);
             stm.setInt(1, eq.getCodigo());
            rs=stm.executeQuery();
            while(rs.next()){
              int codigo=rs.getInt(1);
              String nombre=rs.getString(2);
              String ciudad=rs.getString(3);
              String estadio= rs.getString(4);  
              int ff =rs.getInt(5);
              String idTec = rs.getString(6);
            res= new Equipo(codigo,nombre,ciudad,estadio,ff,idTec);
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
       return res;
     }
    
    
    public static boolean eliminar(Equipo eq) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_ELIMINAR);            
            stm.setInt(1, eq.getCodigo());
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
    public  static boolean actualizar(Equipo eq) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setInt(1, eq.getCodigo());
            stm.setString(2, eq.getNombre());
            stm.setString(3, eq.getCiudad());
            stm.setString(4,  eq.getEstadio());
            stm.setInt(5, eq.getAnioFundado());
            stm.setString(6, eq.getIdentificacionTecnico());
             stm.setInt(7, eq.getCodigo());
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
    
    
    
    public static boolean registrar(Equipo eq) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT);
            stm.setInt(1, eq.getCodigo());
            stm.setString(2, eq.getNombre());
            stm.setString(3, eq.getCiudad());
            stm.setString(4,  eq.getEstadio());
            stm.setInt(5, eq.getAnioFundado());
            stm.setString(6, eq.getIdentificacionTecnico());
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
    
    
    
    
    public static List<Equipo> listar() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<Equipo> equipos=new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs=stm.executeQuery();
            while(rs.next()){
              int codigo=rs.getInt(1);
              String nombre=rs.getString(2);
              String ciudad=rs.getString(3);
              String estadio= rs.getString(4);  
              int ff =rs.getInt(5);
              String idTec = rs.getString(6);
              equipos.add(new Equipo(codigo,nombre,ciudad,estadio,ff,idTec));
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
       return equipos;
     }
}
