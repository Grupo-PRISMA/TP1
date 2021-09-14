package plataformaWeb;

import java.io.IOException;

import manejadorDeArchivos.EscrituraSalidaDeArchivos;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("--------------------------------------------------");
		System.out.println("\n    Bienvenido/a a la Guerra de las Galaxias");
		System.out.println("\n--------------------------------------------------");
		System.out.println("\n");
		
		PlataformaWeb plataforma = new PlataformaWeb();
		plataforma.sugerir();

	}

}
