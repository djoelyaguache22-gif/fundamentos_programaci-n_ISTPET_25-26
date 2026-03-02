package Tiempos;
	
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaHora {
	  public static void main(String[] args) {
	        LocalDateTime ahora = LocalDateTime.now();
	        System.out.println("Sin formato (ISO): " + ahora);

	        DateTimeFormatter formatoPersonalizado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	        
	        String fechaHoraFormateada = ahora.format(formatoPersonalizado);
	        
	        System.out.println("Con formato personalizado: " + fechaHoraFormateada);
	        
	        DateTimeFormatter formatoLargo = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy, hh:mm a");
	        System.out.println("Formato descriptivo: " + ahora.format(formatoLargo));
	    }
	}