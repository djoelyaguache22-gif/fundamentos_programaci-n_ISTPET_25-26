package PracticoS14;

public class Validador {
	
	    public static boolean validarCedula(String cedula) {
	        if (cedula == null || !cedula.trim().matches("\\d{10}")) return false;
	        
	        int provincia = Integer.parseInt(cedula.substring(0, 2));
	        if (provincia < 1 || provincia > 24) return false;

	        int d10 = Integer.parseInt(cedula.substring(9, 10));
	        int suma = 0;
	        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};

	        for (int i = 0; i < 9; i++) {
	            int valor = Integer.parseInt(cedula.substring(i, i + 1)) * coeficientes[i];
	            suma += (valor > 9) ? valor - 9 : valor;
	        }
	        int resultado = (suma % 10 == 0) ? 0 : 10 - (suma % 10);
	        return resultado == d10;
	    }
	    

	}