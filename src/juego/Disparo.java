package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Disparo {

	private double x;
	private double y;
	private double velocidad;
	private Image disparo;
	private String direccion;

	public Disparo(double x, double y, double velocidad, String direccion) {
		this.velocidad = 2;
		this.direccion = direccion;
		this.x = x;
		this.y = y;
		this.disparo = Herramientas.cargarImagen("disparo.png");
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
	
	public void disparar(Entorno e) {
		if (this.direccion == "derecha") {
			x+=velocidad;
			e.dibujarImagen(disparo, 420, 200, velocidad);
		}

		if (this.direccion == "izquierda") {
			x-=velocidad;
			e.dibujarImagen(disparo, x, y, velocidad);
		}

		if (this.direccion == "arriba") {
			y-=velocidad;
			e.dibujarImagen(disparo, x, y, velocidad);
		}

		if (this.direccion == "abajo") {
			y+=velocidad;
			e.dibujarImagen(disparo, x, y, velocidad);
		}
	}
}