package Practico13;

		import java.io.*;
		import java.nio.file.*;
		import java.util.*;

		public class Practico13 {
		    // Ejercicio 1
		    static final int MAX_CLIENTES = 100;
		    static String[] nombres = new String[MAX_CLIENTES];
		    static String[] cedulas = new String[MAX_CLIENTES];
		    static String[] emails = new String[MAX_CLIENTES];
		    static String[] categorias = new String[MAX_CLIENTES]; 
		    static int contadorClientes = 0;

		    static final String CAT_PREMIUM = "Premium";
		    static final String CAT_REGULAR = "Regular";
		    static final String CAT_NUEVO = "Nuevo";

		    public static void main(String[] args) {
		        menuPrincipal();
		    }

		    public static boolean agregarCliente(String nombre, String cedula, String email, String categoria) {
		        if (contadorClientes < MAX_CLIENTES) {
		            nombres[contadorClientes] = nombre;
		            cedulas[contadorClientes] = cedula;
		            emails[contadorClientes] = email;
		            categorias[contadorClientes] = (categoria == null || categoria.isEmpty()) 
		                                            ? asignarCategoriaAutomatica(nombre, email) 
		                                            : categoria;
		            contadorClientes++;
		            return true;
		        }
		        return false;
		    }

		    public static String asignarCategoriaAutomatica(String nombre, String email) {
		        if (nombre.toUpperCase().contains("S.A.") || email.contains("@empresa.com")) {
		            return CAT_PREMIUM;
		        }
		        return CAT_NUEVO;
		    }

		    // --- EJERCICIO 2: Persistencia por Categoría ---

		    public static void guardarClientesPorCategoria() {
		        String[] catsExistentes = {CAT_PREMIUM, CAT_REGULAR, CAT_NUEVO};
		        
		        for (String cat : catsExistentes) {
		            String nombreArchivo = "clientes_" + cat.toLowerCase() + ".txt";
		            try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
		                for (int i = 0; i < contadorClientes; i++) {
		                    if (categorias[i].equalsIgnoreCase(cat)) {
		                        writer.println(nombres[i] + "," + cedulas[i] + "," + emails[i] + "," + categorias[i]);
		                    }
		                }
		            } catch (IOException e) {
		                System.err.println("Error al guardar categoría " + cat + ": " + e.getMessage());
		            }
		        }
		        System.out.println("Sincronización de archivos completada.");
		    }

		    public static void cargarClientesDesdeCategorias() {
		        contadorClientes = 0;
		        File carpeta = new File(".");
		        File[] archivos = carpeta.listFiles((dir, name) -> name.startsWith("clientes_") && name.endsWith(".txt"));

		        if (archivos != null) {
		            for (File archivo : archivos) {
		                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
		                    String linea;
		                    while ((linea = br.readLine()) != null) {
		                        String[] datos = linea.split(",");
		                        if (datos.length == 4) {
		                            agregarCliente(datos[0], datos[1], datos[2], datos[3]);
		                        }
		                    }
		                } catch (IOException e) {
		                    System.out.println("Error leyendo: " + archivo.getName());
		                }
		            }
		        }
		    }

		    // --- EJERCICIO 3: Gestión y Filtros ---

		    public static void listarClientesPorCategoria(String categoriaBusqueda) {
		        System.out.println("\n--- LISTADO DE CLIENTES: " + categoriaBusqueda.toUpperCase() + " ---");
		        int count = 0;
		        for (int i = 0; i < contadorClientes; i++) {
		            if (categorias[i].equalsIgnoreCase(categoriaBusqueda)) {
		                System.out.printf("ID: %d | Nombre: %s | Cédula: %s%n", i, nombres[i], cedulas[i]);
		                count++;
		            }
		        }
		        System.out.println("Total encontrados: " + count);
		    }

		    public static void cambiarCategoriaCliente(int indice, String nuevaCategoria) {
		        if (indice >= 0 && indice < contadorClientes) {
		            categorias[indice] = nuevaCategoria;
		            System.out.println("Categoría actualizada. Recuerde guardar los cambios.");
		        }
		    }

		    // --- EJERCICIO 4: Interfaz y Backup ---

		    public static void menuPrincipal() {
		        Scanner sc = new Scanner(System.in);
		        int opcion;

		        do {
		            System.out.println("Gestion de Clientes: Categorias");
		            System.out.println("1. Agregar nuevo cliente");
		            System.out.println("2. Listar todos los clientes");
		            System.out.println("3. Listar clientes por categoría");
		            System.out.println("4. Editar cliente");
		            System.out.println("5. Guardar datos");
		            System.out.println("6. Cargar datos");
		            System.out.println("7. Crear Backup");
		            System.out.println("10. Salir");
		            System.out.print("Seleccione: ");
		            opcion = sc.nextInt();
		            sc.nextLine(); 

		            switch (opcion) {
		                case 1:
		                    System.out.print("Nombre: "); String n = sc.nextLine();
		                    System.out.print("Cédula: "); String c = sc.nextLine();
		                    System.out.print("Email: "); String e = sc.nextLine();
		                    agregarCliente(n, c, e, ""); 
		                    break;
		                case 3:
		                    System.out.print("Ingrese categoría (Premium/Regular/Nuevo): ");
		                    listarClientesPorCategoria(sc.nextLine());
		                    break;
		                case 5:
		                    guardarClientesPorCategoria();
		                    break;
		                case 7:
		                    generarBackup();
		                    break;
		            }
		        } while (opcion != 10);
		    }

		    public static void generarBackup() {
		        String carpetaBackup = "backup_" + System.currentTimeMillis();
		        File dir = new File(carpetaBackup);
		        if (dir.mkdir()) {
		            System.out.println("Backup creado exitosamente en: " + carpetaBackup);
		        }
		    }
		}


