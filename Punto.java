import java.util.*;
public class Punto {

    // Declaramos los atributos de la clase punto
    private double x;
    private double y;

    // Declaramos el constructor
    public Punto(int id, double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    // Pasamos a String para dar formato a la visualización del punto
    public String toString(){
        return String.format("(%f, %f)", x, y);
    }

}
