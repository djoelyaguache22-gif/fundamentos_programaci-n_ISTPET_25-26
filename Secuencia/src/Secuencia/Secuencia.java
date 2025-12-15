package Secuencia;

import java.util.Scanner;

public class Secuencia {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
        int filas = 0;
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("Menu triangulo numerico");
            System.out.println("1. Generar triángulo normal");
            System.out.println("2. Generar triángulo invertido");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción (1-3): ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine());

                if (opcion >= 1 && opcion <= 2) {
                    System.out.print("Ingrese el numero de filas (máximo 15): ");
                    filas = Integer.parseInt(sc.nextLine());

                    if (filas > 0 && filas <= 15) {
                        if (opcion == 1) {
                            generartriangulo(filas);
                        } else {
                            trianguloinvertido(filas);
                        }
                    } else {
                        System.out.println("Error: El número de filas debe estar entre 1 y 15.");
                    }
                } else if (opcion == 3) {
                    System.out.println("Saliendo del programa");
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
        sc.close();
    }
    public static void Fila(int numeroFila, int totalFilas) {
        for (int i = 0; i < (totalFilas - numeroFila); i++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= numeroFila; j++) {
            System.out.print(j);
        }
        
        System.out.println(); 
    }
    public static void generartriangulo(int filas) {
        System.out.println("Triángulo Normal");
        for (int i = 1; i <= filas; i++) {
            Fila(i, filas);
        }
    }
    public static void trianguloinvertido(int filas) {
        System.out.println("Triángulo Invertido");
        for (int i = filas; i >= 1; i--) {
            Fila(i, filas);

	}

}}
