/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JUNIOR
 */
public class Gol {
    private int codigo;
    private int minuto;
    private String descripcion;
    private  int codPartido;
    private String jugador;

    public Gol(int codigo, int minuto, String descripcion, int codPartido, String jugador) {
        this.codigo = codigo;
        this.minuto = minuto;
        this.descripcion = descripcion;
        this.codPartido = codPartido;
        this.jugador = jugador;
    }

    public Gol(int codigo) {
        this.codigo = codigo;
    }

    public Gol(int codigo, int codPartido, int minuto, String descripcion) {
        this.codigo = codigo;
         this.codPartido = codPartido;
         this.minuto = minuto;
        this.descripcion = descripcion;
        
       
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCodPartido(int codPartido) {
        this.codPartido = codPartido;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public int getMinuto() {
        return minuto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCodPartido() {
        return codPartido;
    }

    public String getJugador() {
        return jugador;
    }
    
    public String imprimir(){
        return "Codigo : "+ this.getCodigo()+"\n"+ 
                "Minuto: "+ this.getMinuto()+"\n"+ 
                "Descripcion: "+ this.getDescripcion()+"\n"+
                "Codigo Partido: "+ this.getCodPartido()+"\n"+
                "Codigo Jugador: "+ this.getJugador()+"\n"+
                "*****************************************************";
                
    }
    
}
