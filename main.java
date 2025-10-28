import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {

        System.out.println(" ");
        System.out.println(" *******************************************************************");
        System.out.println(" *         Algorítmica y Modelos de Computación: Práctica 1        *");
        System.out.println(" *******************************************************************");
        System.out.println(" ");
        System.out.println(" Autores: Antonio Cielos e Isabela Ortigosa");

        Scanner sc = new Scanner(System.in);

        int opcion = 9;

        while(opcion != 0) {
            System.out.println("\n");
            System.out.println(" *                        ------ MENÚ ------                       *");
            System.out.println("\t1. Generar Dataset aleatorio");
            System.out.println("\t2. Cargar Dataset existente");
            System.out.println("\t3. Comprobar estrategia (única)");
            System.out.println("\t4. Comprobar dos estrategias");
            System.out.println("\t5. Comprobar todas las estrategias");
            System.out.println("\t6. Generar dataset 'Caso Peor'");
            System.out.println("\t0. Salir");
            System.out.println("\t----------------------------------");
            System.out.print("\t Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    List<Punto> dataset = new ArrayList<Punto>();
                    dataset = Dataset.generarDataset();
                    System.out.print("Introduzca un nombre para el dataset: ");
                    String nombre = sc.next();
                    Dataset.escribir(nombre, dataset);
                    break;
                case 2:
                    System.out.println("DISPONIBLE PRÓXIMAMENTE");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }

        // Cerramos el scaner
        sc.close();


//        // Zona de pruebas
//        ArrayList<Punto> lista = (ArrayList<Punto>) Dataset.generarDataset();
//        Dataset.escribir("dataset1", lista);
//
//        Algoritmo a = new Exhaustivo(lista);
//        a.run();
//        System.out.println(lista);
//        System.out.println(" ");
//        System.out.println(a.mejor_distancia);
//        System.out.println(a.mejor_par);
//        System.out.println(a.distanciasCalculadas());
    }
}
