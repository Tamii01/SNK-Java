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
	private String direccion;

	public Mikasa(double x, double y, double velocidad) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.altura = 0;
		this.angulo = 0;
		this.tamaño = 60;
		this.direccion = "izquierda";

		this.imgDerecha = Herramientas.cargarImagen("mikasa-camina-der-pizq.png");
		this.imgIzquierda = Herramientas.cargarImagen("mikasa-camina-izq-pizq.png");
		this.ImgAbajo = Herramientas.cargarImagen("mikasa-camina-abajo-pder.png");
		this.ImgArriba = Herramientas.cargarImagen("mikasa-camina-arriba-pder.png");
		this.ImgQuieta = Herramientas.cargarImagen("mikasa-quieta.png");
	}

	public void dibujar(Entorno o) {
		o.dibujarImagen(ImgQuieta, x, y, angulo);
	}

	//	public boolean chocasteConCasa(Obstaculo o) { // fix
	//		return  x > o.getX() - o.getAnchoCasa() / 2 && // la mitad de la X hacia la izquierda
	//				x < o.getX() + o.getAnchoCasa() / 2 && // la mitad de la X hacia la derecha
	//				y < o.getY() - o.getAltoCasa() / 2 &&
	//				y > o.getY() + o.getAltoCasa() / 2; 
	////				&& y - tamaño / 2 < o.getY() - o.getAltoCasa() / 2;
	//	}
	public boolean chocasteConCasa(Obstaculo o) {
		return	x > o.getX() - o.getAnchoCasa() / 2 && 
				x < o.getX() + o.getAnchoCasa() / 2 && 
				y - tamaño / 2 < o.getY() - o.getAltoCasa() / 2;
	}

	public void chocasteConAlgo() { // fix
		y-=velocidad;
		x-=velocidad;
	}

	private void mirarHaciaLaIzquierda(Entorno o) {
		o.dibujarImagen(imgIzquierda, x, y, altura);
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

	public void caminarHaciaIzquierda(Entorno e) {
		this.direccion = "izquierda";
		x -= velocidad;
		mirarHaciaLaIzquierda(e);
	}

	public void caminarHaciaDerecha(Entorno e) {
		this.direccion = "derecha";
		x += velocidad;
		mirarHaciaLaDerecha(e);
	}

	public void caminarHaciaArriba(Entorno e) {
		this.direccion = "arriba";
		y -= velocidad;
		mirarHaciaArriba(e);
	}

	public void caminarHaciaAbajo(Entorno e) {
		this.direccion = "abajo";
		y += velocidad;
		mirarHaciaAbajo(e);
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