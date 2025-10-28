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

    public int getID(){
        return id;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    // Pasamos a String para dar formato a la visualización del punto
    public String toString(){
        return String.format("%d (%f, %f)", id, x, y);
    }

}
