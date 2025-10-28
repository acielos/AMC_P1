import java.util.*;

import static java.lang.System.in;

public abstract class Algoritmo {

    protected String nombre;
    protected List<Punto> dataset;
    protected double mejor_distancia;
    protected Punto[] mejor_par;
    protected DistanciaEuclidea num_distancias;
    protected double tiempoEjecucion;

    // Método run que deberán usar todas las clases hijas
    public abstract void run();

//    // Creamos el método por el que los algoritmos obtendrán el dataset
//    protected List<Punto> datasetDado(String nom_dataset){
//        // Leemos el dataset que vamos a pasarle al algoritmo
//        /*
//        * MÉTODO DE LECTURA EN CONSTRUCCIÓN
//        */
//
//        // Ordenamos el dataset que
//
//        return datset;
//    }



    /*  POSIBILIDAD DE CAMBIO DE CLASE  */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Creamos un método para copiar el dataset y trabajar con el
    protected static List<Punto> copia(List<Punto> dataset){
        List<Punto> listaCopiada = new ArrayList<Punto>(dataset.size());
        for (Punto p : dataset){
            listaCopiada.add(new Punto(p.getID(), p.getX(), p.getY()));
        }
        return listaCopiada;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
