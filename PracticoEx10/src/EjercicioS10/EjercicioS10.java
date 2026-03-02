package EjercicioS10;

import java.util.Date; 
import java.util.Scanner;

public class EjercicioS10 {
	
	// Estructura del sistema con arreglos paralelos
	
	public static final int MAX_CLIENTES = 100;
    public static final String FORMATO_CEDULA = "\\d{10}";
    public static final String FORMATO_EMAIL = "^[\\w.-]+@[\\w.-]+\\.\\w+$";
    static String[] nombres = new String [MAX_CLIENTES];
    static String[] cedulas = new String [MAX_CLIENTES];
    static String[] emails = new String [MAX_CLIENTES];
    static int contadorClientes = 0;

    public static void inicializarSistema() {
        for (int i = 0; i < MAX_CLIENTES; i++) {
            nombres[i] = "";
            cedulas[i] = "";
            emails[i] = "";
        }
        contadorClientes = 0;
        System.out.println("Sistema inicializado correctamente.");
    }

    public static boolean agregarCliente(String nombre, String cedula, String email) {
        if (nombre == null || nombre.isEmpty() || cedula == null || cedula.isEmpty() || email == null || email.isEmpty()) {
            System.out.println("Error: Datos incompletos.");
            return false;
        }

        if (contadorClientes >= MAX_CLIENTES) {
            System.out.println("Error: Sistema lleno.");
            return false;
        }

        for (int i = 0; i < contadorClientes; i++) {
            if (cedulas[i].equals(cedula)) {
                System.out.println("Error: Cedula duplicada.");
                return false;
            }
        }
        
        if (!email.contains("@")) {
            System.out.println("Error: Email invalido.");
            return false;
        }
        
        nombres[contadorClientes] = nombre;
        cedulas[contadorClientes] = cedula;
        emails[contadorClientes] = email;
        contadorClientes++;
        System.out.println("Cliente agregado con exito.");
        return true;
    }

    public static void listarClientes() {
        if (contadorClientes == 0) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (int i = 0; i < contadorClientes; i++) {
            System.out.println("Cliente #" + (i + 1));
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Cédula: " + cedulas[i]);
            System.out.println("Email: " + emails[i]);
            System.out.println("---"); 
        }
    }

    //Lista clientes con encabezado de estadísticas del sistema.
    public static void listarClientesConEncabezado() {
        System.out.println("Estadisticas del Sistema ");
        System.out.println("Fecha de listado: " + new Date());
        System.out.println("Capacidad total: " + MAX_CLIENTES);
        System.out.println("Total de clientes registrados: " + contadorClientes);
        System.out.println("Capacidad disponible: " + (MAX_CLIENTES - contadorClientes));
        double porcentajeUso = (double) contadorClientes / MAX_CLIENTES * 100;
        System.out.printf("Porcentaje de uso: %.2f%%%n", porcentajeUso);

        listarClientes();
    }


    public static void main(String[] args) {
        inicializarSistema();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menu Principal ");
            System.out.println("1. Agregar nuevo cliente");
            System.out.println("2. Listar todos los clientes");
            System.out.println("3. Mostrar estadísticas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese cédula: ");
                        String cedula = scanner.nextLine();
                        System.out.print("Ingrese email: ");
                        String email = scanner.nextLine();
                        agregarCliente(nombre, cedula, email);
                        break;
                    case 2:
                        listarClientes();
                        break;
                    case 3:
                        listarClientesConEncabezado();
                        break;
                    case 4:
                        System.out.println("¿Está seguro que desea salir? (S/N)");
                        String confirmacion = scanner.nextLine();
                        if (confirmacion.equalsIgnoreCase("S")) {
                            salir = true;
                            System.out.println("Saliendo del sistema.");
                        }
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 4.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}

