package ar.edu.unju.fi.punto3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Punto3 {

	 public static void main(String[] args) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate fechaActual = LocalDate.now(); 
	        System.out.println("Fecha actual: " + fechaActual.format(formatter));
	        for (int i = 0; i <= 100; i++) {
	            LocalDate nuevaFecha = fechaActual.plusYears(i);
	            // Obtener el día de la semana
	            String diaSemana = nuevaFecha.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
	            System.out.println("Fecha " + nuevaFecha.format(formatter) + " día " + diaSemana);
	        }
	    }

}
