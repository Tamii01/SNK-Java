package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Mikasa {

	private double x;
	private double y;

	private double velocidad;

	private double alto;
	private double ancho;
	private double angulo;

	private Image imgDerecha;
	private Image imgIzquierda;
	private Image ImgAbajo;
	private Image ImgArriba;
	private Image ImgQuieta;
	private String direccion;
	
	private Proyectil disparo;

	public Mikasa(double x, double y, double velocidad, double alto, double ancho) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.ancho = ancho;
		this.alto = alto;
		this.angulo = 0;
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

	public boolean chocasteCon(Obstaculo o) {
		return	x - alto / 2 >= o.getX() - o.getAncho() / 2 && 
				x + alto / 2 <= o.getX() + o.getAncho() / 2 &&
				y - ancho / 2 >= o.getY() - o.getAlto() / 2 &&
				y + ancho / 2 <= o.getY() + o.getAlto() / 2;
	}
	
	public boolean chocasteConArbolPequeño(Obstaculo o) {
		return	x - alto / 2 >= o.getX() - o.getAnchoArbolPequeño() / 2 && 
				x + alto / 2 <= o.getX() + o.getAnchoArbolPequeño() / 2 &&
				y - ancho / 2 >= o.getY() - o.getAlto() / 2 &&
				y + ancho / 2 <= o.getY() + o.getAlto() / 2;
	}

	public void chocasteConObstaculo() {
		y-=velocidad;
		x+=velocidad;
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

	//	public void caminarHaciaIzquierda(Entorno e) {
	//		this.direccion = "izquierda";
	//		x -= velocidad;
	//		mirarHaciaLaIzquierda(e);
	//	}
	//
	//	public void caminarHaciaDerecha(Entorno e) {
	//		this.direccion = "derecha";
	//		x += velocidad;
	//		mirarHaciaLaDerecha(e);
	//	}
	//
	//	public void caminarHaciaArriba(Entorno e) {
	//		this.direccion = "arriba";
	//		y -= velocidad;
	//		mirarHaciaArriba(e);
	//	}
	//
	//	public void caminarHaciaAbajo(Entorno e) {
	//		this.direccion = "abajo";
	//		y += velocidad;
	//		mirarHaciaAbajo(e);
	//	}
	
	public void rotarHaciaIzquierda(Entorno e) {
		angulo -= 0.05;
		mirarHaciaLaIzquierda(e);
	}

	public void rotarHaciaDerecha(Entorno e) {
		angulo += 0.05;
		mirarHaciaLaDerecha(e);
	}

	public void avanzar(Entorno e) {
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
		mirarHaciaArriba(e);
	}

	public void retroceder(Entorno e) {
		x -= velocidad * Math.cos(angulo);
		y -= velocidad * Math.sin(angulo);
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

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getAlto() {
		return this.alto;
	}

	public double getAncho() {
		return this.ancho;
	}

	public double getAngulo() {
		return this.angulo;
	}
}
