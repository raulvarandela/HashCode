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
public class Diapositiva {

    private ArrayList<String> tags;
    private Foto fotoA;
    private Foto fotoB;

    public Diapositiva(Foto fotoA, Foto fotoB) {
        this.fotoA = fotoA;
        this.fotoB = fotoB;
        this.tags = sinDuplicados(fotoA, fotoB);
    }

    public ArrayList<String> listaTags() {
        return tags;
    }

    private static ArrayList<String> sinDuplicados(Foto fotoA, Foto fotoB) {
        ArrayList<String> toret = fotoA.listaTags();
        for (String i : fotoB.listaTags()) {
            if (!toret.contains(i)) {
                toret.add(i);
            }
        }
        return toret;
    }

    public Diapositiva(Foto fotoA) {
        this.tags = fotoA.listaTags();
        this.fotoA = fotoA;
        this.fotoB = null;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder("").append(fotoA.getNumeroFoto());
        if (fotoB != null) {
            toret.append(" ").append(fotoB.getNumeroFoto());
        }
        return toret.toString();
    }

}
