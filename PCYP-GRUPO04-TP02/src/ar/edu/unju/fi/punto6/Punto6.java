package ar.edu.unju.fi.punto6;

import java.util.Scanner;

public class Punto6 {
	
	static int[][] matriz = new int[10][10];

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduce un numero entre 1 y 10: ");
		int numero = scanner.nextInt();
		
		if(numero < 1 || numero >10) {
			System.out.println("El numero debe estar entre 1 y 10");
		}else {
			completarFilaConTabla(numero);
			mostrarMatriz();
		}
		
		scanner.close();
		

	}
	// Función que completa la fila con la tabla de multiplicación del número dado
	public static void completarFilaConTabla(int numero) {
		for(int i=0;i<10;i++) {
			matriz[numero-1][i] = numero * (i+1);
		}
	}
	
	
	// Función para mostrar la matriz completa
	public static void mostrarMatriz() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.println(matriz[i][j]);
			}
			System.out.println();
		}
	}

}
