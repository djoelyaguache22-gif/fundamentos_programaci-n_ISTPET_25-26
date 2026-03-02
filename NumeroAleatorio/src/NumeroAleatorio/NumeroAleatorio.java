package NumeroAleatorio;

import java.util.Scanner;
import java.util.Random;

public class NumeroAleatorio {

	    public static void main(String[] args) {
	        ejecutarJuego();
	    }

	    public static void ejecutarJuego() {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        
	        int rangoMinimo = 1;
	        int rangoMaximo = 100;
	        int numeroSecreto = random.nextInt(rangoMaximo - rangoMinimo + 1) + rangoMinimo;
	        
	        int intentoUsuario = 0;
	        int contadorIntentos = 0;
	        boolean haAcertado = false;

	        System.out.println("¡Juego de Adivinanza!");
	        System.out.println("Tu numero esta entre " + rangoMinimo + " y " + rangoMaximo + ".");
	        System.out.println("Adivina Cual es:");

	        while (!haAcertado) {
	            System.out.print("\nIntroduce tu número: ");
	            
	            if (scanner.hasNextInt()) {
	                intentoUsuario = scanner.nextInt();
	                contadorIntentos++;

	                if (intentoUsuario == numeroSecreto) {
	                    haAcertado = true;
	                    System.out.println("¡Felicidades! Has acertado.");
	                } else if (intentoUsuario < numeroSecreto) {
	                    System.out.println("El número secreto es MAYOR. Intenta de nuevo.");
	                } else {
	                    System.out.println("El número secreto es MENOR. Intenta de nuevo.");
	                }
	            } else {
	                System.out.println("Por favor, introduce un número válido.");
	                scanner.next(); // Limpiar el buffer
	            }
	        }

	        System.out.println("Juego terminado con éxito.");
	        System.out.println("Número de intentos totales: " + contadorIntentos);
	        
	        scanner.close();
	    }
	}

