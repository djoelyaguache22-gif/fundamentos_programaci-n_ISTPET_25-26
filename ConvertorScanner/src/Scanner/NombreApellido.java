package Scanner;

import java.util.Scanner;

public class NombreApellido {

	public static void main(String[]args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Ingrese sus Nombre:");
			String Nombres = sc.nextLine();
			System.out.println("Ingrese sus Apellidos:");
			String Apellidos = sc.nextLine();
			System.out.println("Mi edad es:");
			Integer Edad = sc.nextInt()	;
			System.out.println("Ingrese su Altura:");
			Float Altura = sc.nextFloat();
			System.out.println("Ingrese Estado Civil:");
			String Estado = sc.next();
			
			sc.close();
			
			System.out.println("Yo me llamo:"+ Nombres + " " + Apellidos);
			System.out.println("Mi edad es:"+ Edad);
			System.out.println("Mi altura es:"+ Altura);
			System.out.println("Mi Estado Civil es:"+ Estado);
			
		}

	}


