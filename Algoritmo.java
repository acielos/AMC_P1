import java.util.*;

public abstract class Algoritmo {

    protected List<Punto> dataset;
    protected double mejor_distancia;
    protected Punto[] mejor_par;
    protected DistanciaEuclidea calc_distancia;

    // Implementamos el metodo run que deberán usar todas las clases hijas
    public abstract void run();

    // Implementamos el metodo mejorPar
    public void mejorPar(){

    }
}
