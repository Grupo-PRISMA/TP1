package plataformaWeb;

import java.io.IOException;

import manejadorDeArchivos.EscrituraSalida;

public class Main {

	public static void main(String[] args) throws IOException {
		
		PlataformaWeb plataforma = new PlataformaWeb();
		plataforma.sugerir();
		
		EscrituraSalida datos = new EscrituraSalida(plataforma);
		datos.salida();
		
		
	}

}
