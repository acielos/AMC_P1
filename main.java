import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        ArrayList<Punto> lista = (ArrayList<Punto>) Dataset.generarDataset();
        Dataset.escribir("dataset1", lista);

        Algoritmo a = new Exhaustivo(lista);
        a.run();
        System.out.println(lista);
        System.out.println(" ");
        System.out.println(a.mejor_distancia);
        System.out.println(a.mejor_par);
    }
}
