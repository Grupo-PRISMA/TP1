package paquete;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class ManejadorArchivos {
	public static Visitante[] obtenerVisitantesDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Visitante[] visitantes = null;

		try {
			archivo = new File("entrada/visitantes.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			visitantes = new Visitante[cantidad];

			int indice = 0;
			String linea = br.readLine();
			while (linea != null) {
				String[] datosVisitantes = linea.split(",");

				String nombre = datosVisitantes[0];
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datosVisitantes[1]);
				double presupuesto = Integer.parseInt(datosVisitantes[2]);
				double tiempoDisponibleHs = Integer.parseInt(datosVisitantes[3]);

				visitantes[indice++] = new Visitante(nombre, presupuesto, tiempoDisponibleHs, tipo);
				linea = br.readLine();
			}

			return visitantes;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

		return visitantes;
	}

	public static Atraccion[] obtenerAtraccionesDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Atraccion[] atracciones = null;

		try {
			archivo = new File("entrada/atracciones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			atracciones = new Atraccion[cantidad];

			int indice = 0;
			String linea = br.readLine();
			while (linea != null) {
				String[] datosAtracciones = linea.split(",");

				String nombre = datosAtracciones[0];
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datosAtracciones[1]);
				double costo = Double.parseDouble(datosAtracciones[2]);
				double duracionHs = Double.parseDouble(datosAtracciones[3]);
				int cupoPersonas = Integer.parseInt(datosAtracciones[4]);

				atracciones[indice++] = new Atraccion(nombre, tipo, costo, duracionHs, cupoPersonas);
				linea = br.readLine();
			}

			return atracciones;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

		return atracciones;
	}

	public static Promocion[] obtenerPromocionesDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Promocion[] promociones = null;

		try {
			archivo = new File("entrada/promociones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			promociones = new Promocion[cantidad];
			int indice = 0;

			String linea = br.readLine();
			while (linea != null) {
				String[] datosPromociones = linea.split(",");

				String Id = datosPromociones[0];
				TipoDeAtraccion tipoDeAtraccion = TipoDeAtraccion.valueOf(datosPromociones[1]);
				String descuento = datosPromociones[2];

				String[] datosAtracciones = datosPromociones[3].split(";");
				Atraccion[] atracciones = new Atraccion[datosAtracciones.length];
//				Atraccion atraccion1 = Atraccion.getAtraccionPorNombre(datosAtracciones[0]);
//				Atraccion atraccion2 = Atraccion.getAtraccionPorNombre(datosAtracciones[1]);

				if (Id == "porcentual") {
					promociones[indice++] = new PromocionPorcentual(tipoDeAtraccion, descuento, atracciones);
				} else if (Id == "absoluta") {
					promociones[indice++] = new PromocionAbsoluta(tipoDeAtraccion, descuento, atracciones);
				} else if (Id == "AxB") {
					promociones[indice++] = new PromocionAxB(tipoDeAtraccion, descuento, atracciones, descuento);
				}

				linea = br.readLine();
			}

			return promociones;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

		return promociones;
	}

}
