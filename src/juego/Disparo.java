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
	

	public Disparo(double x, double y) {
	
		this.direccion = "derecha";
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
	
	public void dibujar(Entorno e) {
		e.dibujarImagen(disparo, x, y, velocidad);
	}


	public void aLaDerecha(Entorno e) {
		if (this.direccion == "derecha") {
			this.x++;
			e.dibujarImagen(disparo, x, y, velocidad);
		}
	}
}