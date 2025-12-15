package ValidacionContraseña;

import java.util.Scanner;

public class Contraseña {

	public static void main(String[] args) {
	        
	        final String Contraseña = "24689";
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Ingrese la contraseña: ");
	        String contrasena = scanner.nextLine();

	        boolean correcta = contrasena.equals(Contraseña);

	        if (correcta) {
	            System.out.println("Acceso Permitido");
	        } else {
	            System.out.println("Acceso Denegado");
	        }

	        String mensajeAdicional;
	        
	        mensajeAdicional = correcta ? "Bienvenido" : "Intente de nuevo";
	        System.out.println(mensajeAdicional);
	        
	        scanner.close(); 

	}

}
