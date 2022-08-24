/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DirectorTecnico;
import Modelo.Jugador;
import Modelo.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author JUNIOR
 */
public class  SqlPersona {
    public static final String SQL_SELECT ="SELECT * FROM persona ORDER BY identificacion desc";
    public static final String SQL_INSERT="INSERT INTO persona (identificacion,nombre,apellido,fecha_nacimiento)values(?,?,?,?)";
    public static final String SQL_UPDATE="UPDATE persona SET nombre=?,apellido=?,fecha_nacimiento=? WHERE identificacion=?";
    public static final String SQL_ELIMINAR="DELETE FROM persona  WHERE identificacion=?";
    public static final String SQL_CONSULTA ="SELECT * FROM persona WHERE identificacion =?";
    
    
    public static Persona consulta(Persona ps) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;          
        Persona persona=null;
        try{
            conn = Conexion.getConnection();
             stm = conn.prepareStatement(SQL_CONSULTA);
             stm.setString(1, ps.getIdentificacion());
            rs=stm.executeQuery();
            while(rs.next()){
              String identificacion=rs.getString(1);
              String nombre=rs.getString(2);
              String apellido=rs.getString(3);
              Date fecha_nacimiento= new Date(rs.getTimestamp(4).getTime());
              persona=new Persona(identificacion,nombre,apellido,fecha_nacimiento);
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
       return persona;
     }
    
    
    
    public static boolean eliminar(Persona ps) {
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
           
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_ELIMINAR);            
            stm.setString(1, ps.getIdentificacion());
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
    public  static boolean actualizar(Persona ps) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setString(1, ps.getNombre());
            stm.setString(2, ps.getApellido());
            stm.setTimestamp(3, new Timestamp(ps.getFecha_nacimiento().getTime()));  
            stm.setString(4, ps.getIdentificacion());
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
    
    
    
    public static boolean registrar(Persona ps) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT);
            stm.setString(1, ps.getIdentificacion());
            stm.setString(2, ps.getNombre());
            stm.setString(3, ps.getApellido());
            stm.setTimestamp(4, new Timestamp(ps.getFecha_nacimiento().getTime()));           
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
    
    
    
    
    public static List<Persona> listar() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<Persona> personas=new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs=stm.executeQuery();
            while(rs.next()){
              String identificacion=rs.getString(1);
              String nombre=rs.getString(2);
              String apellido=rs.getString(3);
              Date fecha_nacimiento= new Date(rs.getTimestamp(4).getTime());
              personas.add(new Persona(identificacion,nombre,apellido,fecha_nacimiento));
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
       return personas;
     }
    
   
        
    
}
