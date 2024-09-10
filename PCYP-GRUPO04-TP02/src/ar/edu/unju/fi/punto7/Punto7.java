package ar.edu.unju.fi.punto7;

import java.util.Random;

public class Punto7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] sopa = new char[12][12];

        // Lista de palabras
        String[] palabras = {
            "CAMELLO", "ELEFANTE", "AGUILA", "CAMALEON", "AVESTRUZ",
            "COCODRILO", "ANTILOPE", "SERPIENTE", "BUFALO", "COMADREJA"
        };

        // Colocar las palabras en la sopa
        colocarPalabras(sopa, palabras);

        // Rellenar los espacios vacíos con caracteres aleatorios
        rellenarEspacios(sopa);

        // Mostrar la sopa de letras
        mostrarSopa(sopa);
    }

    // Función para colocar las palabras en la sopa
    public static void colocarPalabras(char[][] sopa, String[] palabras) {
        Random random = new Random();
        for (String palabra : palabras) {
            boolean colocada = false;

            // Intentar colocar la palabra hasta que se coloque correctamente
            while (!colocada) {
                int fila = random.nextInt(12);
                int columna = random.nextInt(12);
                int direccion = random.nextInt(4); // 0: horizontal, 1: vertical, 2: diagonal, 3: invertida

                colocada = colocarPalabra(sopa, palabra, fila, columna, direccion);
            }
        }
    }

    // Función para intentar colocar una palabra en la sopa en la posición y dirección dadas
    public static boolean colocarPalabra(char[][] sopa, String palabra, int fila, int columna, int direccion) {
        int longitud = palabra.length();

        // Verificar si la palabra cabe en la dirección seleccionada
        switch (direccion) {
            case 0: // Horizontal derecha
                if (columna + longitud > 12) return false;
                for (int i = 0; i < longitud; i++) {
                    if (sopa[fila][columna + i] != '\u0000' && sopa[fila][columna + i] != palabra.charAt(i)) {
                        return false;
                    }
                }
                for (int i = 0; i < longitud; i++) {
                    sopa[fila][columna + i] = palabra.charAt(i);
                }
                break;
            case 1: // Vertical hacia abajo
                if (fila + longitud > 12) return false;
                for (int i = 0; i < longitud; i++) {
                    if (sopa[fila + i][columna] != '\u0000' && sopa[fila + i][columna] != palabra.charAt(i)) {
                        return false;
                    }
                }
                for (int i = 0; i < longitud; i++) {
                    sopa[fila + i][columna] = palabra.charAt(i);
                }
                break;
            case 2: // Diagonal hacia abajo
                if (fila + longitud > 12 || columna + longitud > 12) return false;
                for (int i = 0; i < longitud; i++) {
                    if (sopa[fila + i][columna + i] != '\u0000' && sopa[fila + i][columna + i] != palabra.charAt(i)) {
                        return false;
                    }
                }
                for (int i = 0; i < longitud; i++) {
                    sopa[fila + i][columna + i] = palabra.charAt(i);
                }
                break;
            case 3: // Invertida (de derecha a izquierda)
                if (columna - longitud < 0) return false;
                for (int i = 0; i < longitud; i++) {
                    if (sopa[fila][columna - i] != '\u0000' && sopa[fila][columna - i] != palabra.charAt(i)) {
                        return false;
                    }
                }
                for (int i = 0; i < longitud; i++) {
                    sopa[fila][columna - i] = palabra.charAt(i);
                }
                break;
        }
        return true;
    }

    // Función para rellenar los espacios vacíos con caracteres aleatorios
    public static void rellenarEspacios(char[][] sopa) {
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (sopa[i][j] == '\u0000') {
                    sopa[i][j] = (char) (random.nextInt(26) + 'A'); // Letras aleatorias
                }
            }
        }
    }

    // Función para mostrar la sopa de letras
    public static void mostrarSopa(char[][] sopa) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(sopa[i][j] + " ");
            }
            System.out.println();
        }
    }
}