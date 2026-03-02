package PracticoS14;

import java.util.*;

public class LectorConsola {
	    private static Scanner sc = new Scanner(System.in);

	    public static int leerEntero(String mensaje, int min, int max) {
	        int intentos = 0;
	        while (intentos < 3) {
	            try {
	                System.out.print(mensaje);
	                int valor = Integer.parseInt(sc.nextLine());
	                if (valor >= min && valor <= max) return valor;
	                System.out.println("Fuera de rango.");
	            } catch (NumberFormatException e) {
	                System.out.println("Error: Debe ingresar un número entero.");
	            }
	            intentos++;
	        }
	        return -1;
	    }
	}
