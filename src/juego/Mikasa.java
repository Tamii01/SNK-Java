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
	}




	public void dibujar(Entorno o) {
		o.dibujarImagen(ImgAbajo, x, y, angulo);
		o.dibujarImagen(ImgArriba, x, y, angulo);
		o.dibujarImagen(imgDerecha, x, y, angulo);
		o.dibujarImagen(imgIzquierda, x, y, angulo); 
	}


	private void mirarHaciaLaIzquierda(Entorno e) {
		e.dibujarImagen(imgIzquierda, x, y, angulo);
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
	


	public boolean chocaEntorno(Entorno entorno) {
		return x < tamaño / 2|| y < tamaño / 2|| x > entorno.ancho() - tamaño / 2 || y > entorno.alto() - tamaño / 2;
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
		angulo -= 2;
		mirarHaciaLaIzquierda(e);
		
	}

	public void caminarHaciaDerecha(Entorno f) {
		angulo += 2;
		mirarHaciaLaDerecha(f);
	}
	
	public void caminarHaciaArriba(Entorno g) {
		x += velocidad * Math.cos(Math.toRadians(angulo));
        y += velocidad *Math.sin(Math.toRadians(angulo));
		mirarHaciaArriba(g);
	}

	public void caminarHaciaAbajo(Entorno h) {
		x -= velocidad *Math.cos(Math.toRadians(angulo));
        y -= velocidad *Math.sin(Math.toRadians(angulo));
		mirarHaciaAbajo(h);
		}


	

	public void chocasteConAlgo() {
		x -= velocidad * Math.cos(angulo);
		y -= velocidad * Math.cos(angulo);
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

//	public void cambiarDeDireccion() {
//		angulo += Math.PI / 4;


	public double getTamaño() {
		return tamaño;
	}

	public double getAngulo() {
		return this.angulo;
	}
}
