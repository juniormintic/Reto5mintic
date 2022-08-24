/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JUNIOR
 */
public class Equipo {
    private int codigo;
    private String nombre;
    private String ciudad;
    private String estadio;
    private int anioFundado;
    private String identificacionTecnico;

    public Equipo(int codigo, String nombre, String ciudad, String estadio, int anioFundado, String identificacionTecnico) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estadio = estadio;
        this.anioFundado = anioFundado;
        this.identificacionTecnico = identificacionTecnico;
    }

    public Equipo(String nombre, String estadio, int anioFundado) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.anioFundado = anioFundado;
    }

    
    
    public Equipo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public void setAnioFundado(int anioFundado) {
        this.anioFundado = anioFundado;
    }

    public void setIdentificacionTecnico(String identificacionTecnico) {
        this.identificacionTecnico = identificacionTecnico;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstadio() {
        return estadio;
    }

    public int getAnioFundado() {
        return anioFundado;
    }

    public String getIdentificacionTecnico() {
        return identificacionTecnico;
    }
    
    public String imprimir(){
        return "Codigo: "+this.getCodigo()+"\n"+
                "Nombre: "+this.getNombre()+"\n"+
                "Ciudad: "+this.getCiudad()+"\n"+
                "Estadio: "+this.getEstadio()+"\n"+
                "Año de fundado: "+this.getAnioFundado()+"\n"+
                "Director tecnico: "+this.getIdentificacionTecnico()+"\n"+
                "********************************************************";
    }
    
    
}
