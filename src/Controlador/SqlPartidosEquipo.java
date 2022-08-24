/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Gol;
import Modelo.PartidosEquipo;
import static Controlador.SqlPartido.SQL_SELECT;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUNIOR
 */
public class SqlPartidosEquipo {
     public static final String SQL_SELECT = "SELECT * FROM partidos_equipo";

    public static final String SQL_UPDATE = "UPDATE partidos_equipo SET es_local=? WHERE partido_codigo=? AND equipo_codigo=?";

    public static final String SQL_INSERT = "INSERT INTO partidos_equipo (partido_codigo,equipo_codigo,es_local)values(?,?,?);";

    public static final String SQL_ELIMINAR = "DELETE  FROM partidos_equipo WHERE partido_codigo=? AND equipo_codigo=?";
    //pendiente
    public static final String SQL_QUERY = "SELECT * FROM partidos_equipo WHERE partido_codigo=? AND equipo_codigo=?";
    
    
    public static PartidosEquipo consulta(PartidosEquipo pe) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        PartidosEquipo res=null;
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_QUERY);            
            stm.setInt(1, pe.getPartidoCodigo());
            stm.setInt(2, pe.getEquipoCodigo() );
             rs= stm.executeQuery();
             while(rs.next()){
               int pc=rs.getInt(1);
              int ec=rs.getInt(2);
              boolean local= rs.getInt(3)==1?true:false;
             res=new PartidosEquipo(pc,ec,local);
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
    
   
    
    
    public static boolean eliminar(PartidosEquipo pe) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_ELIMINAR);            
           stm.setInt(1, pe.getPartidoCodigo());
            stm.setInt(2, pe.getEquipoCodigo() );
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
    public static boolean actualizar(PartidosEquipo pe) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);    
            stm.setInt(1, (pe.getEsLocal()==true)? 1 : 0);    
            stm.setInt(2, pe.getPartidoCodigo());
            stm.setInt(3, pe.getEquipoCodigo() );
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
    
    
    
    public static boolean registrar(PartidosEquipo pe) {
        Connection conn = null;
        PreparedStatement stm = null;   
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT);           
            stm.setInt(1, pe.getPartidoCodigo());
            stm.setInt(2, pe.getEquipoCodigo() );
            stm.setInt(3, (pe.getEsLocal()==true)? 1 : 0);               
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
    public static List<PartidosEquipo> listar() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<PartidosEquipo> pe=new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs=stm.executeQuery();
            while(rs.next()){
              int pc=rs.getInt(1);
              int ec=rs.getInt(2);
              boolean local= rs.getInt(3)==1?true:false;
             pe.add(new PartidosEquipo(pc,ec,local));
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
       return pe;
     }
}
