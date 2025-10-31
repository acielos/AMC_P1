package Algoritmos;

import DataTypes.*;

import java.util.*;

public class ExhaustivoPoda extends Algoritmo {

    public ExhaustivoPoda(List<Punto> dataset){
        this.dataset = dataset;
    }

    @Override
    public void run() {
        double distancia_minima = mejorDistancia();
        double distancia;

        for (int i = 0; i < dataset.size() -1; i++){
            for (int j = i +1; j < dataset.size(); j++){
                if (Math.abs(this.dataset.get(i).getX() - this.dataset.get(j).getX()) < distancia_minima) {
                    distancia = this.distancia_euclidea.calcula(this.dataset.get(i), this.dataset.get(j));
                    if (distancia < distancia_minima){
                        distancia_minima = distancia;
                        mejor_par.clear();
                        mejor_par.add(this.dataset.get(i));
                        mejor_par.add(this.dataset.get(j));
                    }
                } else {break;}
            }
        }

        this.mejor_distancia = distancia_minima;
    }
}
