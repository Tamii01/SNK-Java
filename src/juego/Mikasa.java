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
	
	private double tamaño;

	

	
	public Mikasa (double x, double y, double velocidad) {
		this.x = 400;
		this.y = 300;
		this.velocidad = velocidad;
		
		this.ancho = 0;
		this.alto = 0;
		this.tamaño = 0;
		
		this.mikasa = Herramientas.cargarImagen("mikasaDerecha.png");
	}

	public void dibujar(Entorno d) {
		d.dibujarImagen(mikasa, 0, 0, alto);
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
	
	public double Y() {
		return y;
	}
	
	public double X() {
		return x;
	}
	
	public double alto() {
		return alto;
	}
	
	public double ancho() {
		return ancho;
	}
}
