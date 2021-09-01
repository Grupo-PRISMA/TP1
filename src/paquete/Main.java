package paquete;

public class Main {

	public static void main(String[] args) {
		PlataformaWeb carga = new PlataformaWeb();

		carga.construirVisitantes(ManejadorArchivos.obtenerVisitantesDesdeArchivo());
		carga.construirAtracciones(ManejadorArchivos.obtenerAtraccionesDesdeArchivo());
		carga.construirPromociones(ManejadorArchivos.obtenerPromocionesDesdeArchivo());

		// Listo todas las atracciones y las promociones con su contenido
		System.out.println(carga.toString());

		// Leer por consola y mostrar por pantalla
		//Scanner in = new Scanner(System.in);
		//String entradaConsola = in.nextLine();
		//System.err.println(entradaConsola);
		//in.close();
	}
	
}
