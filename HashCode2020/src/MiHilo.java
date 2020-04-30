import java.io.FileNotFoundException;
import java.io.IOException;

public class MiHilo extends Thread {

    private String nombreArchivo;

    public MiHilo(String name) {
        this.nombreArchivo = name;
    }

    public void run() {

        long inicio = System.currentTimeMillis();

        try {
            ColeccionBiblioteca miColeccion = new ColeccionBiblioteca(this.nombreArchivo);
            miColeccion.ordenar();
            miColeccion.guardarResultado();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis();

        double tiempo = (double) ((fin - inicio)/1000);

        System.out.println("El archivo " + this.nombreArchivo + " ha tardado "+tiempo +" segundos");


    }
}
