package Operaciones;

import java.util.Scanner;

public class Operaciones {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		System.out.print("Ingrese primer número:");
		int numero1 = sc.nextInt();
		
		System.out.print("Ingrese segundo numero:");
		int numero2 = sc.nextInt();
		
		int resultadosuma = suma(numero1, numero2); 
	    int resultadoresta = resta(numero1, numero2);
	    int resultadomultiplicacion = multiplicacion(numero1, numero2);
	    int resultadodivision = division(numero1, numero2);
	    
	    System.out.println("Suma:" + resultadosuma);
		System.out.println("Resta:"+ resultadoresta);
		System.out.println("Multiplicacion:" + resultadomultiplicacion);
		System.out.println("Division:" + resultadodivision);
		
		sc.close();
	}
	public static int suma (int numero1, int numero2) {
		int resultadosuma;
		resultadosuma = numero1 + numero2;
		return resultadosuma;
	}
	public static int resta (int numero1, int numero2) {
		int resultadoresta;
		resultadoresta = numero1 - numero2;
		return resultadoresta;
	}
	public static int multiplicacion (int numero1, int numero2) {
		int resultadomultiplicacion;
		resultadomultiplicacion = numero1 * numero2;
		return resultadomultiplicacion;
	}
	public static int division (int numero1, int numero2) {
		int resultadodivision;
		resultadodivision = numero1 / numero2;
		return resultadodivision;

	}

}
