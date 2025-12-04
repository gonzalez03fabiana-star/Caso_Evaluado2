/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoevaluado2;

import javax.swing.JOptionPane;

/**
 *
 * @author gonza
 */
public class Avion {

    private Asiento[][] matriz;

    public Avion() {
        matriz = new Asiento[5][4];
    }

    /**
     * Inicializa los asientos del avión con código, clase y precio
     */
    public void inicializarAsientos() {
        String[] letras = {"A", "B", "C", "D"};

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                String codigo = (i + 1) + letras[j];
                String clase;
                double precio;

                if (i == 0) {
                    clase = "Primera";
                    precio = 500;
                } else if (i == 1) {
                    clase = "Business";
                    precio = 300;
                } else {
                    clase = "Económica";
                    precio = 100;
                }

                matriz[i][j] = new Asiento(codigo, clase, precio, "Libre");
            }
        }
    }

    /**
     * Obtiene un asiento (1-4)
     * 
     * @param fila
     * @param numeroAsiento
     * @return 
     */
    public Asiento obtenerAsiento(int fila, int numeroAsiento) {
        int filaB = fila - 1;
        int columnaB = numeroAsiento - 1;

        if (filaB < 0 || filaB >= matriz.length) {
            return null;
        }
        if (columnaB < 0 || columnaB >= matriz[0].length) {
            return null;
        }

        return matriz[filaB][columnaB];
    }

    /**
     * Reserva un asiento aplicando descuento si es necesario
     */
    public double reservarAsiento(Asiento asiento, Pasajero pasajero, boolean clienteFrecuente) {
        double base = asiento.getPrecioBase();
        double descuento = 0;

        if (clienteFrecuente) {
            if (asiento.getClase().equals("Económica")) {
                descuento = base * 0.10;
            } else if (asiento.getClase().equals("Business")) {
                descuento = base * 0.15;
            } else {
                descuento = base * 0.18;
            }
        }

        double total = base - descuento;

        asiento.setPasajero(pasajero);
        asiento.setEstado("Ocupado");
        asiento.setMontoCobrado(total);

        return total;
    }

    /**
     * Muestra el mapa del avion
     */
    public void mostrarMapaAvion() {
        String texto = "MAPA DEL AVIÓN\n\n";

        for (int i = 0; i < matriz.length; i++) {
            texto += "Fila " + (i + 1) + "\n";
            for (int j = 0; j < matriz[i].length; j++) {
                Asiento a = matriz[i][j];
                texto += a.getCodigo() + " - Estado: " + a.getEstado() + " - " + a.getClase() + " - $" + a.getPrecioBase() + "\n";
            }
        }

        JOptionPane.showMessageDialog(null, texto);
    }

    /**
     * Calcula y muestra el total recaudado
     */
    public void mostrarResumenVuelo() {
        double total = 0;
        int libres = 0;
        int ocupados = 0;
        int totalAsientos = matriz.length * matriz[0].length;

        for (Asiento[] fila : matriz) {
            for (Asiento a : fila) {
                if (a.getEstado().equals("Ocupado")) {
                    ocupados++;
                    total += a.getMontoCobrado();
                } else {
                    libres++;
                }
            }
        }

        double porcentaje = (ocupados * 100.0) / totalAsientos;

        JOptionPane.showMessageDialog(null,
                "RESUMEN DEL VUELO\n\n"
                + "Recaudado: $" + total + "\n"
                + "Libres: " + libres + "\n"
                + "Ocupación: " + porcentaje + "%");
    }

}
