package S15;

public class LogicaErrores {

	    private String[] nombres = {"Ana", "Carlos", "María", "Juan", "Luisa"};
	    private String[] cedulas = {"1111", "2222", "3333", "4444", "5555"};
	    private int contador = 5;

	    public int buscarPorCedula(String cedula) {
	        // Iniciar en 0 y terminar antes del contador
	        for (int i = 0; i < contador; i++) {
	            if (cedulas[i].equals(cedula)) {
	                return i;
	            }
	        }
	        return -1;
	    }

	    public boolean eliminarCliente(int indice) {
	        // Añadido operador || (OR)
	        if (indice < 0 || indice >= contador) {
	            return false;
	        }

	        // Desplazamiento hacia la izquierda para "tapar" el hueco
	        for (int i = indice; i < contador - 1; i++) {
	            nombres[i] = nombres[i + 1];
	            cedulas[i] = cedulas[i + 1];
	        }

	        // Al eliminar, el contador disminuye
	        contador--;
	        return true;
	    }

	    public double calcularPromedioEdad(int[] edades) {
	        if (edades.length == 0) return 0; // Evitar división por cero
	        int suma = 0;

	        for (int i = 0; i < edades.length; i++) {
	            // Sumar el valor del arreglo, no el índice
	            suma += edades[i];
	        }

	        // Casteo a double para no perder decimales
	        return (double) suma / edades.length;
	    }
	}

