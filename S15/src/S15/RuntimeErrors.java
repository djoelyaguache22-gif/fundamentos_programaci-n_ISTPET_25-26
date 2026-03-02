package S15;

import java.util.Scanner;
import java.util.InputMismatchException;

public class RuntimeErrors {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String[] nombres = new String[5];
	        int contador = 0;

	        //Validar si el elemento es nulo antes de medir longitud
	        if (nombres[0] != null) {
	            System.out.println("Longitud nombre: " + nombres[0].length());
	        } else {
	            System.out.println("El primer nombre aún no ha sido ingresado.");
	        }

	        //El límite debe ser estrictamente menor que el tamaño (i < 5)
	        for (int i = 0; i < nombres.length; i++) {
	            System.out.println("Ingrese nombre " + (i + 1) + ": ");
	            nombres[i] = scanner.nextLine();
	            contador++;
	        }

	        int promedio = contador > 0 ? 100 / contador : 0;

	        //Uso de Try-Catch para validar entrada numérica
	        int edad = 0;
	        try {
	            System.out.println("Ingrese edad: ");
	            String edadStr = scanner.nextLine();
	            edad = Integer.parseInt(edadStr);
	        } catch (NumberFormatException e) {
	            System.out.println("Error: No ingresaste un número válido para la edad.");
	        }

	        // Manejo de entrada para opciones
	        try {
	            System.out.println("Ingrese opción (número): ");
	            int opcion = scanner.nextInt();
	        } catch (InputMismatchException e) {
	            System.out.println("Error: La opción debe ser numérica.");
	        } finally {
	            scanner.close(); // Siempre cerrar el recurso al final
	        }
	    }
	}




