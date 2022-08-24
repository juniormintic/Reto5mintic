/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.DateFormat;
import java.util.Date;
 import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JUNIOR
 */
public class  Persona {    
    private String identificacion;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    
    public Persona(String identificacion, String nombre, String apellido, Date fecha_nacimiento) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento=fecha_nacimiento;
    }
    //para  eliminar

    public Persona(String identificacion) {
        this.identificacion = identificacion;
    }
   

    public Persona() {
    }

    public Persona(String nombre, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");       
        try {
           Date  d = sdf.parse(fecha_nacimiento);
            this.fecha_nacimiento = d;
        } catch (ParseException ex) {
            Logger.getLogger(Partido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public  String imprimir(){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
       
           String  d = sdf.format(this.fecha_nacimiento);
        return "Identificacion: "+this.getIdentificacion()+"\n"+
                "Nombre: "+this.getNombre()+"\n"+
                "Apellido: "+this.getApellido()+"\n"+
                "Fecha de nacimiento: "+d+"\n"+
                "*****************************************************";
    };

    
}
