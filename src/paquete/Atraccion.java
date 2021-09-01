package paquete;

public class Atraccion {
	private String nombre;
	private TipoDeAtraccion tipo;
	private double costo;
	private double duracionHs;
	private int cupoPersonas;
	
	public Atraccion(String nombre, TipoDeAtraccion tipo, double costo, double horas, int cupoPersonas) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.duracionHs = horas;
		this.cupoPersonas = cupoPersonas;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoDeAtraccion getTipo() {
		return tipo;
	}

	public double getCosto() {
		return costo;
	}

	public double getHoras() {
		return duracionHs;
	}

	public int getCupoPersonas() {
		return cupoPersonas;
	}

	@Override
	public String toString() {
		return "Nombre = " + nombre + ", Tipo = " + tipo + ", Costo = " + costo +
				", Horas = " + duracionHs + ", Cupo Personas = " + cupoPersonas + "\n";
	}
	
//	public static Atracciones getAtraccionPorNombre(String nombre) {
//		if (){
//			
//		}
//		return Atraccion;
//	}
//	
}

