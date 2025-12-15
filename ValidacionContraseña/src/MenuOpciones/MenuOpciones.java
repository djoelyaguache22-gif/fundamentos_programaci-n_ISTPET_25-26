package MenuOpciones;

import java.util.Scanner;

public class MenuOpciones {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Menú de Opciones");
        System.out.println("1. Consulta");
        System.out.println("2. Realizar pago");
        System.out.println("3. Realizar retiro");
        System.out.println("4. Cerrar Sesion");
        System.out.print("Seleccione una opción: ");

        try {
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado 'Consulta'. Tu saldo actual es $100.00.");
                    break;
                case 2:
                    System.out.println("Has seleccionado 'Realizar pago'. Ingrese el monto a pagar.");
                    break;
                case 3:
                    System.out.println("Has seleccionado 'Realizar retiro'. Ingrese el monto a retirar.");
                    break;
                case 4:
                    System.out.println("Secion Cerrada");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione un número del 1 al 4.");
                    break;
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingrese un número entero.");
        } finally {
            scanner.close();
        }

	}

}
