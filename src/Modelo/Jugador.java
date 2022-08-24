/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JUNIOR
 */
public class Jugador extends Persona{
    private String posicion;
    private int codigoEquipo;
    private String nombreEquipo;

    public Jugador( String identificacion, String nombre, String apellido, Date fecha_nacimiento,String posicion, int codigoEquipo) {
        super(identificacion, nombre, apellido, fecha_nacimiento);
        this.posicion = posicion;
        this.codigoEquipo = codigoEquipo;
    }
     public Jugador( String identificacion, String nombre, String apellido, Date fecha_nacimiento,String posicion, int codigoEquipo,String nombreEquipo) {
        super(identificacion, nombre, apellido, fecha_nacimiento);
        this.posicion = posicion;
        this.codigoEquipo = codigoEquipo;
        this.nombreEquipo=nombreEquipo;
    }

    public Jugador(String identificacion) {
        super(identificacion);
    }

    public Jugador( String nombre, Date fecha_nacimiento ,String posicion) {
        super(nombre, fecha_nacimiento);
        this.posicion = posicion;
    }

    public Jugador() {
    }
    
    
    
    
    public String getPosicion() {
        return posicion;
    }

    public int getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setCodigoEquipo(int codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    @Override
    public String imprimir() {
          SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
       
           String  d = sdf.format(this.getFecha_nacimiento());
        return "Identificacion: "+this.getIdentificacion()+"\n"+
                "Nombre: "+this.getNombre()+"\n"+
                "Apellido: "+this.getApellido()+"\n"+
                "Fecha de nacimiento: "+d+"\n"+
                "Posicion: "+this.getPosicion()+"\n"+
                "Codigo Equipo: "+this.getCodigoEquipo()+"\n"+
                "Nombre Equipo: "+this.getNombreEquipo()+"\n"+
                "*****************************************************"; 
    }
    
    
    
}
