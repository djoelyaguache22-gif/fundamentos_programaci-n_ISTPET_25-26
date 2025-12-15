package Scanner;

import java.util.Scanner;

public class ConvertorUnidades {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese la Distancia en Metros:");
		Double metros = sc.nextDouble();
		
		sc.close();
		
		Double kilometros = metros/1000;
		Double centimetros = metros*100;
		Double pies = metros * 3.28084;
		System.out.println("En Kilometros es:"+ kilometros);
		System.out.println("En centimetros es:"+ centimetros);
		System.out.println("En pies es:"+pies);

	}

}
