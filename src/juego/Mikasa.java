package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Mikasa {

	private double x;
	private double y;
	
	private double velocidad;
	
	private double ancho;
	private double alto;
	
	private Image mikasa;
	
	
	public Mikasa (double x, double y, double velocidad) {
		this.x = y;
		this.y = x;
		this.velocidad = velocidad;
		
		this.ancho = 0;
		this.alto = 0;
		
		this.mikasa = Herramientas.cargarImagen("mikasaDer.png");
	}

	public void dibujar(Entorno d) {
		d.dibujarImagen(mikasa, x, y, alto);
		
	}

	public void moverHaciaIzquierda() {
		x -= velocidad;
	}
	
	public void moverHaciaDerecha() {
		x += velocidad;
		
	}
	
	public void moverHaciaArriba() {
		y -= velocidad;
	}
	
	public void moverHaciaAbajo() {
		y += velocidad;
	}
	
	public double getY() {
		return y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getaAlto() {
		return alto;
	}
	
	public double getAncho() {
		return ancho;
	}
}
