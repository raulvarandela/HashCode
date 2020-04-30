import java.io.*;
import java.util.ArrayList;

public class ColeccionBiblioteca {

    ArrayList<Integer> puntuaciones;
    ArrayList<Biblioteca> bibliotecas;
    ArrayList<Biblioteca> bibliotecasSeleccionadas;
    int numDias;
    int numLibros;
    int numBibliotecas;
    String nombreArchivo;


    public ColeccionBiblioteca(String nombreArchivo) throws IOException {
        this.bibliotecasSeleccionadas = new ArrayList <>();
        this.nombreArchivo = nombreArchivo;
        FileReader f = new FileReader("input/" + nombreArchivo);
        BufferedReader b = new BufferedReader(f);

        String cadena = b.readLine();
        String[] parts = cadena.split(" ");
        this.numLibros = Integer.parseInt(parts[0]);
        this.numBibliotecas = Integer.parseInt(parts[1]);
        this.numDias = Integer.parseInt(parts[2]);
        cadena = b.readLine();
        parts = cadena.split(" ");
        puntuaciones = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            Integer actual = Integer.parseInt(parts[i]);
            puntuaciones.add(actual);
        }
        bibliotecas = new ArrayList<>();
        for (int j = 0; j < numBibliotecas; j++) {
            cadena = b.readLine();
            parts = cadena.split(" ");
            ArrayList<Integer> libros;
            int libroPorDia = Integer.parseInt(parts[2]);
            int tRegistro = Integer.parseInt(parts[1]);
            int id = j;
            int numLibros = Integer.parseInt(parts[0]);

            cadena = b.readLine();
            parts = cadena.split(" ");
            libros = new ArrayList<>(numLibros);
            for (int x = 0; x < numLibros; x++) {
                libros.add(Integer.parseInt(parts[x]));
            }
            Biblioteca nueva = new Biblioteca(libros, libroPorDia, tRegistro, id, numLibros);
            bibliotecas.add(nueva);
        }

        b.close();
    }

    public void ordenar(){
        int diasRestantes = numDias;
        float proporcionactual = Float.MIN_VALUE;
        float proporcionseleccionada = Float.MIN_VALUE;
        Biblioteca actual;
        Biblioteca seleccionada = null;
        ArrayList<Biblioteca> bibliotecasPorver = (ArrayList<Biblioteca>) bibliotecas.clone();
        int indice = 0;

        while(!bibliotecasPorver.isEmpty() ){

            for (int i = 0; i < bibliotecasPorver.size(); i++) {
                actual = bibliotecasPorver.get(i);
                proporcionactual = (diasRestantes-actual.gettRegistro())*actual.getLibroPorDia();

                if(proporcionactual > proporcionseleccionada){
                    seleccionada = actual;
                    proporcionseleccionada = proporcionactual;
                    indice = i;
                }
            }
            proporcionseleccionada = Float.MIN_VALUE;
            bibliotecasPorver.remove(seleccionada);
            bibliotecasSeleccionadas.add(seleccionada);
        }
        for (Biblioteca b : bibliotecasSeleccionadas) {
            b.setLibrosSeleccionados(b.getLibros());
        }

    }

    public String toString() {
        StringBuilder toret = new StringBuilder().append(bibliotecasSeleccionadas.size()).append("\n");

        for (Biblioteca b : bibliotecasSeleccionadas) {
            toret.append(b.id).append(" ").append(b.librosSeleccionados.size()).append("\n");
            for (Integer l: b.getLibrosSeleccionados()){
             toret.append(l).append(" ");
            }
            toret.append("\n");
        }

        return toret.toString();
    }

    public void guardarResultado() {
        File f;
        String ruta = "output/" + this.nombreArchivo + "_output.txt";
        f = new File(ruta);
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(this.toString());
            wr.close();
            bw.close();
        } catch (IOException e) {
        }
    }
}
