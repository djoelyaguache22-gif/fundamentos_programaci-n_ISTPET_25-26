package Tiempos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
	
public class Tiempos {
	  public static void main(String[] args) {

	        LocalDate hoy = LocalDate.now();
	        System.out.println("Fecha: " + hoy); 

	        DateTimeFormatter formatoEspanol = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String fechaEspanol = hoy.format(formatoEspanol);
	        System.out.println("dd/MM/yyyy: " + fechaEspanol);

	        DateTimeFormatter formatoISO = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String fechaISO = hoy.format(formatoISO);
	        System.out.println("yyyy-MM-dd: " + fechaISO);
	    }
	}