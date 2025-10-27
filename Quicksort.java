import java.util.*;
public final class Quicksort {
    /*
    * Creamos el método público para el uso del algoritmo Quicksort:
    * pasamos como parámetro una lista de puntos [(x,y)...(m,n)] y esta lista la pasamos al método
    * privado quicksort para que la ordene según el algoritmo quicksort.
    */

    public static void sort(List<Punto> lista){
        quicksort(lista, 0, lista.size()-1);
    }

    private static void quicksort(List<Punto> lista, int primero, int ultimo){
        if (primero >= ultimo) return;
        Punto pivote = lista.get(ultimo);

        int pos = 1;
        for (int i = 1; i < ultimo; i++){
            if (lista.get(i).getX() <= pivote.getX()){
                Collections.swap(lista, i, pos);
                pos++;
            }
        }

        Collections.swap(lista, pos, ultimo);
        quicksort(lista, 1, pos-1);
        quicksort(lista, pos+1, ultimo);
    }

}
