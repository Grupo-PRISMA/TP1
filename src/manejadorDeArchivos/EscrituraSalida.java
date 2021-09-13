package manejadorDeArchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import plataformaWeb.PlataformaWeb;
import sugerencia.Sugerencia;

public class EscrituraSalida {

	private ArrayList<Sugerencia> itinerario;
	
	public EscrituraSalida(PlataformaWeb plataforma) {
		//PlataformaWeb plataforma = new PlataformaWeb();
		this.itinerario = plataforma.getItinerario();
	}
	
	public void muestra() {
		System.out.println(this.itinerario);
	}

	public void salida() throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter("salida/salida4.out"));	
		//String saludo = "Hola";
		for(Sugerencia sugerencia : this.itinerario) {
			System.out.println("------");
			System.out.println(sugerencia);
			salida.println(sugerencia);
		}
		
		salida.close();	
	}

	@Override
	public String toString() {
		return "EscrituraSalida [itinerario=" + itinerario + "]";
	}
}
