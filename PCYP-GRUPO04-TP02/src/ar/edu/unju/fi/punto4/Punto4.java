package ar.edu.unju.fi.punto4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Punto4 {

	public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\ricky\\Downloads\\TP01Frase.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int longitudLinea;
            int totalLineas = 0;
            int lineasCortas = 0;
            int lineasLargas = 0;

            String lineaMasCorta = null;
            String lineaMasLarga = null;
            int longitudMasCorta = Integer.MAX_VALUE;
            int longitudMasLarga = Integer.MIN_VALUE;

            while ((linea = br.readLine()) != null) {
                longitudLinea = linea.length();
                totalLineas++;

                if (longitudLinea < 50) { 
                    lineasCortas++;
                } else {
                    lineasLargas++;
                }

                
                if (longitudLinea < longitudMasCorta) {
                    longitudMasCorta = longitudLinea;
                    lineaMasCorta = linea;
                }

                if (longitudLinea > longitudMasLarga) {
                    longitudMasLarga = longitudLinea;
                    lineaMasLarga = linea;
                }
            }
            System.out.println("Número de líneas cortas: " + lineasCortas);
            System.out.println("Número de líneas largas: " + lineasLargas);
            System.out.println("Línea más corta (" + longitudMasCorta + " caracteres):");
            System.out.println(lineaMasCorta);
            System.out.println("Línea más larga (" + longitudMasLarga + " caracteres):");
            System.out.println(lineaMasLarga);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
