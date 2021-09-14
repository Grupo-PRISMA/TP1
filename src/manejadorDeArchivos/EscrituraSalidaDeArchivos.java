package manejadorDeArchivos;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscrituraSalidaDeArchivos {

	public static void salidaItinerario(String nombreArchivo, String datos) {

		PrintWriter salida = null;
		try {
			salida = new PrintWriter(new FileWriter("salida/" + nombreArchivo));
			salida.println(datos);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR!!!\n" + e.getMessage());
		}

		finally {
			try {
				salida.close();
			} catch (Exception e) {
				System.out.println("Mensaje error cierre de archivo: " + e.getMessage());
			}
		}
	}
}
