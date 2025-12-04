/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoevaluado2;

/**
 *
 * @author gonza
 */
public class Pasajero {
    private String nombreCompleto;
    private String pasaporte;
    private String nacionalidad;

    public Pasajero(String nombreCompleto, String pasaporte, String nacionalidad) {
        this.nombreCompleto = nombreCompleto;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
    
}
