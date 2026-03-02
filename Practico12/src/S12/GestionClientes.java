package S12;

import java.io.*;

public class GestionClientes {

    private static final String FILE_NAME = "src/datos.csv";
    private static final int MAX_CLIENTES = 100;
    private String[] nombres = new String[MAX_CLIENTES];
    private String[] cedulas = new String[MAX_CLIENTES];
    private String[] emails = new String[MAX_CLIENTES];
    private int contadorClientes = 0;

    public GestionClientes() {
        cargarClientesAlIniciar();
    }

    public boolean guardarClientes(String nombreArchivo) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {

            escritor.write("nombre,cedula,email");
            escritor.newLine();

            for (int i = 0; i < contadorClientes; i++) {
                String linea = String.format("%s,%s,%s", nombres[i], cedulas[i], emails[i]);
                escritor.write(linea);
                escritor.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error crítico de E/S: " + e.getMessage());
            return false;
        }
    }

    public void guardarClientesAutomatico() {
        if (guardarClientes(FILE_NAME)) {
            System.out.println("Datos guardados exitosamente en " + FILE_NAME);
        } else {
            System.out.println("Error: No se pudo realizar el guardado automático.");
        }
    }
    public int cargarClientes(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) return -1;

        int cargados = 0;
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea = lector.readLine(); 
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 3) {
                    agregarCliente(campos[0], campos[1], campos[2]);
                    cargados++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar archivo: " + e.getMessage());
        }
        return cargados;
    }

    private void cargarClientesAlIniciar() {
        int resultado = cargarClientes(FILE_NAME);
        if (resultado >= 0) {
            System.out.println("Cargados " + resultado + " clientes desde archivo.");
        } else {
            System.out.println("Archivo no encontrado, comenzando con sistema vacío.");
        }
    }
    public void agregarCliente(String nombre, String cedula, String email) {
        if (contadorClientes < MAX_CLIENTES) {
            nombres[contadorClientes] = nombre;
            cedulas[contadorClientes] = cedula;
            emails[contadorClientes] = email;
            contadorClientes++;
        }
    }
    public void mostrarMenu() {
        System.out.println("SISTEMA DE GESTIÓN DE CLIENTES");
        System.out.println("1. Agregar | 2. Listar | 3. Buscar | 4. Editar | 5. Eliminar");
        System.out.println("6. Guardar Manual | 7. Cargar Manual | 8. Estadísticas | 9. Salir");
    }

    public static void main(String[] args) {
        GestionClientes sistema = new GestionClientes();
        sistema.guardarClientesAutomatico();
    }
}
