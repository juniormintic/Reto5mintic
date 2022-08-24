/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partido;
import Modelo.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * UPDATE equipo SET nombre_estadio="Wanda" WHERE codigo=3;


UPDATE partido SET fecha="2021-04-01 20:00:00" WHERE codigo=4;

DELETE FROM jugador WHERE identificacion_jugador='0009';
DELETE FROM persona WHERE identificacion='0009';
 * 
 * @author JUNIOR
 */
public class Modificaciones {
   // SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
     public void modificaciones(){
     /*actualizar nombre de estadio*/
       Equipo eq= new Equipo(3);
       Equipo re= SqlEquipo.consulta(eq);    
       re.setEstadio("Wanda");   
       boolean rr=SqlEquipo.actualizar(re);
       System.out.println("Se modifico el estadio"+rr);
       /*actualizar fecha de partido*/
       
         Partido pt=new Partido(4);
         Partido res= SqlPartido.consulta(pt); 
         res.setFecha("2021-04-01 20:00:00");           
         boolean fg=  SqlPartido.actualizar(res);
         System.out.println("se modifico la fecha del partido codigo 4"+fg);
       
        /*Eliminar jugador y de tabla persona */
        Jugador persona=new Jugador("0009");
        boolean jd=SqlJugador.eliminar(persona);
         System.out.println("Se elimino el jugador 0009"+jd);
     }
     
     
     
}
