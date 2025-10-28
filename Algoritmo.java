import java.util.*;

public abstract class Algoritmo {

    protected String nombre;
    protected List<Punto> dataset;
    protected double mejor_distancia;
    protected Punto[] mejor_par;
    protected DistanciaEuclidea calc_distancia;
//    protected Solución optimo;
    protected double tiempoEjecucion;

    // Creamos una clase anidada para trabajar con la solución de cada algoritmo
//    public static final class Solución {
//        private final Punto punto1;
//        private final Punto punto2;
//        private final double distancia;
//
//        // Declaramos el constructor de la clase
//        public Solución(Punto punto1, Punto punto2, double distancia) {
//            this.punto1 = punto1;
//            this.punto2 = punto2;
//            this.distancia = distancia;
//        }
//
//        // Declaramos los getters de esta clase anidada
//        public Punto getPunto1(){return punto1;}
//        public Punto getPunto2(){return punto2;}
//        public double getDistancia(){return distancia;}
//
//        // Damos formato al resultado
//        public String toString(){
//            return String.format("%d (%f, %f), %d (%f, %f) - %.8f",
//                    punto1.getID(), punto1.getX(), punto1.getY(),
//                    punto2.getID(), punto2.getX(), punto2.getY(),
//                    distancia);
//        }
//    }

    // Implementamos el metodo run que deberán usar todas las clases hijas
    public abstract void run();

    // Implementamos el metodo mejorPar
    public void mejorPar(){

    }


}
