/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode19;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viñas
 */
public class ProcesarHilo extends Thread {

    private String nombre;

    public ProcesarHilo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        ColeccionFotos miColeccion;
        try {

            miColeccion = new ColeccionFotos("EntradaSalida/Entrada/" + nombre + ".txt");
            Presentacion miPresentacion = new Presentacion(miColeccion);
            miPresentacion.ordenarPresentacion();
            miPresentacion.escribir(nombre);

        } catch (IOException ex) {
            Logger.getLogger(ProcesarHilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcesarHilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
