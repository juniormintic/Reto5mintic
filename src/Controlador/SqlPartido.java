/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Partido;
import java.sql.*;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUNIOR
 */
public class SqlPartido {
     public static final String SQL_SELECT ="SELECT codigo,goles_local,goles_visitante ,fecha FROM partido";
   
    public static final String SQL_UPDATE="UPDATE partido SET goles_local=?,goles_visitante=? ,fecha=?  WHERE codigo=?";
    
    public static final String SQL_INSERT="INSERT INTO partido(codigo,goles_local,goles_visitante,fecha)values(?,?,?,?);";

    public static final String SQL_ELIMINAR="DELETE FROM partido  WHERE codigo=?";
    //pendiente
     public static final String SQL_QUERY="SELECT codigo,goles_local,goles_visitante ,fecha FROM partido WHERE codigo=?";
    
    
    public static Partido consulta(Partido pt) {
        // (Date) rs.getDate(4);
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        Partido res=null;
        try {
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_QUERY);            
            stm.setInt(1, pt.getCodigo());
             rs= stm.executeQuery();
             while(rs.next()){
              int codigo=rs.getInt(1);
              int gl=rs.getInt(2);
              int gv=rs.getInt(3);
              Date fp= new Date(rs.getTimestamp(4).getTime());   
             res =new Partido(codigo,gl,gv,fp);
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
    
   
    
    
    public static boolean eliminar(Partido pt) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_ELIMINAR);            
            stm.setInt(1, pt.getCodigo());
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
    public static boolean actualizar(Partido pt) {
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            //Timestamp timestamp = new Timestamp(pt.getFecha().getTime());
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
           
            stm.setInt(1, pt.getGolLocal() );
            stm.setInt(2, pt.getGolVisitanet());
            stm.setTimestamp(3, new Timestamp(pt.getFecha().getTime()));
            stm.setInt(4, pt.getCodigo());
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
    
    
    
    public static boolean registrar(Partido pt) {
        Connection conn = null;
        PreparedStatement stm = null;   
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT);           
            stm.setInt(1, pt.getCodigo());
            stm.setInt(2, pt.getGolLocal() );
            stm.setInt(3, pt.getGolVisitanet());
            stm.setTimestamp(4, new Timestamp(pt.getFecha().getTime()));
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
    
    
    
    
    public static List<Partido> listar() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<Partido> partidos=new ArrayList<>();
        
        try{
          SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs=stm.executeQuery();
            while(rs.next()){
              int codigo=rs.getInt(1);
              int gl=rs.getInt(2);
              int gv=rs.getInt(3);
              Date fp= new Date(rs.getTimestamp(4).getTime());     
             partidos.add(new Partido(codigo,gl,gv,fp));
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
       return partidos;
     }

}
