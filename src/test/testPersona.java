/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import Controlador.Consultas;
import Controlador.Inserciones;
import Controlador.Modificaciones;
import Modelo.DirectorTecnico;
import Modelo.Equipo;
import Modelo.Gol;
import Modelo.Jugador;
import Modelo.Partido;
import Controlador.SqlPersona;
import Modelo.Persona;
import Controlador.SqlDirectorTecnico;
import Controlador.SqlEquipo;
import Controlador.SqlGol;
import Controlador.SqlJugador;
import Controlador.SqlPartido;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author JUNIOR
 */
public class testPersona {

    /**
     * @param args the command line arguments
     */
    
    /*
        Identificacion: 123459
        Nombre: José    migel
        Apellido: Bordalás
        Fecha de nacimiento: 1964-03-05
    */
     public static Date formato(String st){
    
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");       
       Date d=null;
         try {
             d = sdf.parse(st);
           
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
        }
     return d;
    }
   // public static void main(String[] args) throws ParseException {
        // TODO code application logic here
         //  Jugador persona=new Jugador("0009");
         //  SqlJugador.eliminar(persona);
         
         
         
 
         //  Date d=formato("2021-03-25 20:00:00");
       //    Partido p = new Partido(0,1,2,d);
       //    System.out.println("hola");
       //     p.Imprimir();
         // Equipo eq= new Equipo(3);
         //    Equipo re= SqlEquipo.consulta(eq);
          //       re.setEstadio("Wanda");   
      //  SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      //  Date d=sdf.parse("2021-04-01");
      ///   Partido pt=new Partido(4);
      //   Partido pr = new Partido(0,1,2,d);
     //    System.out.println(pr.Imprimir());
      //  List<Partido> res= SqlPartido.listar();
        
       // for(Partido p:res){
       //  System.out.println(p.Imprimir());
       // }
       
         
         
       //     res.setFecha("2021-04-01 20:00:00");
       //     System.out.println(res.Imprimir());
       //   boolean fg=  SqlPartido.actualizar(res);
       //   System.out.println(fg);
      
         
        
        
       
         Persona ps= new Persona("102569","pepito","perez",formato("1999-03-01")); 
         // SqlPersona.eliminar(ps);
        // List<Persona> personas= SqlPersona.listar();
       //  for (Persona pe:personas) {
       //      System.out.println(pe.imprimir());
            
       // }
       // String r= ps.imprimir();
       // System.out.println(r);
       //  DirectorTecnico dr =new DirectorTecnico("999999");
       //  SqlDirectorTecnico.eliminar(dr);
       // System.out.println(resdt.imprimir());
        
     // List<  DirectorTecnico >ress= SqlDirectorTecnico.listar();
      //  for( DirectorTecnico d:ress){
      //      System.out.println(d.imprimir());
      //  }
        //  List<Persona> personas= SqlPersona.listar();
       //  for (Persona pe:personas) {
       //      System.out.println(pe.imprimir());
            
       // }
       // Date fecha = new Date("1964/03/05");
       //       System.out.println(fecha);
       
        // DirectorTecnico drr =new DirectorTecnico("999999","pedroto","perez","1999-03-05",2,2000);
        // boolean dres= SqlDirectorTecnico.registrar(drr);
       // System.out.println(dres);
       
      // String rr =cps.registrar(ps);
       // System.out.println(rr);
       
     //  Equipo eq=new Equipo(4);
    ////   Equipo res= SqlEquipo.consulta(eq);
    //    System.out.println(res.imprimir());
       //List<Equipo> equipos= SqlEquipo.listar();
       // for(Equipo equipo: equipos){     
       //    System.out.println(equipo.imprimir());
       //}
        
       
       
       
       // Jugador ju=new Jugador("0000");
       // Jugador rrrrr= SqlJugador.consulta(ju);
       // System.out.println(rrrrr.imprimir());
      // List<Jugador> jugadores= SqlJugador.listar();
      //  for(Jugador jugador: jugadores){     
      //     System.out.println(jugador.imprimir());
       // }
        /*primero eliminar director tecnico por la key foranea*/
        //Persona pss= new Persona("102569");        
       // String res= cps.eliminar(pss);
       // System.out.println(res);
        //String res= cps.actualizar(ps);
       /// System.out.println(res);
       
      
       /*
       Identificacion: 0015
        Nombre: Maximiliano
        Apellido: Gómez
        Fecha de nacimiento: 1996-08-14
        Posicion: Delantero
        Codigo Equipo: 4
        Nombre Equipo: Valencia
       */
       
       /*partido*/
       //Partido ptc=new Partido(10,3,3, new Date(120,02,03));
        // SqlPartido.registrar(ptc);
       // SqlPartido.actualizar(ptc);
       // Partido res=   SqlPartido.consulta(ptc);
        //System.out.println(res.Imprimir());
       //SqlPartido.eliminar(ptc);
       /*listar partidos*/
      // List<Partido> partidos= SqlPartido.listar();
      //  for (Partido pt : partidos) {
      //      System.out.println(pt.Imprimir());
      // }
       
       
       
      //  Gol gol=new Gol(4,71,"pecho",0,"0006");
        // SqlGol.registrar(gol);
        //SqlGol.actualizar(gol);
        //Gol res=   SqlGol.consulta(gol);
       // System.out.println(res.Imprimir());
    //   SqlGol.eliminar(gol);
       /*listar goles*/
     // List<Gol> gls= SqlGol.listar();
     //  for (Gol gl : gls) {
     //       System.out.println(gl.Imprimir());
     //  }
       
     
     /*consultas*/
    // List<Equipo> eq = Consultas.ConsultaUno();
    // for (Equipo equipo:eq){
    //     System.out.println(equipo.imprimir());
     
    // }
    //  List<Jugador> j = Consultas.ConsultaDos();
    // for (Jugador equipo:j){
    //     System.out.println(equipo.imprimir());
     
    // }
     // List<Gol> g = Consultas.ConsultaTres();
     //for (Gol equipo:g){
     //    System.out.println(equipo.imprimir());
     
     //}
     //  List<Jugador> j = Consultas.ConsultaCuatro();
    /// for (Jugador equipo:j){
     //    System.out.println(equipo.imprimir());
     
    //}
    
    // int i= Consultas.ConsultaCinco();
    //    System.out.println(i);
    
     //  List<Partido> p = Consultas.ConsultaSeis();
    // for (Partido pp:p){
     //    System.out.println(pp.Imprimir());    
    // }
     
     
 //   }
   
}
