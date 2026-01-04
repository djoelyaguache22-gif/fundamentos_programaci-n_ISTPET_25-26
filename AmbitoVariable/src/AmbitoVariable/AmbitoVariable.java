package AmbitoVariable;

import java.util.Scanner;

public class AmbitoVariable {
		
		private static double suma = 50;
		
		public static void main(String[] args) {
			Scanner sc = new Scanner (System.in);
			System.out.println("Ingrese el primer numero");
			double numero1 = sc.nextDouble();
			System.out.println("Ingrese el segundo numero");
			double numero2 = sc.nextDouble();
			
			System.out.println("Suma con variables locales");
			SumaLocal();
			System.out.println("Suma con variables globales");
			SumaGlobal(numero1, numero2);
			
			sc.close();
		}
		
		public static void SumaLocal () {
			double numero1 = 10;
			double numero2 = 12.56;
			double suma = numero1 + numero2;
			System.out.println("SumaLocal: " + suma);
			System.out.println("SumaGlobal: " + AmbitoVariable.suma);
		
		}
		
		public static void SumaGlobal(double n1, double n2) {
			AmbitoVariable.suma += n1 + n2;
			System.out.println("Suma con variables globales es: " + AmbitoVariable.suma);
	}

}
