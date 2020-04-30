import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Biblioteca { //el numero de libros
    //lo que se tarda en registrsr la biblio
    //numeros de  días * libro
    ArrayList<Integer> libros;
    ArrayList<Integer> librosSeleccionados;
    int libroPorDia;
    int tRegistro;
    int id;
    int numLibros;

    public Biblioteca(ArrayList<Integer> libros, int libroPorDia, int tRegistro, int id, int numLibros) {
        this.libros = libros;
        this.libroPorDia = libroPorDia;
        this.tRegistro = tRegistro;
        this.id = id;
        this.numLibros = numLibros;
        ArrayList<Integer> librosSeleccionados = new ArrayList<>();
    }

    public ArrayList<Integer> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Integer> libros) {
        this.libros = libros;
    }

    public ArrayList<Integer> getLibrosSeleccionados() {
        return librosSeleccionados;
    }

    public void setLibrosSeleccionados(ArrayList<Integer> librosSeleccionados) {
        this.librosSeleccionados = librosSeleccionados;
    }

    public int getLibroPorDia() {
        return libroPorDia;
    }

    public void setLibroPorDia(int libroPorDia) {
        this.libroPorDia = libroPorDia;
    }

    public int gettRegistro() {
        return tRegistro;
    }

    public void settRegistro(int tRegistro) {
        this.tRegistro = tRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }
}