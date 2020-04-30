/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode19;

import java.util.ArrayList;

/**
 *
 * @author Viñas
 */
public class Foto {

    private int numeroFoto;
    private char tipo;
    private ArrayList<String> tags;

    public Foto(int numeroFoto, char tipo, ArrayList<String> tags) {
        this.numeroFoto = numeroFoto;
        this.tipo = tipo;
        this.tags = tags;
    }

    public Foto() {
        this.tags = new ArrayList<>(40);
    }

    public ArrayList<String> listaTags() {
        return tags;
    }

    public int getNumeroFoto() {
        return numeroFoto;
    }

    public char getTipo() {
        return tipo;
    }

    public String getTag(int pos) {
        return tags.get(pos);
    }

    public String toString() {
        StringBuilder toret = new StringBuilder(this.numeroFoto);
        return toret.toString();
    }

}
