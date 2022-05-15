package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Mikasa1 {

	private double x;
	private double y;

	private double velocidad;

	private double ancho;
	private double altura;

	private double angulo;
	private double tamaño;
	
	private int vida;
	
	private Image imgDerecha;
	private Image imgIzquierda;


	public Mikasa1(double x, double y, double velocidad) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;

		this.ancho = 0;
		this.altura = 0;
		this.angulo = 0;
		this.tamaño = 80;

		this.imgDerecha = Herramientas.cargarImagen("mikasaCaminandoDer.png");
		this.imgIzquierda = Herramientas.cargarImagen("mikasaCaminandoIzq.png");
	}

	private void mirarHaciaLaIzquierda(Entorno e) {
		e.dibujarImagen(imgIzquierda, x, y, altura);
	}

	public boolean chocaEntorno(Entorno entorno) {
		return x < tamaño / 2 || x > entorno.ancho() - tamaño / 2 || y < tamaño / 5
				|| y > entorno.alto() - tamaño / 5;
	}
	
	public void quedarParada() {
		x += velocidad * Math.cos(angulo); 
		y -= velocidad * Math.cos(angulo);
	}

	public void dibujar(Entorno d) {
		d.dibujarImagen(imgDerecha, x, y, angulo);
	}
	
	public boolean agarraSuero(Obstaculo1 obst1) {
		return x > obst1.getY() - obst1.getAncho() / 2 && x < obst1.getX() + obst1.getAncho() / 2 
				&& y + tamaño /2 > obst1.getY() - obst1.getaAlto() / 2;	
	}
	
	public void caminarHaciaIzquierda(Entorno e) {
		x -= velocidad;
		mirarHaciaLaIzquierda(e);
	}
	public void caminarHaciaDerecha() {
		x += velocidad;
	}
	
	public void caminarHaciaArriba() {
		y -= velocidad;
	}

	public void caminarHaciaAbajo() {
		y += velocidad;
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

	public double getaAltura() {
		return altura;
	}
	
	public double getAncho() {
		return ancho;
	}

}
