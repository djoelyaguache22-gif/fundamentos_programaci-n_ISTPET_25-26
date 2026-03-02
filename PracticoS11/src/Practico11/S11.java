package Practico11;

import java.util.Scanner;
import java.util.Date;

public class S11 {
		
		    private static final int MAX_CLIENTES = 12;
		    private static final String REGEX_CEDULA = "\\d{10}"; // 10 dígitos
		    private static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";

		    private static String[] nombres = new String[MAX_CLIENTES];
		    private static String[] cedulas = new String[MAX_CLIENTES];
		    private static String[] emails = new String[MAX_CLIENTES];
		    private static int contadorClientes = 0;
		    private static Scanner sc = new Scanner(System.in);

		    public static void main(String[] args) {
		        inicializarSistema();
		        menuPrincipal();
		    }

		    public static void inicializarSistema() {
		        for (int i = 0; i < MAX_CLIENTES; i++) {
		            nombres[i] = null;
		            cedulas[i] = null;
		            emails[i] = null;
		        }
		        System.out.println("Sistema inicializado correctamente.");
		    }

		    public static boolean agregarCliente(String nombre, String cedula, String email) {
		        if (contadorClientes >= MAX_CLIENTES) {
		            System.out.println("Error: Sistema lleno.");
		            return false;
		        }
		        if (nombre.isEmpty() || cedula.isEmpty() || email.isEmpty()) {
		            System.out.println("Error: Datos incompletos.");
		            return false;
		        }
		        if (buscarPorCedula(cedula) != -1) {
		            System.out.println("Error: Cédula duplicada.");
		            return false;
		        }
		        if (!email.contains("@")) {
		            System.out.println("Error: Email inválido.");
		            return false;
		        }

		        nombres[contadorClientes] = nombre;
		        cedulas[contadorClientes] = cedula;
		        emails[contadorClientes] = email;
		        contadorClientes++;
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
		        }
		    }

		    public static void listarClientesConEncabezado() {
		        System.out.println("REPORTE DE CLIENTES");
		        System.out.println("Fecha: " + new Date());
		        System.out.println("Total: " + contadorClientes + " | Disponible: " + (MAX_CLIENTES - contadorClientes));
		        listarClientes();
		    }

		    public static int buscarPorCedula(String cedula) {
		        for (int i = 0; i < contadorClientes; i++) {
		            if (cedulas[i].equals(cedula)) return i;
		        }
		        return -1;
		    }

		    public static void buscarCliente(String criterio) {
		        if (criterio.matches("\\d+")) {
		            int idx = buscarPorCedula(criterio);
		            if (idx != -1) {
		                System.out.println("Encontrado: " + nombres[idx] + " [" + cedulas[idx] + "]");
		            } else {
		                System.out.println("No se encontró la cédula.");
		            }
		        } else {
		            System.out.println("Coincidencias por nombre:");
		            for (int i = 0; i < contadorClientes; i++) {
		                if (nombres[i].toLowerCase().contains(criterio.toLowerCase())) {
		                    System.out.println("- " + nombres[i] + " (Céd: " + cedulas[i] + ")");
		                }
		            }
		        }
		    }

		    public static void editarClienteInteractivo() {
		        System.out.print("Ingrese cédula del cliente a editar: ");
		        String ced = sc.nextLine();
		        int idx = buscarPorCedula(ced);

		        if (idx == -1) {
		            System.out.println("Cliente no encontrado.");
		            return;
		        }

		        System.out.println("Editando a: " + nombres[idx]);
		        System.out.print("Nuevo nombre (Enter para omitir): ");
		        String nNombre = sc.nextLine();
		        if (!nNombre.isEmpty()) nombres[idx] = nNombre;

		        System.out.print("Nuevo email (Enter para omitir): ");
		        String nEmail = sc.nextLine();
		        if (!nEmail.isEmpty() && nEmail.contains("@")) emails[idx] = nEmail;

		        System.out.println("Datos actualizados con éxito.");
		    }
		    public static void eliminarClientePorCedula(String cedula) {
		        int idx = buscarPorCedula(cedula);
		        if (idx == -1) {
		            System.out.println("No existe el cliente.");
		            return;
		        }

		        System.out.print("¿Seguro que desea eliminar a " + nombres[idx] + "? (s/n): ");
		        if (sc.nextLine().equalsIgnoreCase("s")) {
		            for (int i = idx; i < contadorClientes - 1; i++) {
		                nombres[i] = nombres[i + 1];
		                cedulas[i] = cedulas[i + 1];
		                emails[i] = emails[i + 1];
		            }
		            nombres[contadorClientes - 1] = null;
		            cedulas[contadorClientes - 1] = null;
		            emails[contadorClientes - 1] = null;
		            contadorClientes--;
		            System.out.println("Cliente eliminado.");
		        }
		    }

		    public static void menuPrincipal() {
		        int opcion;
		        do {
		            System.out.println("SISTEMA GESTIÓN CLIENTES");
		            System.out.println("1. Agregar Cliente  2. Listar Clientes  3. Estadísticas");
		            System.out.println("4. Buscar Cliente   5. Editar Cliente   6. Eliminar Cliente  7. Salir");
		            System.out.print("Seleccione: ");
		            opcion = Integer.parseInt(sc.nextLine());

		            switch (opcion) {
		                case 1:
		                    System.out.print("Nombre: "); String n = sc.nextLine();
		                    System.out.print("Cédula: "); String c = sc.nextLine();
		                    System.out.print("Email: "); String e = sc.nextLine();
		                    if (agregarCliente(n, c, e)) System.out.println("Éxito.");
		                    break;
		                case 2: listarClientesConEncabezado(); break;
		                case 3:
		                    double uso = (contadorClientes * 100.0) / MAX_CLIENTES;
		                    System.out.println("Total: " + contadorClientes + " | Capacidad: " + MAX_CLIENTES + " | Uso: " + uso + "%");
		                    break;
		                case 4:
		                    System.out.print("Criterio (Nombre o Cédula): ");
		                    buscarCliente(sc.nextLine());
		                    break;
		                case 5: editarClienteInteractivo(); break;
		                case 6:
		                    System.out.print("Cédula a eliminar: ");
		                    eliminarClientePorCedula(sc.nextLine());
		                    break;
		            }
		        } while (opcion != 7);
		    }
		}