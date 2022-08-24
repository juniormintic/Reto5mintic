/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DirectorTecnico;
import Modelo.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUNIOR
 */
public class SqlDirectorTecnico {
    
    public static final String SQL_SELECT ="SELECT identificacion_persona,nombre,apellido,fecha_nacimiento,mes_contrato,anio_contrato FROM director_tecnico JOIN persona ON identificacion=identificacion_persona"; 
    public static final String SQL_UPDATE="UPDATE director_tecnico dr  INNER JOIN persona p ON p.identificacion=dr.identificacion_persona SET p.nombre=?,p.apellido=?,p.fecha_nacimiento=?,dr.mes_contrato=?,dr.anio_contrato=? WHERE identificacion_persona=?";
    public static final String SQL_INSERT="INSERT INTO director_tecnico (identificacion_persona,mes_contrato,anio_contrato)values(?,?,?);";

    public static final String SQL_ELIMINAR="DELETE FROM director_tecnico  WHERE identificacion_persona=?";
    
     public static final String SQL_CONSULTA="SELECT identificacion_persona,nombre,apellido,fecha_nacimiento,mes_contrato,anio_contrato FROM director_tecnico JOIN persona ON identificacion=identificacion_persona";
    
    public static DirectorTecnico consulta(DirectorTecnico dr) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        DirectorTecnico di=null;
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_CONSULTA);
            rs=stm.executeQuery();
            while(rs.next()){
              String identificacion=rs.getString(1);
              String nombre=rs.getString(2);
              String apellido=rs.getString(3);
               Date fecha_nacimiento= new Date(rs.getTimestamp(4).getTime());
              int mesContrato=rs.getInt(5);
              int anioContrato=rs.getInt(6);                           
              di=new DirectorTecnico(identificacion,nombre,apellido,fecha_nacimiento,mesContrato,anioContrato);
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
       return di;
     }
    
    
    public static boolean eliminar(DirectorTecnico dr) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            String id=dr.getIdentificacion(); 
            Persona pp=new Persona(id);
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_ELIMINAR);            
            stm.setString(1, dr.getIdentificacion());
            stm.execute();            
            
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
    public static boolean actualizar(DirectorTecnico dr) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setString(1, dr.getNombre());
            stm.setString(2, dr.getApellido());
            stm.setTimestamp(3, new Timestamp(dr.getFecha_nacimiento().getTime()));  
            stm.setInt(4, dr.getMesContrato());
            stm.setInt(5, dr.getAnioContrato());
            stm.setString(6, dr.getIdentificacion());
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
    
    
    
    public static boolean registrar(DirectorTecnico dr) {
        Connection conn = null;
        PreparedStatement stm = null;     
        String id=dr.getIdentificacion();
        String nom=dr.getNombre();
        String ap=dr.getApellido();
        java.util.Date fn=dr.getFecha_nacimiento();
        
       
        try {
             Persona pp=new Persona(id,nom,ap,fn); 
             SqlPersona.registrar(pp);
             
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT);           
             stm.setString(1, dr.getIdentificacion());
            stm.setInt(2, dr.getMesContrato());
            stm.setInt(3, dr.getAnioContrato());
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
    
    
    
    
    public static List<DirectorTecnico> listar() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<DirectorTecnico> directores=new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs=stm.executeQuery();
            while(rs.next()){
              String identificacion=rs.getString(1);
              String nombre=rs.getString(2);
              String apellido=rs.getString(3);
               Date fecha_nacimiento= new Date(rs.getTimestamp(4).getTime());
              int mesContrato=rs.getInt(5);
              int anioContrato=rs.getInt(6);                           
              directores.add(new DirectorTecnico(identificacion,nombre,apellido,fecha_nacimiento,mesContrato,anioContrato));
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
       return directores;
     }
    
}
