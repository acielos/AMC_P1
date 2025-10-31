import Algoritmos.*;
import DataTypes.*;

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
        int opcionEstrategia = 9;

        while(opcion != 0) {
            System.out.println("\n");
            System.out.println(" *                        ------ MENÚ ------                       *");
            System.out.println("\t1. Generar DataTypes.Dataset aleatorio");
            System.out.println("\t2. Cargar DataTypes.Dataset existente");
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
                    System.out.println(" *                     ------ ESTRATEGIAS ------                    *");
                    System.out.println(" ");
                    System.out.println("\t 1. Estrategia Algoritmos.Exhaustivo");
                    System.out.println("\t 2. Estrategia Algoritmos.Exhaustivo con poda");
                    System.out.println("\t 3. Estrategia Divide y Vencerás");
                    System.out.println("\t 5. Estrategia Divide y Vencerás mejorada");
                    System.out.println("\t ----------------------------------------");
                    System.out.print("\t Seleccione una opción: ");
                    opcionEstrategia = sc.nextInt();

                    Algoritmo algoritmo;

                    switch (opcionEstrategia){
                        case 1:
                            List<Punto> listaExhaustivo = Dataset.generarDataset();
                            algoritmo = new Exhaustivo(listaExhaustivo);
                            algoritmo.run();
                            System.out.println(" ");
                            System.out.println(algoritmo.mejor_distancia);
                            System.out.println(algoritmo.mejor_par);
                            System.out.println(algoritmo.distanciasCalculadas());
                            break;
                        case 2:
                            List<Punto> listaPoda = Dataset.generarDataset();
                            algoritmo = new ExhaustivoPoda(listaPoda);
                            algoritmo.run();
                            System.out.println(" ");
                            System.out.println(algoritmo.mejor_distancia);
                            System.out.println(algoritmo.mejor_par);
                            System.out.println(algoritmo.distanciasCalculadas());
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }

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
//        ArrayList<DataTypes.Punto> lista = (ArrayList<DataTypes.Punto>) DataTypes.Dataset.generarDataset();
//        DataTypes.Dataset.escribir("dataset1", lista);
//
//        Algoritmos.Algoritmo a = new Algoritmos.Exhaustivo(lista);
//        a.run();
//        System.out.println(lista);
//        System.out.println(" ");
//        System.out.println(a.mejor_distancia);
//        System.out.println(a.mejor_par);
//        System.out.println(a.distanciasCalculadas());
    }
}
