import java.util.*;
import java.io.*;

public class Dataset {

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                              Método para generar los datasets aleatorios                                      //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static List<Punto> generarDataset(){
        // Le decimos al programa el número de puntos que queremos crear
        int numPuntos = 50;

        // Creamos listaPuntos del tipo ArrayList
        List<Punto> listaPuntos = new ArrayList<>();
        for (int i = 0; i < numPuntos; i++){
            // Generamos aleatoriamente las coordenadas x e y
            double x = (Math.random() * 100);
            double y = (Math.random() * 100);

            // Añadimos a la lista de puntos el punto generad
            listaPuntos.add(new Punto(i,x,y));
        }

        // Devolvemos la lista de puntos generados
        return listaPuntos;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                   Método para escribir los datasets                                           //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void escribir(String nombre, List<Punto> listaPuntos) throws IOException{
        // Hayamos el tamaño de la lista que queremos guardar
        int dimension = listaPuntos.size();

        // Usamos 'try' por si hubiera algún fallo
        try {
            // Creamos escribir para usar los métodos de 'BufferedWriter' para guardar el fichero aleatorio
            BufferedWriter escribir = new BufferedWriter(new FileWriter(nombre + ".tsp"));

            // Damos los primeros puntos del dataset según nos indica el enunciado de la práctica
            escribir.write("NAME: " + nombre);
            escribir.newLine();
            escribir.write("TYPE: TSP");
            escribir.newLine();
            escribir.write("DIMENSION: " + dimension);
            escribir.newLine();
            escribir.write("EDGE_WEIGHT_TYPE: EUC_2D");
            escribir.newLine();
            escribir.write("NODE_COORD_SECTION");
            escribir.newLine();

            // Pasamos ahora a la parte de escribir cada uno de los puntos
            for (int i = 0; i < dimension; i++){
                escribir.write("\t" + listaPuntos.get(i).getID() + "\t" + listaPuntos.get(i).getX() + "\t" + listaPuntos.get(i).getY());
                escribir.newLine();
            }

            escribir.write("EOF");
            escribir.close();

            System.out.println("El fichero " + nombre + ".tsp se ha creado con éxito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                     Método para leer los datasets                                             //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    public static Punto[] lecturaFicheros(String nombre) throws FileNotFoundException {
//        BufferedReader lectura = new BufferedReader(new FileReader(nombre));
//
//        String linea;
//        int dimension = 0;
//        Punto[] tamano = null;
//
//        try {
//            while ((linea = lectura.readLine()) != null){
//
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                   Método para ordenar los datasets                                            //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void ordenaDataset(List<Punto> listaPuntos){
        Quicksort.sort(listaPuntos);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                    Método para copiar los datasets                                            //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static List<Punto> copia(List<Punto> dataset){
        List<Punto> listaCopiada = new ArrayList<Punto>(dataset.size());
        for (Punto p : dataset){
            listaCopiada.add(new Punto(p.getID(), p.getX(), p.getY()));
        }
        return listaCopiada;
    }
}
