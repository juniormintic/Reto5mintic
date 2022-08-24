/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUNIOR
 */
public class Partido {
    private int codigo;
    private int golLocal;
    private int golVisitanet;
    private Date fecha;

    public Partido(int codigo, int golLocal, int golVisitanet, Date fecha) {
        this.codigo = codigo;
        this.golLocal = golLocal;
        this.golVisitanet = golVisitanet;
        this.fecha = fecha;
    }

    public Partido(int golLocal, int golVisitanet, Date fecha) {
        this.golLocal = golLocal;
        this.golVisitanet = golVisitanet;
        this.fecha = fecha;
    }
    
    public Partido(int codigo) {
        this.codigo = codigo;
    }
    

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setGolLocal(int golLocal) {
        this.golLocal = golLocal;
    }

    public void setGolVisitanet(int golVisitanet) {
        this.golVisitanet = golVisitanet;
    }

    public void setFecha(String fecha) {
         SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");       
        try {
           Date  d = sdf.parse(fecha);
            this.fecha = d;
        } catch (ParseException ex) {
            Logger.getLogger(Partido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public int getGolLocal() {
        return golLocal;
    }

    public int getGolVisitanet() {
        return golVisitanet;
    }

    public Date getFecha() {
       
        return this.fecha;
    }
    
    public String Imprimir(){
         SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       
           String  d = sdf.format(this.fecha);
            
      
        return "Codigo Partido: "+ this.getCodigo()+"\n"+ 
                "Goles Local: "+ this.getGolLocal()+"\n"+ 
                "Goles Visitante: "+ this.getGolVisitanet()+"\n"+
                "Fecha: "+ d+"\n"+
                "*****************************************************";
                
    }
    
}
