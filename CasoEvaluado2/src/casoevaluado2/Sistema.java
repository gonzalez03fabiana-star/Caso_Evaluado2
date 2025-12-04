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
public class Sistema {

    private Avion avion;

    public Sistema() {
        avion = new Avion();
        avion.inicializarAsientos();
    }

    /**
     * Muestra el menú
     */
    public void iniciarPrograma() {
        int opcion = 0;

        while (opcion != 6) {
            try {
                String texto = JOptionPane.showInputDialog("""
                                                           SISTEMA DE RESERVAS - AEROL\u00cdNEA
                                                           
                                                           1. Ver mapa del avi\u00f3n
                                                           2. Reservar asiento (cliente normal)
                                                           3. Reservar asiento (cliente frecuente)
                                                           4. Consultar pasajero por asiento
                                                           5. Ver resumen del vuelo
                                                           6. Salir
                                                           
                                                           Digite una opci\u00f3n:""");

                if (texto == null) {
                    opcion = 6;
                } else {
                    opcion = Integer.parseInt(texto);
                    ejecutarAccion(opcion);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe digitar un número válido.");
            }
        }
    }

    
    private void ejecutarAccion(int opcion) {
        switch (opcion) {
            case 1:
                avion.mostrarMapaAvion();
                break;
            case 2:
                reservar(false);
                break;
            case 3:
                reservar(true);
                break;
            case 4:
                consultarPasajero();
                break;
            case 5:
                avion.mostrarResumenVuelo();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
        }
    }

    /**
     * Metodo para reservar un asiento
     * 
     * @param clienteFrecuente 
     */
    private void reservar(boolean clienteFrecuente) {

        int filaValida = 0;
        while (filaValida < 1 || filaValida > 5) {
            try {
                String fila = JOptionPane.showInputDialog("Digite la fila (1-5):");
                if (fila == null) return;
                filaValida = Integer.parseInt(fila);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Número inválido");
            }
        }

        int asientoValido = 0;
        while (asientoValido < 1 || asientoValido > 4) {
            try {
                String numero = JOptionPane.showInputDialog("Digite número de asiento (1-4):");
                if (numero == null) return;
                asientoValido = Integer.parseInt(numero);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Número inválido");
            }
        }

        Asiento asiento = avion.obtenerAsiento(filaValida, asientoValido);

        if (asiento == null) {
            JOptionPane.showMessageDialog(null, "Asiento no existe.");
            return;
        }

        if (!asiento.getEstado().equals("Libre")) {
            JOptionPane.showMessageDialog(null, "Asiento ocupado.");
            return;
        }

        // Solicita el nombre del pasajero
        String nombre = "";
        while (nombre.equals("")) {
            nombre = JOptionPane.showInputDialog("Nombre del pasajero:");
            if (nombre == null) return;
        }

        // Solicita el numero de pasaporte
        String pasaporte = "";
        while (pasaporte.equals("")) {
            pasaporte = JOptionPane.showInputDialog("Pasaporte:");
            if (pasaporte == null) return;
        }

        // Solicita la nacionalidad
        String nacionalidad = "";
        while (nacionalidad.equals("")) {
            nacionalidad = JOptionPane.showInputDialog("Nacionalidad:");
            if (nacionalidad == null) return;
        }

        Pasajero pasajero = new Pasajero(nombre, pasaporte, nacionalidad);

        double monto = avion.reservarAsiento(asiento, pasajero, clienteFrecuente);

        JOptionPane.showMessageDialog(null,"Reserva exitosa\nAsiento: " + asiento.getCodigo() + "\nTotal cobrado: $" + monto);
    }

    
    private void consultarPasajero() {

        int fila = 0;

        while (fila < 1 || fila > 5) {
            try {
                String f = JOptionPane.showInputDialog("Fila del asiento (1-5):");
                if (f == null) return;
                fila = Integer.parseInt(f);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Número inválido");
            }
        }

        int asiento = 0;

        while (asiento < 1 || asiento > 4) {
            try {
                String numeroColumna = JOptionPane.showInputDialog("Número asiento (1-4):");
                if (numeroColumna == null) return;
                asiento = Integer.parseInt(numeroColumna);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Número inválido");
            }
        }

        Asiento a = avion.obtenerAsiento(fila, asiento);

        if (a == null) {
            JOptionPane.showMessageDialog(null, "Ese asiento no existe.");
            return;
        }

        if (!a.getEstado().equalsIgnoreCase("Ocupado")) {
            JOptionPane.showMessageDialog(null, "El asiento está libre.");
            return;
        }

        Pasajero pasajero = a.getPasajero();
        JOptionPane.showMessageDialog(null, "PASAJERO\n" + "Asiento: " + a.getCodigo() + "\n" + "Nombre: " + pasajero.getNombreCompleto() + "\n" + "Pasaporte: " + pasajero.getPasaporte() + "\n" + "Nacionalidad: " + pasajero.getNacionalidad());
    }
}
