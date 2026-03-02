package PracticoS14;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestionArchivos {
	
	public void logError(String mensaje) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("errores.log", true)))) {
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            out.println("[" + fecha + "] " + mensaje);
        } catch (IOException e) {
            System.err.println("No se pudo escribir en el log.");
        }
    }

    public void cargarClientes(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                try {
                    String[] partes = linea.split(",");
                    if (partes.length < 3) throw new Exception("Formato inválido");
                } catch (Exception e) {
                    System.err.println("Línea ignorada: " + linea);
                    logError("Error de formato en línea: " + linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Iniciando sistema vacío.");
            logError("Archivo no encontrado: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error crítico de lectura. Abortando carga.");
            logError("Error E/S: " + e.getMessage());
        }
    }
}
