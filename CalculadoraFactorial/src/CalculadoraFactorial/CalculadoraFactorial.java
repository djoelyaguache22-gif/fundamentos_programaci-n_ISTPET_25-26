package CalculadoraFactorial;

import java.util.Scanner;

public class CalculadoraFactorial {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
        System.out.print("Ingrese un número entero no negativo: ");
        int numero = scanner.nextInt();
        
        if (numero < 0) {
            System.out.println("Error: El numero ingresado no puede ser negativo");
        } else {
        	
            long factorialFor = calcularFactorial(numero);
            System.out.println("El factorial de " + numero + " es: " + factorialFor);
        }
        scanner.close();
    }
    public static long calcularFactorial(int n) {
    	
        if (n == 0) return 1;
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}    
