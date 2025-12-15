package JuegoAdivinanza;

import java.util.Scanner;
import java.util.Random;

public class Adivinanza {

	public static void main(String[] args) {
		     
		 Random random = new Random();
		 int Numero = random.nextInt(100) + 1;
		        
		 Scanner sc = new Scanner(System.in);
		 int intentoU;
		 int intentosR = 0;
		 final int intentos = 10; 
		 boolean adivinado = false;

		 System.out.println("Juego de Adivinanza de Números.");
		 System.out.println("Adivina un numero entre 1 y 100. Tienes " + intentos + " intentos.");

		 while (intentosR < intentos) {
		 System.out.print("Intentos: ");
		 intentoU = sc.nextInt();
		 intentosR++;

		 if (intentoU == Numero) {
		 adivinado = true;
		 break;
		 } else if (intentoU < Numero) {
		 System.out.println("El numero es mayor.");
		 } else {
		 System.out.println("El numero es menor.");
		}
	}
		        
		 if (adivinado) {
		 System.out.println("Adivinaste el número en " + intentosR + " intentos.");
		 } else {
		 System.out.println("No tienes más intentos. El número correcto era: " + Numero);
		}
         sc.close();
			}

	}
