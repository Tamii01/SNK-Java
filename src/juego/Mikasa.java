package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Mikasa {

	private double x;
	private double y;
	
	private double ancho;
	private double alto;
	
	private double velocidad;
	private Image mikasa;
	

	
	public Mikasa (double x, double y, double velocidad) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		
		this.ancho = 20;
		this.alto = 50;
		
		this.mikasa = Herramientas.cargarImagen("mikasaDerecha.png");
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
	
	public double alto() {
		return alto;
	}
	
	public double ancho() {
		return ancho;
	}
}
