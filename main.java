import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        ArrayList<Punto> lista = Dataset.generarDataset();
        Dataset.escribir("dataset1", lista);

        System.out.println(lista);
    }
}
