/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Viñas
 */
public class ColeccionFotos {

    private ArrayList<Foto> fotos;

    public ColeccionFotos() {
        this.fotos = new ArrayList();
    }

    public ColeccionFotos(String rutaArchivo) throws IOException {
        this.fotos = new ArrayList();
        int contador = 0;

        String cadena;
        FileReader f = new FileReader(rutaArchivo);
        BufferedReader b = new BufferedReader(f);
        int numeroFotos = Integer.parseInt(b.readLine());

        while ((cadena = b.readLine()) != null) {
            int i = 2;
            String[] parts = cadena.split(" ");
            String tipo = parts[0];
            int numeroTags = Integer.parseInt(parts[1]);

            ArrayList<String> listaTags = new ArrayList<>(numeroTags);

            while (i < parts.length) {
                listaTags.add(parts[i++]);
            }
            this.fotos.add(new Foto(contador, tipo.charAt(0), listaTags));

            contador++;
        }
        b.close();
    }

    public void anadirFoto(Foto foto) {
        fotos.add(foto);
    }

    public boolean estaVacio() {
        return fotos.isEmpty();
    }

    public Foto quitarFoto() {
        Foto toret = fotos.get(0);
        fotos.remove(0);
        return toret;
    }

}
