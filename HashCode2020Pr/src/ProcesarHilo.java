import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcesarHilo extends Thread {

    private String nombre;

    public ProcesarHilo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {

            ColeccionPizza a = new ColeccionPizza(nombre);
            a.ordenarPizzas();
            a.guardarResultado();

        } catch (IOException ex) {
            Logger.getLogger(ProcesarHilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}