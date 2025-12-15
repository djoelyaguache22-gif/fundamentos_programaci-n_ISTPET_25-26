package TablaMultiplicar;

import java.util.Scanner;

public class TablaMultiplicar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String seguir = "si";
		
		while (seguir.equalsIgnoreCase("si")) {
			
			System.out.println("¿Cual tabla desea?");
			int n = sc.nextInt();
			
			if (n < 1 || n > 10) { 
				System.out.println("Numero inexistente");
				continue;
				
			}
			
			for (int i = 1; i <= 10; i ++) {
				System.out.println(n + " * " + i + " = " + (n * i));
			}
			
			System.out.println("Ingrese otra tabla: (si)");
			seguir = sc.next();
			System.out.println();
		}

		System.out.println("Fin de la Table");
		sc.close();
	}

}
