package AmbitoVariables;

public class AmbitoVariables {	

		    int contadorGlobal = 100;

		    public static void main(String[] args) {
		        AmbitoVariables ejemplo = new AmbitoVariables();
		        ejemplo.demostrarOcultamiento();
		        ejemplo.demostrarAmbitoBucles();
		    }

		    public void demostrarOcultamiento() {
		        System.out.println("Ocultamiento de Variables");
		        
		        int contadorGlobal = 20; 

		        System.out.println("Valor de la variable Local: " + contadorGlobal);
		        
		        System.out.println("Valor de la variable Global: " + this.contadorGlobal);
		       
		        this.contadorGlobal += 50;
		        System.out.println("Global modificada ahora vale: " + this.contadorGlobal + "n");
		    }

		    public void demostrarAmbitoBucles() {
		        System.out.println("Ambito de Bucles");

		        for (int i = 0; i < 3; i++) {
		            System.out.println("Iteración bucle (variable i): " + i);
		            
		            int variableInterna = i * 10;
		            System.out.println("  Variable interna al bucle: " + variableInterna);
		        }
		        
		        System.out.println("Las variables 'i' y 'variableInterna' no son accesibles fuera del bucle.");

		        int j; 
		        for (j = 0; j < 3; j++) {
		        }
		        System.out.println("Variable 'j' finalizó en: " + j + " (Es accesible por declararse fuera del for)");

	}

}
