import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ColeccionPizza {

    private ArrayList<Integer> pizzas;
    private ArrayList<Integer> pizzasFinal;
    private int maxPorciones;
    private int porciones;
    private String nombre;

    public ColeccionPizza(String nombreArchivo) throws FileNotFoundException, IOException { //metodo para abrir el archivo
        this.pizzas = new ArrayList();
        this.pizzasFinal = new ArrayList();
        this.nombre = nombreArchivo;
        int contador = 0;
        String[] parts;

        String cadena;
        FileReader f = new FileReader("input/" + nombreArchivo + ".in");
        BufferedReader b = new BufferedReader(f);

        cadena = b.readLine();
        parts = cadena.split(" ");
        this.maxPorciones = Integer.parseInt(parts[0]);
        cadena = b.readLine();
        parts = cadena.split(" ");
        int i = 0;
        while (i < parts.length) {
            this.pizzas.add(Integer.parseInt(parts[i++]));
        }

        b.close();
    }

    public void ordenarPizzas() {
        ordenarPizzasVoraz();
    } //llama al voraz

    public void ordenarPizzasVoraz() { //algoritmo voraz
        int recuento = 0;
        int elem;

        for (int i = 0; i < pizzas.size(); i++) { //Aqui se recorre el array del prioncipio al final
            elem = pizzas.get(i);
            if ((elem + recuento) <= this.maxPorciones) {
                recuento += elem;
                pizzasFinal.add(i);
            }
        }
        this.porciones = recuento;

        recuento = 0;
        ArrayList<Integer> aux = new ArrayList();
        for (int i = (pizzas.size() - 1); i >= 0; i--) { //Aqui se recorre desde el final hacia el principio
            elem = pizzas.get(i);
            if ((elem + recuento) <= this.maxPorciones) {
                recuento += elem;
                aux.add(i);
            }
        }

        if (recuento > this.porciones) { //si el segundo recorrido da mejor resultado, se guarda
            this.porciones = recuento;
            Collections.sort(aux);
            this.pizzasFinal = aux;
        }
    }

    public void ordenarPizzasVueltaAtras() {

    }

    public void guardarResultado() {
        File f;
        String ruta = "output/" + this.nombre + "_output.txt";
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

        mostrarResultado();
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder("").append(pizzasFinal.size()).append("\n");
        toret.append(pizzasFinal.get(0));
        for (int i = 1; i < pizzasFinal.size(); i++) {
            toret.append(" ").append(pizzasFinal.get(i));
        }

        return toret.toString();
    }

    private void mostrarResultado() {
        System.out.println("El hilo que ejecutaba el archivo " + this.nombre
                + " ha finalizado y ha alcanzado " + this.porciones + "  de "
                + this.maxPorciones + " porciones posibles");
    }

}