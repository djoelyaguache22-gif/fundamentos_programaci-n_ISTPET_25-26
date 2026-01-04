package CalculadoraSobrecarga;

import java.util.Scanner;

public class CalculadoraSobrecarga {

		    public int sumar(int a, int b) { return a + b; }

		    public double sumar(double a, double b) { return a + b; }

		    public int sumar(int a, int b, int c) { return a + b + c; }

		    public int multiplicar(int a, int b) { return a * b; }

		    public double multiplicar(double a, double b) { return a * b; }

		    public double multiplicar(int a, double b) { return a * b; }

		    public double calcularArea(double radio) { 
		        return Math.PI * Math.pow(radio, 2); 
		    }

		    public double calcularArea(double base, double altura) { 
		        return base * altura; 
		    }

		    public double calcularArea(double base, double altura, boolean esTriangulo) {
		        return (base * altura) / 2;
		    }

		    public static void main(String[] args) {
		        CalculadoraSobrecarga calc = new CalculadoraSobrecarga();
		        Scanner sc = new Scanner(System.in);
		        int opcion;

		        do {
		            System.out.println("Selecciona");
		            System.out.println("1. Sumar (int, int)");
		            System.out.println("2. Sumar (double, double)");
		            System.out.println("3. Sumar (int, int, int)");
		            System.out.println("4. Multiplicar (int, double)");
		            System.out.println("5. Área Círculo");
		            System.out.println("6. Área Rectángulo");
		            System.out.println("7. Área Triángulo");
		            System.out.println("0. Salir");
		            System.out.print("Seleccione: ");
		            opcion = sc.nextInt();

		            switch (opcion) {
		                case 1 -> System.out.println("Resultado: " + calc.sumar(5, 10));
		                case 2 -> System.out.println("Resultado: " + calc.sumar(5.5, 10.2));
		                case 3 -> System.out.println("Resultado: " + calc.sumar(1, 2, 3));
		                case 4 -> System.out.println("Resultado: " + calc.multiplicar(5, 2.5));
		                case 5 -> {
		                    System.out.print("Radio: ");
		                    double r = sc.nextDouble();
		                    System.out.printf("Área Círculo: %.2f\n", calc.calcularArea(r));
		                }
		                case 6 -> System.out.println("Área Rectángulo (10x5): " + calc.calcularArea(10.0, 5.0));
		                case 7 -> System.out.println("Área Triángulo (10x5): " + calc.calcularArea(10.0, 5.0, true));
		            }
		        } while (opcion != 0);
		        
		        sc.close();
		
	}

}
