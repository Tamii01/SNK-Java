package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Proyectil {

	private double x;
	private double y;
	private double velocidad;
	private String direccion;
	private Image proyectil;

	public Proyectil(double x, double y, double velocidad) {
		this.x = x;
		this.y = y;
		this.velocidad = 2;
		this.direccion = direccion;
		this.proyectil = Herramientas.cargarImagen("disparo.png"); //Cambiar nombre de la imagen
	}

	//Sigo pensando en esto, si me corrigen en algo xd
	
	public void proyectil(Entorno e) {
		if (this.direccion == "derecha") {
			x+=velocidad;
			e.dibujarImagen(proyectil, 420, 200, velocidad);
		}

		if (this.direccion == "izquierda") {
			x-=velocidad;
			e.dibujarImagen(proyectil, x, y, velocidad);
		}

		if (this.direccion == "arriba") {
			y-=velocidad;
			e.dibujarImagen(proyectil, x, y, velocidad);
		}

		if (this.direccion == "abajo") {
			y+=velocidad;
			e.dibujarImagen(proyectil, x, y, velocidad);
		}
	}
	
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
}