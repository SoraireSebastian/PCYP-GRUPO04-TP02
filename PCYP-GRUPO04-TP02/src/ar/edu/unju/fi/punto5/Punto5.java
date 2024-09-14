package ar.edu.unju.fi.punto5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Punto5 {

	 public static void main(String[] args) {
	        String rutaArchivo = "C:\\Users\\ricky\\Downloads\\TP02Numeros.txt";
	        List<Integer> numeros = new ArrayList<>();
	        int suma = 0;

	        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
	            String linea;

	            while ((linea = br.readLine()) != null) {
	                
	                String[] elementos = linea.split("[^0-9-]+");

	                
	                for (String elem : elementos) {
	                    if (!elem.isEmpty()) {
	                        try {
	                            int numero = Integer.parseInt(elem);
	                            numeros.add(numero);
	                            suma += numero;
	                        } catch (NumberFormatException e) {
	                            
	                        }
	                    }
	                }
	            }
	            System.out.println("Cantidad de números encontrados: " + numeros.size());
	            System.out.println("Listado de números encontrados: " + numeros);
	            System.out.println("Total de la suma de los números: " + suma);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
