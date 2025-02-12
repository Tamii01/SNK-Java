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
	private Image ImgDerecha;
	private Image ImgIzquierda;
	private Image ImgAbajo;
	private Image ImgArriba;
	private Image ImgQuieta;
	
	// Cuando Mikasa está en modo kyojina, no hace falta mostrar nada
	public Mikasa(double x, double y, double velocidad, double alto, double ancho) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.ancho = ancho;
		this.alto = alto;
		this.angulo = 0;
		
		this.ImgDerecha = Herramientas.cargarImagen("mikasa-camina-der-pizq.png");
		this.ImgIzquierda = Herramientas.cargarImagen("mikasa-camina-izq-pizq.png");
		this.ImgAbajo = Herramientas.cargarImagen("mikasa-camina-abajo-pder.png");
		this.ImgArriba = Herramientas.cargarImagen("mikasa-camina-arriba-pder.png");
		this.ImgQuieta = Herramientas.cargarImagen("mikasa-quieta.png"); 
	}
	
	public void dibujar(Entorno e) {
		e.dibujarImagen(ImgQuieta, x, y, angulo);
	}
	
	public boolean agarroSuero(Suero s) {
		return	x - alto  / 2 >= s.getX() - s.getAncho() / 2 && 
				x + alto  / 2 <= s.getX() + s.getAncho() / 2 &&
				y - ancho / 2 >= s.getY() - s.getAlto()  / 2 &&
				y + ancho / 2 <= s.getY() + s.getAlto()  / 2;
	}

	public boolean chocasteCon(Obstaculo o) {
		return	x - alto  / 2 >= o.getX() - o.getAncho() / 2 && 
				x + alto  / 2 <= o.getX() + o.getAncho() / 2 &&
				y - ancho / 2 >= o.getY() - o.getAlto()  / 2 &&
				y + ancho / 2 <= o.getY() + o.getAlto()  / 2;
	}

	public void chocasteConObstaculo() {
		y-=velocidad;
		x+=velocidad;
	}

	public Proyectil disparar () {
		Proyectil disparo = new Proyectil(getX(), getY(), getAngulo());
		return disparo;
	}

	private void mirarHaciaLaIzquierda(Entorno e) {
		e.dibujarImagen(ImgIzquierda, x, y, angulo);
	}

	public void mirarHaciaLaDerecha(Entorno e) {
		e.dibujarImagen(ImgDerecha, x, y, angulo);
	}

	public void mirarHaciaArriba(Entorno e) {
		e.dibujarImagen(ImgArriba, x, y, angulo);
	}

	public void mirarHaciaAbajo(Entorno e) {
		e.dibujarImagen(ImgAbajo, x, y, angulo);
	}

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

	public void noAvanzar(Entorno e) {
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
