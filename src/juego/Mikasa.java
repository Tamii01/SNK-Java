package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Mikasa {

	private double x;
	private double y;

	private double velocidad;

	private double altura;
	private double angulo;
	private double tamaño;

	private Image imgDerecha;
	private Image imgIzquierda;
	private Image ImgAbajo;
	private Image ImgArriba;
	private Image ImgQuieta;

	public Mikasa(double x, double y, double velocidad) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.altura = 0;
		this.angulo = 0;
		this.tamaño = 80;

		this.imgDerecha = Herramientas.cargarImagen("mikasa-camina-der-pizq.png");
		this.imgIzquierda = Herramientas.cargarImagen("mikasa-camina-izq-pizq.png");
		this.ImgAbajo = Herramientas.cargarImagen("mikasa-camina-abajo-pder.png");
		this.ImgArriba = Herramientas.cargarImagen("mikasa-camina-arriba-pder.png");
		this.ImgQuieta = Herramientas.cargarImagen("mikasa-quieta.png"); 
	}

	public void dibujar(Entorno o) {
		o.dibujarImagen(ImgQuieta, x, y, angulo);
	}

	public boolean chocasteConAlgo(Obstaculo o) {
		return x == o.getX() - o.getAltoCasa() && y == o.getY() - o.getAnchoCasa();
	}

	public boolean chocasteConObstaculo(Obstaculo o) {
		return x < o.getAnchoCasa() && x < o.getX() + o.getAltoCasa() / 2
				&& y + tamaño / 2 > o.getY() - o.getAltoCasa() / 2;
	}
	
	private void mirarHaciaLaIzquierda(Entorno o) {
		o.dibujarImagen(imgIzquierda, x, y, angulo);
	}

	public void mirarHaciaLaDerecha(Entorno o) {
		o.dibujarImagen(imgDerecha, x, y, angulo);
	}
	
	public void mirarHaciaArriba(Entorno o) {
		o.dibujarImagen(ImgArriba, x, y, angulo);
	}

	public void mirarHaciaAbajo(Entorno o) {
		o.dibujarImagen(ImgAbajo, x, y, angulo);
	}

	public void rotarHaciaIzquierda(Entorno e) {
		angulo -= 0.05;
		mirarHaciaLaIzquierda(e);
		
	}
	public void rotarHaciaDerecha(Entorno f) {
		angulo += 0.05;
		mirarHaciaLaDerecha(f);
	}
	
	public void avanzar(Entorno g) {
		x += velocidad * Math.cos(angulo);
        y += velocidad * Math.sin(angulo);
		mirarHaciaArriba(g);
	}

	public void retroceder(Entorno h) {
		x -= velocidad * Math.cos(angulo);
        y -= velocidad * Math.sin(angulo);
		mirarHaciaAbajo(h);
	}
	
	public boolean chocasteConEntornoIzquierdo() {
		return this.x > 20;							// compara la posicion de mikasa con el limite del entorno izquierdo
	}

	public boolean chocasteConEntornoDerecho() {
		return this.x < 780;						// compara la posicion de mikasa con el limite del entorno derecho
	}

	public boolean chocasteConEntornoSuperior() {
		return this.y > 29;							// compara la posicion de mikasa con el limite del entorno superior
	}

	public boolean chocasteConEntornoInferior() {
		return this.y < 580;						// compara la posicion de mikasa con el limite del entorno inferior
	}	

	public double getY() {
		return this.y;
	}

	public double getX() {
		return this.x;
	}

	public double getaAltura() {
		return this.altura;
	}

	public double getTamaño() {
		return tamaño;
	}

	public double getAngulo() {
		return this.angulo;
	}
}