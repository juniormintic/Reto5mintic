/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DirectorTecnico;
import Modelo.Equipo;
import Modelo.Gol;
import Modelo.Jugador;
import Modelo.Partido;
import Modelo.PartidosEquipo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JUNIOR
 */
public class Inserciones {
    
    public static Date formatoHora(String st){
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");       
       Date d=null;
         try {
             d = sdf.parse(st);
           
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
        }
     return d;
    }
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
    public static void InsertDatos(){
   
        List<DirectorTecnico> dts= new ArrayList<>();
        dts.add(new DirectorTecnico("123456","Ronald","Koeman",formato("1963-03-21"),8,2020));
        dts.add(new DirectorTecnico("123457","Carlo","Ancelotti",formato("1959-06-10"),6,2021));
        dts.add(new DirectorTecnico("123458","Diego","Simeone",formato("1970-04-28"),1,2012));
        dts.add(new DirectorTecnico("123459","José","Bordalás",formato("1964-03-05"),6,2021));
        
        for(DirectorTecnico tc:dts){
           SqlDirectorTecnico.registrar(tc);
        }
       
        
        List<Equipo> eq=new ArrayList<>();
        eq.add(new Equipo(1,"Barcelona","Barcelona","Camp Nou",1899,"123456"));
        eq.add(new Equipo(2,"Real Madrid","Madrid","Santiago Bernabeu",1902,"123457"));
        eq.add(new Equipo(3,"Atlético de Madrid","Madrid","Wanda",1903,"123458"));
        eq.add(new Equipo(4,"Valencia","Valencia","Mestalla",1919,"123459"));
        for(Equipo e:eq){
            SqlEquipo.registrar(e);
        }
   
        List<Jugador> js = new ArrayList<>();
        js.add(new Jugador("0000", "Marc-Andre", "ter Stegen", formato("1992-04-30"), "Portero", 1));
        js.add(new Jugador("0001", "Gerard", "Piqué", formato("1987-02-02"), "Defensa", 1));
        js.add(new Jugador("0002", "Sergio", "Busquets", formato("1988-07-16"), "Mediocampista", 1));
        js.add(new Jugador("0003", "Antoine", "Griezmann", formato("1991-03-21"), "Delantero", 1));

        js.add(new Jugador("0004", "Thibaut", "Courtois", formato("1992-05-11"), "Portero", 2));
        js.add(new Jugador("0005", "Dani", "Carvajal", formato("1992-01-11"), "Defensa", 2));
        js.add(new Jugador("0006", "Toni", "Kroos", formato("1990-01-04"), "Mediocampista", 2));
        js.add(new Jugador("0007", "Karim", "Benzema", formato("1987-12-19"), "Delantero", 2));

        js.add(new Jugador("0008", "Jan", "Oblak", formato("1993-01-07"), "Portero", 3));
        js.add(new Jugador("0009", "Santiago", "Arias", formato("1992-01-13"), "Defensa", 3));
        js.add(new Jugador("0010", "Koke", "Resurrección", formato("1992-01-08"), "Mediocampista", 3));
        js.add(new Jugador("0011", "Luis", "Suarez", formato("1987-01-24"), "Delantero", 3));

        js.add(new Jugador("0012", "Jasper", "Cillesen", formato("1989-04-22"), "Portero", 4));
        js.add(new Jugador("0013", "Gabriel", "Paulista", formato("1990-11-26"), "Defensa", 4));
        js.add(new Jugador("0014", "Carlos", "Soler", formato("1997-01-02"), "Mediocampista", 4));
        js.add(new Jugador("0015", "Maximiliano", "Gómez", formato("1996-08-14"), "Delantero", 4));
        
        for(Jugador j:js){
            SqlJugador.registrar(j);
        }
        
       
        List<Partido> ps = new ArrayList<>();
        ps.add(new Partido(0, 1, 2, formatoHora("2021-03-25 20:00:00")));
        ps.add(new Partido(1, 2, 0, formatoHora("2021-03-26 20:00:00")));
        ps.add(new Partido(2, 1, 0, formatoHora("2021-03-27 18:00:00")));
        ps.add(new Partido(3, 2, 1, formatoHora("2021-03-28 20:00:00")));
        ps.add(new Partido(4, 0, 0, formatoHora("2021-03-26 16:00:00")));
        for (Partido p : ps) {
            SqlPartido.registrar(p);
        }
        
       
        
        List<PartidosEquipo> pe = new ArrayList<>();
        pe.add(new PartidosEquipo(0, 1, true));
        pe.add(new PartidosEquipo(0, 2, false));
        
        pe.add(new PartidosEquipo(1, 3, true));
        pe.add(new PartidosEquipo(1, 4, false));
        
        pe.add(new PartidosEquipo(2, 4, true));
        pe.add(new PartidosEquipo(2, 2, false));
        
        pe.add(new PartidosEquipo(3, 1, true));
        pe.add(new PartidosEquipo(3, 3, false));
        
        pe.add(new PartidosEquipo(4, 2, true));
        pe.add(new PartidosEquipo(4, 3, false));
        
        for (PartidosEquipo pp : pe) {
            SqlPartidosEquipo.registrar(pp);
        }
       
        List<Gol> gls = new ArrayList<>();
        gls.add(new Gol(1,15,"Penalti",0,"0003"));
        gls.add(new Gol(2,20,"Tiro libre",0,"0007"));
        gls.add(new Gol(3,85,"Cabeza",0,"0006"));
        gls.add(new Gol(1,70,"Remate larga distancia",1,"0011"));
        gls.add(new Gol(2,84,"Penalti",1,"0011"));
        gls.add(new Gol(1,50,"Tiro libre",2,"0015"));
        gls.add(new Gol(1,43,"Penalti",3,"0010"));
        gls.add(new Gol(2,55,"Remate larga distancia",3,"0002"));
        gls.add(new Gol(3,81,"Tiro libre",3,"0003"));
         
        
        for (Gol g : gls) {
            SqlGol.registrar(g);
        }
        
        
    }
    
}
