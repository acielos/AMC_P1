public class DistanciaEuclidea {

    public double distanciaEuclidea(Punto a, Punto b){

        // Calculamos la distancia euclidea entre dos puntos
        double distancia = Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
        return distancia;
    }
}
