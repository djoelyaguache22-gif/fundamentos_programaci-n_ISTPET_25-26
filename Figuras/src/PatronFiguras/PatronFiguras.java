package PatronFiguras;

import java.util.Scanner;

public class PatronFiguras {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("Menu de patrones");
            System.out.println("1. Triangulo rectangulo creciente");
            System.out.println("2. Triangulo rectangulo decreciente");
            System.out.println("3. Piramide centrada");
            System.out.println("4. Rombo completo");
            System.out.print("Seleccione una opción (1-5): ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                if (opcion >= 1 && opcion <= 4) {
                    System.out.print("Ingrese el número de filas (1-20): ");
                    int tamano = Integer.parseInt(sc.nextLine());

                    if (tamano >= 1 && tamano <= 20) {
                        switch (opcion) {
                            case 1:
                                imprimirTrianguloCreciente(tamano);
                                break;
                            case 2:
                                imprimirTrianguloDecreciente(tamano);
                                break;
                            case 3:
                                imprimirPiramideCentrada(tamano);
                                break;
                            case 4:
                                imprimirRomboCompleto(tamano);
                                break;
                        }
                    } else {
                        System.out.println("Error: El tamaño debe estar entre 1 y 20.");
                    }
                } else {
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
        sc.close();
    }
    public static void imprimirTrianguloCreciente(int filas) {
        System.out.println("Triángulo Rectángulo Creciente (" + filas + " filas) ");
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); 
        }
    }
    public static void imprimirTrianguloDecreciente(int filas) {
        System.out.println("Triángulo Rectángulo Decreciente (" + filas + " filas) ");
        for (int i = filas; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); 
        }
    }
    public static void imprimirPiramideCentrada(int filas) {
        System.out.println("Pirámide Centrada (" + filas + " filas) ");
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= filas - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void imprimirRomboCompleto(int filas) {
        System.out.println("Rombo Completo (" + filas + " filas) ");
        
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= filas - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = filas - 1; i >= 1; i--) {
            for (int j = 1; j <= filas - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();

	}

}}
