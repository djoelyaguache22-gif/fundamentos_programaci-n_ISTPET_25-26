package Calculadora;

import java.util.Scanner;

public class CalculadoraSwitch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el Primer numero");
		Integer numero1 = sc.nextInt();
		
		System.out.println("Ingrese el Segundo numero");
		Integer numero2 = sc.nextInt();
		
		System.out.println("Ingrese Opcion");
		String operacion = sc.next();
		
		switch (operacion) {
		
		case "suma":
			Integer suma = numero1 + numero2;
			System.out.println("Es resultado es:"+ suma);
			break;
		case "resta":
			Integer resta = numero1 - numero2;
			System.out.println("El resultado es:"+ resta);
			break;
		case "multiplicacion":
			Integer multiplicacion = numero1 * numero2;
			System.out.println("El resultado es:"+ multiplicacion);
			break;
		case "division":
			Integer division = numero1/numero2;
			System.out.println("El resultado es:"+ division);
			break;
			default:
				System.out.println("No se encuentra esa operacion");
		sc.close();
		
		}

	}

}
