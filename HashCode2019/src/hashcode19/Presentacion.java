/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Viñas
 */
public class Presentacion {

    private ArrayList<Diapositiva> diapos;
    private static final int LIMITE = 100000;

    public Presentacion(ColeccionFotos miColeccion) {
        ArrayList<Diapositiva> toret = new ArrayList<>();
        int cont = 0;
        Foto foto = null;

        while (!miColeccion.estaVacio()) {
            Foto actual = miColeccion.quitarFoto();

            if (actual.getTipo() == 'H') {
                toret.add(new Diapositiva(actual));
            } else {
                cont++;
                if (cont == 1) {
                    foto = actual;
                } else {
                    toret.add(new Diapositiva(foto, actual));
                    cont = 0;
                }
            }
        }
        if (cont == 1) {
            toret.add(new Diapositiva(foto));
        }
        diapos = toret;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder("").append(diapos.size());
        for (int i = 0; i < diapos.size(); i++) {
            toret.append("\n").append(diapos.get(i).toString());
        }

        return toret.toString();
    }

    public void escribir(String nombre) {
        File f;
        String ruta = "EntradaSalida/Salida/" + nombre + "output.txt";
        f = new File(ruta);
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(toString());
            wr.close();
            bw.close();
        } catch (IOException e) {
        }

    }

    public void ordenarPresentacion() throws InterruptedException {

        Diapositiva diapostivaActual = diapos.get(0);
        LinkedList<Diapositiva> porVisitar = new LinkedList<>();
        ArrayList<Diapositiva> solucion = new ArrayList<>();

        for (Diapositiva diapositiva : diapos) {
            porVisitar.add(diapositiva);
        }

        porVisitar.remove(diapostivaActual);
        solucion.add(diapostivaActual);

        boolean continuar = true;

        while (!porVisitar.isEmpty() && continuar) {
            Diapositiva diapositiva = max(diapostivaActual, porVisitar);
            if (diapositiva != null) {
                porVisitar.remove(diapositiva);
                solucion.add(diapositiva);
                diapostivaActual = diapositiva;
            } else {
                continuar = false;
            }
        }
        diapos = solucion;
    }

    private static Diapositiva max(Diapositiva primera, LinkedList<Diapositiva> iPorVisitar) throws InterruptedException {
        int valorMax = -1;
        int valor = 0;
        Iterator<Diapositiva> iterador = iPorVisitar.iterator();
        Diapositiva maxPuntuacion = null;
        Diapositiva actual = null;
        int cont = 0;

        while (iterador.hasNext() && cont < LIMITE) {
            actual = iterador.next();
            valor = calcularMax(primera, actual);
            if (valor > valorMax) {
                valorMax = valor;
                maxPuntuacion = actual;
            }
            cont++;
        }
        return maxPuntuacion;

    }

    private static int calcularMax(Diapositiva primera, Diapositiva siguiente) {

        int contInt = 0;
        int contA = 0;
        int contB = 0;
        int menor = 0;

        for (int i = 0; i < primera.listaTags().size(); i++) {

            int j = 0;
            boolean coincide = false;

            while (j < siguiente.listaTags().size() && !coincide) {

                if (primera.listaTags().get(i).compareTo(siguiente.listaTags().get(j)) == 0) {
                    coincide = true;
                }
                j++;
            }
            if (j == siguiente.listaTags().size() && !coincide) {
                contA++;
            } else {
                contInt++;
            }
        }

        contB = siguiente.listaTags().size() - contInt;

        if (contA < contB) {
            menor = contA;
        } else {
            menor = contB;
        }
        if (contInt < menor) {
            menor = contInt;
        }
        return menor;
    }

}
