package Algoritmos;
import DataTypes.*;

import java.util.*;

public abstract class Algoritmo {

    protected List<Punto> dataset;
    protected double mejor_distancia = Double.POSITIVE_INFINITY;
    protected List<Punto> mejor_par = new ArrayList<>();
    protected DistanciaEuclidea distancia_euclidea = new DistanciaEuclidea();

    // Método run que deberán usar todas las clases hijas
    public abstract void run();

    // Método para obtener la mejor distancia encontrada
    public double mejorDistancia(){
        return mejor_distancia;
    }

    // Método para obtener el mejor par de puntos
    public List<Punto> mejorPar(){
        return mejor_par;
    }

    // Método para devolver las veces que hemos calculado distancias
    public int distanciasCalculadas(){
        return distancia_euclidea.calculos;
    }
}
