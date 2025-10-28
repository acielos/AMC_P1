import java.util.*;

import static java.lang.System.in;

public abstract class Algoritmo {

    protected String nombre;
    protected List<Punto> dataset;
    protected double mejor_distancia;
    protected Punto[] mejor_par;
    protected DistanciaEuclidea calc_distancia;
    protected double tiempoEjecucion;

    // Método run que deberán usar todas las clases hijas
    public abstract void run();


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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Implementamos el método para ordenar el dataset
    protected static void ordenar(List<Punto> dataset){
        Quicksort.sort(dataset);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
