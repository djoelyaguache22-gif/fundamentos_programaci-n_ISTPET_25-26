package S14;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegistroUsuario {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        String nombre = "";
	        int edad = 0;
	        String correo = "";

	        System.out.println("Sistema de Registro");	 
	        while (true) {
	            System.out.print("Ingrese su nombre: ");
	            nombre = sc.nextLine().trim();
	            
	            if (nombre.isEmpty()) {
	                System.out.println("Error: El nombre no puede estar vacío.");
	            } else {
	                break; 
	            }
	        }
	        while (true) {
	            System.out.print("Ingrese su edad (18 - 99): ");
	            if (sc.hasNextInt()) {
	                edad = sc.nextInt();
	                sc.nextLine(); 
	                
	                if (edad >= 18 && edad <= 99) {
	                    break; 
	                } else {
	                    System.out.println("Error: La edad debe estar entre 18 y 99 años.");
	                }
	            } else {
	                System.out.println("Error: Debe ingresar un número entero.");
	                sc.next(); 
	            }
	        }

	        String regexCorreo = "^[A-Za-z0-9+_.-]+@(.+)$";
	        while (true) {
	            System.out.print("Ingrese su correo electrónico: ");
	            correo = sc.nextLine().trim();
	            
	            if (Pattern.matches(regexCorreo, correo)) {
	                break; 
	            } else {
	                System.out.println("Error: El formato del correo no es válido (ejemplo@dominio.com).");
	            }
	        }
	        System.out.println("Registro Guardado");
	        System.out.println("Nombre: " + nombre);
	        System.out.println("Edad: " + edad);
	        System.out.println("Correo: " + correo);
	        
	        sc.close();
	    }
	}