import java.util.*;

public class Dataset {

    public static ArrayList<Punto> generarDataset(){
        // Le decimos al programa el número de puntos que queremos crear
        int numPuntos = 50;

        // Creamos listaPuntos del tipo ArrayList
        ArrayList<Punto> listaPuntos = new ArrayList<>();
        for (int i = 0; i < numPuntos; i++){
            // Generamos aleatoriamente las coordenadas x e y
            double x = (Math.random() * 100);
            double y = (Math.random() * 100);

            // Añadimos a la lista de puntos el punto generad
            listaPuntos.add(new Punto(i,x,y));
        }

        // Ordenamos la lista que hemos generado
        Quicksort.sort(listaPuntos);

        // Devolvemos la lista de puntos generados
        return listaPuntos;
    }
}
