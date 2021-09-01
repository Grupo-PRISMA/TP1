package paquete;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class ManejadorArchivos {
	public static Visitante[] obtenerUsuariosDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Visitante[] visitantes = null;

		try {
			archivo = new File("entrada/usuarios.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			visitantes = new Visitante[cantidad];

			int indice = 0;
			String linea = br.readLine();
			while (linea != null) {
				String[] datosUsuarios = linea.split(",");

				String nombre = datosUsuarios[0];
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datosUsuarios[1]);
				double dineroDisponible = Integer.parseInt(datosUsuarios[2]);
				double horasDisponibles = Integer.parseInt(datosUsuarios[3]);

				visitantes[indice++] = new Visitante(nombre, dineroDisponible, horasDisponibles, tipo);
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
				double horas = Double.parseDouble(datosAtracciones[3]);
				int cupo = Integer.parseInt(datosAtracciones[4]);

				atracciones[indice++] = new Atraccion(nombre, tipo, costo, horas, cupo);
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

				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datosPromociones[0]);
				String promo = datosPromociones[1];

				String[] datosAtracciones = datosPromociones[2].split(";");
				Atraccion[] atracciones = new Atraccion[datosAtracciones.length];
//				Atraccion atraccion1 = Atraccion.getAtraccionPorNombre(datosAtracciones[0]);
//				Atraccion atraccion2 = Atraccion.getAtraccionPorNombre(datosAtracciones[1]);

				promociones[indice++] = new Promocion(tipo, promo, atracciones);
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

