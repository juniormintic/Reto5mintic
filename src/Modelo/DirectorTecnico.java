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
public class DirectorTecnico extends Persona{   
    private int mesContrato;
    private int anioContrato;

    public DirectorTecnico( String identificacion, String nombre, String apellido, Date fecha_nacimiento,int mesContrato, int anioContrato) {
        super(identificacion, nombre, apellido, fecha_nacimiento);
        this.mesContrato = mesContrato;
        this.anioContrato = anioContrato;
    }

    public DirectorTecnico( String identificacion) {
        super(identificacion);
    }

    @Override
    public void setFecha_nacimiento(String fecha_nacimiento) {
        super.setFecha_nacimiento(fecha_nacimiento); 
    }

    

    @Override
    public String getIdentificacion() {
        return super.getIdentificacion();
    }

    @Override
    public void setIdentificacion(String identificacion) {
        super.setIdentificacion(identificacion); 
    }
    

    public int getMesContrato() {
        return mesContrato;
    }

    public int getAnioContrato() {
        return anioContrato;
    }

   
    public void setMesContrato(int mesContrato) {
        this.mesContrato = mesContrato;
    }

    public void setAnioContrato(int anioContrato) {
        this.anioContrato = anioContrato;
    }
    
    @Override
     public  String imprimir(){
          SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd ");
       
           String  d = sdf.format(this.getFecha_nacimiento());
        return "Identificacion: "+this.getIdentificacion()+"\n"+
                "Nombre: "+this.getNombre()+"\n"+
                "Apellido: "+this.getApellido()+"\n"+
                "Fecha de nacimiento: "+d+"\n"+
                "Mes contrato: "+this.getMesContrato()+"\n"+
                "Año contrato: "+this.getAnioContrato()+"\n"+
                "*****************************************************";
    };
    
}
