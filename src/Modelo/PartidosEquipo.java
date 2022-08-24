/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JUNIOR
 */
public class PartidosEquipo {
    private int partidoCodigo;
    private int equipoCodigo;
    private boolean esLocal;

    public PartidosEquipo(int partidoCodigo, int equipoCodigo, boolean esLocal) {
        this.partidoCodigo = partidoCodigo;
        this.equipoCodigo = equipoCodigo;
        this.esLocal = esLocal;
    }

    public PartidosEquipo(int partidoCodigo) {
        this.partidoCodigo = partidoCodigo;
    }

    public void setPartidoCodigo(int partidoCodigo) {
        this.partidoCodigo = partidoCodigo;
    }

    public void setEquipoCodigo(int equipoCodigo) {
        this.equipoCodigo = equipoCodigo;
    }

    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public int getPartidoCodigo() {
        return partidoCodigo;
    }

    public int getEquipoCodigo() {
        return equipoCodigo;
    }

    public boolean getEsLocal() {
        return esLocal;
    }
    
     public String Imprimir(){
        return "Codigo Partido : "+ this.getPartidoCodigo()+"\n"+ 
                "Codigo Equipo : "+ this.getEquipoCodigo()+"\n"+ 
                "Es local: "+ this.getEsLocal()+"\n"+               
                "*****************************************************";
                
    }
}
