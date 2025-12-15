package ClasificacionEdades;

import java.util.Scanner;

public class ClasificacionEdades {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingresa tu edad: ");
            int edad = scanner.nextInt();

            String categoria;

            if (edad < 0 || edad > 120) {
                categoria = "Edad invalida";
            } else {
            	
            }
                if (edad < 13) {
                    categoria = "Niño/a";
                }

                else if (edad >= 13 && edad < 18) {
                    categoria = "Adolescente";
                }
                else {

                    if (edad >= 18 && edad < 65) {
                        categoria = "Adulto/a";
                    } else {
                    	
                        categoria = "Adulto/a";
            
                    }
                }
                
            System.out.println("Tienes:"+ " " + edad); 
            System.out.println("Tu categoría es:" + " " + categoria);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error");
        } finally {
        	
            scanner.close();

	}

}}
