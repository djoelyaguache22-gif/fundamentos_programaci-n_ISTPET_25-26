package CalculoPromedio;

import java.util.ArrayList;

public class CalculoPromedio {

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		numeros.add(4);
		numeros.add(8);
		numeros.add(9);
		numeros.add(9);
		numeros.add(7);
		numeros.add(9);
		numeros.add(8);
		numeros.add(9);
		numeros.add(9);
		numeros.add(6);
		numeros.add(7);
		
		double suma = 0;
		
		for(int numero : numeros) {
			suma += numero;
		}

		double promedio = suma/numeros.size();
		
		System.out.println("El promedio del estudiante es: "+ promedio);
	}

}
