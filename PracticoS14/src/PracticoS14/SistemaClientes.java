package PracticoS14;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SistemaClientes {	
	class Cliente implements Serializable {
	    private String cedula;
	    private String nombre;
	    private String email;

	    public Cliente(String cedula, String nombre, String email) {
	        this.cedula = cedula;
	        this.nombre = nombre;
	        this.email = email;
	    }

	    @Override
	    public String toString() {
	        return String.format("ID: %s | Nombre: %-20s | Email: %s", cedula, nombre, email);
	    }
	    
	    public String toCSV() { return cedula + "," + nombre + "," + email; }
	    public String getCedula() { return cedula; }
	}

	    private List<Cliente> clientes = new ArrayList<>();
	    private final String ARCHIVO = "clientes.csv";
	    private final String LOG_ERROR = "errores.log";
	    private static final Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        SistemaClientes sistema = new SistemaClientes();
	        sistema.ejecutarMenu();
	    }

	    public void logError(String mensaje) {
	        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(LOG_ERROR, true)))) {
	            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	            out.println("[" + fecha + "] ERROR: " + mensaje);
	        } catch (IOException e) {
	            System.err.println("Error fatal: No se puede escribir en el log.");
	        }
	    }

	    public boolean guardarDatos() {
	        File original = new File(ARCHIVO);
	        File temp = new File("clientes_temp.csv");

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {
	            for (Cliente c : clientes) {
	                writer.write(c.toCSV());
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            logError("Error al guardar: " + e.getMessage());
	            return false;
	        }

	        if (original.exists()) original.delete();
	        return temp.renameTo(original);
	    }

	    public void cargarDatos() {
	        File file = new File(ARCHIVO);
	        if (!file.exists()) return;

	        List<Cliente> backupCarga = new ArrayList<>(clientes);
	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            clientes.clear();
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                try {
	                    String[] p = linea.split(",");
	                    if (p.length == 3) clientes.add(new Cliente(p[0], p[1], p[2]));
	                } catch (Exception e) {
	                    logError("Línea corrupta saltada: " + linea);
	                }
	            }
	        } catch (IOException e) {
	            logError("Error crítico de lectura: " + e.getMessage());
	            clientes = backupCarga; 
	        }
	    }

	    public static boolean validarCedula(String cedula) {
	        if (cedula == null || !cedula.matches("\\d{10}")) return false;
	        int suma = 0;
	        int[] coef = {2, 1, 2, 1, 2, 1, 2, 1, 2};
	        for (int i = 0; i < 9; i++) {
	            int v = Character.getNumericValue(cedula.charAt(i)) * coef[i];
	            suma += (v > 9) ? v - 9 : v;
	        }
	        int verificador = (suma % 10 == 0) ? 0 : 10 - (suma % 10);
	        return verificador == Character.getNumericValue(cedula.charAt(9));
	    }

	    public static boolean validarEmail(String email) {
	        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	    }

	    public static boolean validarNombre(String nombre) {
	        return nombre != null && nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]{3,50}$");
	    }

	    private int leerEntero(String msj, int min, int max) {
	        for (int i = 0; i < 3; i++) {
	            try {
	                System.out.print(msj);
	                int val = Integer.parseInt(sc.nextLine());
	                if (val >= min && val <= max) return val;
	            } catch (NumberFormatException e) {
	                System.out.println("Entrada no válida.");
	            }
	        }
	        return -1;
	    }

	    private String leerStringValidado(String msj, String tipo) {
	        for (int i = 0; i < 3; i++) {
	            System.out.print(msj);
	            String entrada = sc.nextLine().trim();
	            boolean valido = switch (tipo) {
	                case "cedula" -> validarCedula(entrada);
	                case "nombre" -> validarNombre(entrada);
	                case "email" -> validarEmail(entrada);
	                default -> !entrada.isEmpty();
	            };
	            if (valido) return entrada;
	            System.out.println("Formato incorrecto. Reintente.");
	        }
	        return null;
	    }
	
	    public void ejecutarMenu() {
	        cargarDatos();
	        int opcion;
	        do {
	            System.out.println("Sistema Clientes");
	            System.out.println("1. Agregar Cliente\n2. Listar Clientes\n3. Ver Log de Errores\n4. Salir");
	            opcion = leerEntero("Seleccione: ", 1, 4);

	            try {
	                switch (opcion) {
	                    case 1 -> agregarCliente();
	                    case 2 -> clientes.forEach(System.out::println);
	                    case 3 -> mostrarLog();
	                }
	            } catch (Exception e) {
	                System.err.println("Error inesperado en la operación.");
	                logError(e.toString());
	            }
	        } while (opcion != 4);
	        guardarDatos();
	    }

	    private void agregarCliente() {
	        String cedula = leerStringValidado("Cédula (10 dígitos): ", "cedula");
	        if (cedula == null) return;
	        
	        String nombre = leerStringValidado("Nombre: ", "nombre");
	        if (nombre == null) return;

	        String email = leerStringValidado("Email: ", "email");
	        if (email == null) return;

	        clientes.add(new Cliente(cedula, nombre, email));
	        System.out.println("Cliente agregado con éxito.");
	    }

	    private void mostrarLog() {
	        File file = new File(LOG_ERROR);
	        if (!file.exists()) { System.out.println("No hay errores registrados."); return; }
	        try (Scanner fScanner = new Scanner(file)) {
	            while (fScanner.hasNextLine()) System.out.println(fScanner.nextLine());
	        } catch (FileNotFoundException e) { logError(e.getMessage()); }
	    }
	}
