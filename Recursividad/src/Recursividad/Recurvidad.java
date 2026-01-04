package Recursividad;

import java.math.BigInteger;
import java.util.Scanner;

public class Recurvidad {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número para calcular factorial (ej. 5): ");
        int num = sc.nextInt();

        compararFactoriales(num);
        
        System.out.println("Otras Funciones Recursivas");
        System.out.println("Fibonacci (" + num + "): " + fibonacci(num));
        System.out.println("Suma de dígitos de 1234: " + sumaDigitos(1234));
        System.out.println("Potencia (2^" + num + "): " + potencia(2, num));
        
        sc.close();
    }
    public static BigInteger factorialIterativo(int n) {
        if (n < 0) return BigInteger.valueOf(-1);
        BigInteger resultado = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }
    public static BigInteger factorialRecursivo(int n) {
        if (n < 0) return BigInteger.valueOf(-1);
        
        // CASO BASE: factorial(0) = 1, factorial(1) = 1
        if (n <= 1) {
            System.out.println("Alcanzado caso base: factorial(" + n + ") = 1");
            return BigInteger.ONE;
        }
        System.out.println("  Llamada recursiva: " + n + " * factorial(" + (n - 1) + ")");
        return BigInteger.valueOf(n).multiply(factorialRecursivo(n - 1));
    }
    public static void compararFactoriales(int n) {
        if (n < 0) {
            System.out.println("ERROR: No se permiten números negativos.");
            return;
        }
        if (n > 1000) {
            System.out.println("ERROR: El valor es demasiado grande para recursión.");
            return;
        }

        System.out.println("Calculando Factorial de " + n + "...");
        
        System.out.println("PROCESO RECURSIVO:");
        BigInteger resRec = factorialRecursivo(n);
        
        BigInteger resIte = factorialIterativo(n);

        System.out.println("Resultados:");
        System.out.println("Versión Iterativa: " + resIte);
        System.out.println("Versión Recursiva: " + resRec);
        System.out.println("¿Coinciden?: " + (resRec.equals(resIte) ? "SÍ" : "NO"));
    }
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static int sumaDigitos(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumaDigitos(n / 10);
    }
    public static double potencia(double base, int exponente) {
        if (exponente == 0) return 1;
        if (exponente < 0) return 1 / potencia(base, -exponente);
        return base * potencia(base, exponente - 1);
 
	}

}
