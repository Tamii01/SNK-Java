package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Mikasa {

	private double x;
	private double y;

	private double velocidad;

	private double ancho;
	private double altura;

	private double angulo;
	private double tamaño;
	
	private Image imgDerecha;
	private Image imgIzquierda;
	private Image ImgAbajo;
	private Image ImgArriba;


	public Mikasa(double x, double y, double velocidad) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;

		this.ancho = 0;
		this.altura = 0;
		this.angulo = 0;
		this.tamaño = 80;

		this.imgDerecha = Herramientas.cargarImagen("mikasa-caminaDer-Pizq.png");
		this.imgIzquierda = Herramientas.cargarImagen("mikasa-caminaIzq-Pizq.png");
		this.ImgAbajo = Herramientas.cargarImagen("mikasa-camina-abajo-Pder.png");
		this.ImgArriba = Herramientas.cargarImagen("mikasa-camina-arriba-Pder.png");
	}

	private void mirarHaciaLaIzquierda(Entorno e) {
		e.dibujarImagen(imgIzquierda, x, y, altura);
	}
	
	public void mirarHaciaLaDerecha(Entorno e) {
		e.dibujarImagen(imgDerecha, x, y, angulo);
	}
	
	public void mirarHaciaArriba(Entorno e) {
		e.dibujarImagen(ImgArriba, x, y, angulo);
	}
	
	public void mirarHaciaAbajo(Entorno e) {
		e.dibujarImagen(ImgAbajo, x, y, angulo);
	}
	
	//fixme
	public void dibujar(Entorno e) {
		e.dibujarImagen(ImgAbajo, x, y, angulo);
//		e.dibujarImagen(ImgArriba, x, y, angulo);
//		e.dibujarImagen(imgDerecha, x, y, angulo);
//		e.dibujarImagen(imgIzquierda, x, y, angulo); 
	}

	public boolean chocaEntorno(Entorno entorno) {
		return x < tamaño / 2 || x > entorno.ancho() - tamaño / 2 || y < tamaño / 5
				|| y > entorno.alto() - tamaño / 5;
	}
	
	public void quedarParada() {
		x += velocidad * Math.cos(angulo); 
		y -= velocidad * Math.cos(angulo);
	}
	
	public boolean agarraSuero(Obstaculo suero) {
		return x > suero.getY() - suero.getAncho() / 2 && x < suero.getX() + suero.getAncho() / 2 
				&& y + tamaño /2 > suero.getY() - suero.getAlto() / 2;	
	}
	
	public void caminarHaciaIzquierda(Entorno e) {
		x -= velocidad;
		mirarHaciaLaIzquierda(e);
	}
	public void caminarHaciaDerecha(Entorno f) {
		x += velocidad;
		mirarHaciaLaDerecha(f);
	}
	
	public void caminarHaciaArriba(Entorno g) {
		y -= velocidad;
		mirarHaciaArriba(g);
	}

	public void caminarHaciaAbajo(Entorno h) {
		y += velocidad;
		mirarHaciaAbajo(h);
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
