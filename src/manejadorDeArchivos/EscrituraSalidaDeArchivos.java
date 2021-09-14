package manejadorDeArchivos;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import sugerencia.Sugerencia;

public class EscrituraSalidaDeArchivos {

	public static void salidaItinerario(ArrayList<Sugerencia> itinerario, String nombreArchivo) {
		
		PrintWriter salida = null;
		try {
			salida = new PrintWriter(new FileWriter("salida/" + nombreArchivo));	
			for(Sugerencia sugerencia : itinerario) {
				salida.println(sugerencia);
			}
			
		}catch (Exception e) {
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
