package ar.edu.unju.fi.archivo.programacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Punto2 {

    public static void main(String[] args) {
        String rutaArchivoLectura = "C:\\Users\\ricky\\Downloads\\TP01Frase.txt";
        String rutaArchivoEscritura = "C:\\PCYP-GRUPOXX-TP02\\Punto02.txt"; 
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        int espacios = 0;
        int palabras = 0;
        int mayusculas = 0;
        int lineas = 0;
        int signosPuntuacion = 0;
        StringBuilder nuevoTexto = new StringBuilder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoLectura));
             BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoEscritura, true))) {
            
            int caracter = br.read();
            boolean esInicioPalabra = true;

            while (caracter != -1) {
                char c = (char) caracter;

                // Contar vocales
                if (c == 'a' || c == 'A') a++;
                if (c == 'e' || c == 'E') e++;
                if (c == 'i' || c == 'I') i++;
                if (c == 'o' || c == 'O') o++;
                if (c == 'u' || c == 'U') u++;

                // Contar espacios y palabras
                if (c == ' ') {
                    espacios++;
                    esInicioPalabra = true;
                } else if (esInicioPalabra && Character.isLetterOrDigit(c)) {
                    palabras++;
                    esInicioPalabra = false;
                }

                // Contar mayúsculas
                if (Character.isUpperCase(c)) mayusculas++;

                // Contar líneas
                if (c == '\n') lineas++;

                // Contar signos de puntuación
                if (".,;:!?-'\"()".indexOf(c) != -1) signosPuntuacion++;

                // Modificar vocales
                if ("aeiouAEIOU".indexOf(c) != -1) c = (char) (c + 20);

                nuevoTexto.append(c);
                caracter = br.read();
            }

            if (lineas == 0 || nuevoTexto.charAt(nuevoTexto.length() - 1) != '\n') lineas++;

            // Obtener fecha y hora actual
            String fechaHoraActual = LocalDateTime.now().format(formatter);

            // Escribir resultados en el archivo
            bw.write("[" + fechaHoraActual + "] Cantidad de A/a: " + a + "\n");
            bw.write("[" + fechaHoraActual + "] Cantidad de E/e: " + e + "\n");
            bw.write("[" + fechaHoraActual + "] Cantidad de I/i: " + i + "\n");
            bw.write("[" + fechaHoraActual + "] Cantidad de O/o: " + o + "\n");
            bw.write("[" + fechaHoraActual + "] Cantidad de U/u: " + u + "\n");
            bw.write("[" + fechaHoraActual + "] Cantidad de espacios en blanco: " + espacios + "\n");
            bw.write("[" + fechaHoraActual + "] Cantidad de palabras: " + palabras + "\n");
            bw.write("[" + fechaHoraActual + "] Cantidad de letras mayúsculas: " + mayusculas + "\n");
            bw.write("[" + fechaHoraActual + "] Cantidad de líneas: " + lineas + "\n");
            bw.write("[" + fechaHoraActual + "] Cantidad de signos de puntuación: " + signosPuntuacion + "\n\n");

            bw.write("[" + fechaHoraActual + "] Nuevo contenido del archivo:\n");
            bw.write(nuevoTexto.toString() + "\n");

            System.out.println("Resultados escritos en el archivo: " + rutaArchivoEscritura);
        } catch (IOException p) {
            p.printStackTrace();
        }
    }
}
