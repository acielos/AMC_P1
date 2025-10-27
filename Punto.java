import java.io.*;
import java.util.*;
public class Punto {

    // Declaramos los atributos de la clase punto
    private int id;
    private double x;
    private double y;

    // Declaramos el constructor
    public Punto(int id, double x, double y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    // Declaramos los getters
    public int getID(){
        return id;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public String toString(){
        return String.format("Punto %d, (%f, %f)", id, x, y);
    }

    // Declaramos el método Aleatorios, que generará una nube de puntos aleatorios
    public ArrayList<Punto> generaPuntos(){
        // Le decimos al programa el número de puntos que queremos crear
        int numPuntos = 50;

        // Creamos listaPuntos del tipo ArrayList
        ArrayList<Punto> listaPuntos = new ArrayList<>();
        for (int i = 0; i < numPuntos; i++){
            // Generamos aleatoriamente las coordenadas x e y
            double x = (Math.random() * 100);
            double y = (Math.random() * 100);

            // Añadimos a la lista de puntos el punto generado
            listaPuntos.add(new Punto(i,x,y));
        }

        // Devolvemos la lista de puntos generados
        return listaPuntos;
    }
}
