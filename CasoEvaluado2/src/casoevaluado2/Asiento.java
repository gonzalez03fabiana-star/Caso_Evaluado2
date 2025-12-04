/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoevaluado2;

/**
 *
 * @author gonza
 */
public class Asiento {
    private String codigo;
    private String clase;
    private double precioBase;
    private String estado;     // Libre u Ocupado
    private Pasajero pasajero; // Pasajero asignado
    private double montoCobrado;

    public Asiento(String codigo, String clase, double precioBase, String estado) {
        this.codigo = codigo;
        this.clase = clase;
        this.precioBase = precioBase;
        this.estado = estado;
        this.pasajero = pasajero;
        this.montoCobrado = montoCobrado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public double getMontoCobrado() {
        return montoCobrado;
    }

    public void setMontoCobrado(double montoCobrado) {
        this.montoCobrado = montoCobrado;
    }
    
    
    
    
}
