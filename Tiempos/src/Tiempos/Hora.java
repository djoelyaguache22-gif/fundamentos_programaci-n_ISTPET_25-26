package Tiempos;

	import java.time.LocalTime;
	import java.time.format.DateTimeFormatter;

	public class Hora {
	    public static void main(String[] args) {
	        LocalTime ahora = LocalTime.now();
	        System.out.println("Hora actual: " + ahora);

	        DateTimeFormatter formato24h = DateTimeFormatter.ofPattern("HH:mm:ss");
	        System.out.println("Formato 24h: " + ahora.format(formato24h));

	        DateTimeFormatter formato12h = DateTimeFormatter.ofPattern("hh:mm:ss a");
	        System.out.println("Formato 12h: " + ahora.format(formato12h));
	    }
	}