/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Equipo;
import Modelo.Gol;
import Modelo.Jugador;
import Modelo.Partido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 
 * @author JUNIOR
 */
public class Consultas {
    //*-- SELECT 'CONSUTA 1';
     public static final String CONSUTA_1= "SELECT nombre, nombre_estadio,anio_fundacion FROM equipo";
     //* -- SELECT 'CONSUTA 2';
    public static final String CONSUTA_2 = "SELECT p.nombre,p.fecha_nacimiento,j.posicion FROM jugador j LEFT JOIN persona p ON p.identificacion=j.identificacion_persona WHERE codigo_equipo=3";
    //* -- SELECT 'CONSUTA 3';
    public static final String CONSUTA_3 = "SELECT codigo, codigo_partido,minuto, descripcion FROM gol WHERE minuto>70 ORDER BY minuto DESC";
    // * -- SELECT 'CONSUTA 4';
    public static final String CONSUTA_4 = " SELECT  p.nombre,p.apellido FROM persona p LEFT JOIN gol g   ON p.identificacion=g.identificacion_jugador where g.codigo_partido=3 ORDER BY g.minuto ASC";
    //* -- SELECT 'CONSUTA 5';
    public static final String CONSUTA_5 = "SELECT COUNT(pq.partido_codigo) FROM partidos_equipo pq INNER JOIN equipo e ON pq.equipo_codigo =e.codigo WHERE e.nombre='Atlético de Madrid' AND pq.es_local=0";
    
     public static final String CONSUTA_6 = "SELECT goles_local, goles_visitante ,fecha FROM partido WHERE fecha <'2021-03-27 00:00:00' ORDER BY fecha DESC";
     
     public static List<Partido> ConsultaSeis() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<Partido> partidos=new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(CONSUTA_6);
            rs=stm.executeQuery();
            while(rs.next()){              
              int gl=rs.getInt(1);
              int gv=rs.getInt(2);
             Date fp= new Date(rs.getTimestamp(3).getTime());             
              
             partidos.add(new Partido(gl,gv,fp));
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

     
     public static Integer ConsultaCinco(){
          Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        int res = 0;
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(CONSUTA_5);  
             rs= stm.executeQuery();
             while(rs.next()){
              int count=rs.getInt(1);                   
             res = count;
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
     
      public static List<Jugador> ConsultaCuatro() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<Jugador> jugadores=new ArrayList<>();
        Jugador j=null;
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(CONSUTA_4);
            rs=stm.executeQuery();
            while(rs.next()){
              String nombre=rs.getString(1);             
             String apellido=rs.getString(2);
                j=new Jugador();
                j.setNombre(nombre);
                j.setApellido(apellido);
             jugadores.add(j);
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
    
     
     
    public static List<Gol> ConsultaTres() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<Gol> goles=new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(CONSUTA_3);
            rs=stm.executeQuery();
            while(rs.next()){
              int codigo=rs.getInt(1);
              int mn=rs.getInt(2);
              int cp= rs.getInt(3); 
              String desc=rs.getString(4);
              
              
             goles.add(new Gol(codigo,cp,mn,desc));
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
     
     
     
    public static List<Jugador> ConsultaDos() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;  
        List<Jugador> jugadores=new ArrayList<>();
        Jugador j=null;
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(CONSUTA_2);
            rs=stm.executeQuery();
            while(rs.next()){
              String nombre=rs.getString(1);             
               Date fecha_nacimiento= new Date(rs.getTimestamp(2).getTime());
              String posicion=rs.getString(3);
             jugadores.add(new Jugador(nombre,fecha_nacimiento,posicion));
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
    
    
    
    public static List<Equipo> ConsultaUno() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs=null;         
        List<Equipo> equipos=new ArrayList<>();
        
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(CONSUTA_1);
            rs=stm.executeQuery();
            while(rs.next()){
            
              String nombre=rs.getString(1);             
              String estadio= rs.getString(2);  
              int ff =rs.getInt(3);
               
              equipos.add(new Equipo(nombre,estadio,ff));
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
