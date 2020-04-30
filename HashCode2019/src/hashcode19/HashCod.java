package hashcode19;

import java.io.IOException;

public class HashCod {

    public static void main(String[] args) throws IOException {

        ProcesarHilo a = new ProcesarHilo("a_example");
        ProcesarHilo b = new ProcesarHilo("b_lovely_landscapes");
        ProcesarHilo c = new ProcesarHilo("c_memorable_moments");
        ProcesarHilo d = new ProcesarHilo("d_pet_pictures");
        ProcesarHilo e = new ProcesarHilo("e_shiny_selfies");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }

}
