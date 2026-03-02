package EjercicioS11;

import java.util.Scanner;

public class S11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("¿Cuántos números desea ingresar?: ");
        int n = scanner.nextInt();
        int[] numeros = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        int mayor = numeros[0];
        int menor = numeros[0];
        System.out.print("\nValores ingresados: ");
        for (int num : numeros) {
            System.out.print(num + " ");
            if (num > mayor) mayor = num;
            if (num < menor) menor = num;
        }
        System.out.println("\nNúmero mayor: " + mayor);
        System.out.println("Número menor: " + menor);
        scanner.nextLine();
        System.out.print("\nIngrese una cadena de texto: ");
        String texto = scanner.nextLine();
        System.out.println("Longitud: " + texto.length());
        System.out.println("Mayúsculas: " + texto.toUpperCase());
        System.out.println("Minúsculas: " + texto.toLowerCase());
        
        int vocales = 0;
        for (char c : texto.toLowerCase().toCharArray()) {
            if ("aeiouáéíóú".indexOf(c) != -1) vocales++;
        }
        System.out.println("Número de vocales: " + vocales);
        String[] nombres = {"Ana", "Pedro", "Maria", "Juan", "Luis"};
        System.out.print("\nIngrese el nombre a buscar en el sistema: ");
        String nombreBuscar = scanner.nextLine();
        
        boolean encontrado = false;
        for (String nombre : nombres) {
            if (nombre.equalsIgnoreCase(nombreBuscar)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("Resultado: El nombre '" + nombreBuscar + "' fue encontrado.");
        } else {
            System.out.println("Resultado: El nombre no existe en el arreglo.");
        }
        
        scanner.close();

	}

}
