public class DistanciaEuclidea {

    public int calculos = 0;

    public double calcula(Punto a, Punto b){

        calculos++;

        // Calculamos la distancia euclidea entre dos puntos
        double distancia = Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
        return distancia;
    }
}
