/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Jugador;
import Modelo.Persona;
import java.sql.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUNIOR
 */
public class SqlJugador {
    public static final String SQL_SELECT ="SELECT p.identificacion,p.nombre,p.apellido,p.fecha_nacimiento,j.posicion,j.codigo_equipo,e.nombre FROM jugador j JOIN persona p ON identificacion=identificacion_persona JOIN equipo e ON e.codigo=j.codigo_equipo"; 
   
    public static final String SQL_UPDATE="UPDATE jugador j  INNER JOIN persona p ON p.identificacion=j.identificacion_persona SET p.nombre=?,p.apellido=?,p.fecha_nacimiento=?,j.posicion=?,j.codigo_equipo=? WHERE identificacion_persona=?";
    
    public static final String SQL_INSERT="INSERT INTO jugador (identificacion_persona,posicion,codigo_equipo)values(?,?,?);";

    public static final String SQL_ELIMINAR="DELETE FROM jugador  WHERE identificacion_persona=?";
    
     public static final String SQL_QUERY="SELECT p.identificacion,p.nombre,p.apellido,p.fecha_nacimiento,j.posicion,j.codigo_equipo,e.nombre FROM jugador j JOIN persona p ON identificacion=identificacion_persona JOIN equipo e ON e.codigo=j.codigo_equipo WHERE identificacion_persona=? ";
    
    
    public static Jugador consulta(Jugador jg) {
        Connection conn = null;
        PreparedStatement stm = null;
         ResultSet rs=null;  
        Jugador res=null;
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_QUERY);            
            stm.setString(1, jg.getIdentificacion());
             rs= stm.executeQuery();
             while(rs.next()){
              String identificacion=rs.getString(1);
              String nombre=rs.getString(2);
              String apellido=rs.getString(3);
             Date fecha_nacimiento= new Date(rs.getTimestamp(4).getTime());
              String posicion=rs.getString(5);
              int codigoEq=rs.getInt(6);         
              String nombreEq= rs.getString(7);
             res =new Jugador(identificacion,nombre,apellido,fecha_nacimiento,posicion,codigoEq,nombreEq);
            }
                      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
           
        } finally {

            try {
               stm.close();
               conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return res;
    }
    
    
    
    
    public static boolean eliminar(Jugador jg) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_ELIMINAR);            
            stm.setString(1, jg.getIdentificacion());
            stm.execute();
            
            String id=jg.getIdentificacion();  
            Persona pp=new Persona(id);
            SqlPersona.eliminar(pp);
            
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
    public static boolean actualizar(Jugador jg) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setString(1, jg.getNombre());
            stm.setString(2, jg.getApellido());
            stm.setTimestamp(3, new Timestamp(jg.getFecha_nacimiento().getTime()));         
            stm.setString(4, jg.getPosicion());
            stm.setInt(5, jg.getCodigoEquipo());
            stm.setString(6, jg.getIdentificacion());
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
    
    
    
    public static boolean registrar(Jugador jg) {
        Connection conn = null;
        PreparedStatement stm = null;     
        String id=jg.getIdentificacion();
        String nom=jg.getNombre();
        String ap=jg.getApellido();
       
        java.util.Date fn=jg.getFecha_nacimiento();
        
       
        try {
             Persona pp=new Persona(id,nom,ap,fn); 
             SqlPersona.registrar(pp);
             
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT);           
            stm.setString(1, jg.getIdentificacion());
            stm.setString(2, jg.getPosicion());
            stm.setInt(3, jg.getCodigoEquipo());
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
    
    
    
    
    public static List<Jugador> listar() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<Jugador> jugadores=new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs=stm.executeQuery();
            while(rs.next()){
              String identificacion=rs.getString(1);
              String nombre=rs.getString(2);
              String apellido=rs.getString(3);
              Date fecha_nacimiento= new Date(rs.getTimestamp(4).getTime());
              String posicion=rs.getString(5);
              int codigoEq=rs.getInt(6);         
              String nombreEq= rs.getString(7);
             jugadores.add(new Jugador(identificacion,nombre,apellido,fecha_nacimiento,posicion,codigoEq,nombreEq));
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
       return jugadores;
     }
}
