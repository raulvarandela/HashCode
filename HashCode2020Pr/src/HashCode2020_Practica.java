import java.io.IOException;

public class HashCode2020_Practica {

    public static void main(String[] args) throws IOException {
        ProcesarHilo a = new ProcesarHilo("a_example");
        ProcesarHilo b = new ProcesarHilo("b_small");
        ProcesarHilo c = new ProcesarHilo("c_medium");
        ProcesarHilo d = new ProcesarHilo("d_quite_big");
        ProcesarHilo e = new ProcesarHilo("e_also_big");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }

}