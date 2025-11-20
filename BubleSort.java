import java.io.*;
import java.util.ArrayList;

public class BubleSort {

    public static void main(String[] args) {

        
        String archivoEntrada = "C:/quick/nombres.txt";
        String archivoSalida = "C:/quick/salida.txt";

        try {
            // Nombre desde el archivo 
            String[] nombres = leerArchivo(archivoEntrada);

            if (nombres.length == 0) {
                System.out.println("El archivo está vacío.");
                escribirArchivo(archivoSalida, nombres);
                return;
            }

            // Ordeno con bubble sort pero con nombres 
            bubbleSort(nombres);

            // Escribo el resultado en el archivo final
            escribirArchivo(archivoSalida, nombres);

            System.out.println("Proceso completado. Revisa: " + archivoSalida);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    // Bubble sort pero comparando strings (nombres)
    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        boolean cambio;

        for (int i = 0; i < n - 1; i++) {
            cambio = false;

            for (int j = 0; j < n - 1 - i; j++) {

                // Aquí comparo cadenas alfabéticamente
                if (arr[j].compareToIgnoreCase(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    cambio = true;
                }
            }

            if (!cambio) break; // Si ya no hubo cambios, ya quedó ordenado
        }
    }

    // Lee todas las líneas del archivo y las mete a un arreglo
    public static String[] leerArchivo(String nombre) throws IOException {

        ArrayList<String> lista = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(nombre));
        String linea;

        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (!linea.isEmpty()) {
                lista.add(linea);
            }
        }

        br.close();

        return lista.toArray(new String[0]);
    }

    // Escribe cada nombre en una línea en el archivo de salida
    public static void escribirArchivo(String nombre, String[] datos) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));

        for (String s : datos) {
            bw.write(s);
            bw.newLine();
        }

        bw.close();
    }
}
