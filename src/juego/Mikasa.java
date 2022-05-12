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

	private double angulo;
	private double tamaño;

	private Image imgDerecha;
	private Image imgIzquierda;

	public Mikasa(double x, double y, double velocidad) {
		this.x = 390; // para que esté en el medio de la pantalla, tendría que ser 400, pero con 390
						// queda mas simetrico para mí, hehe.
		this.y = 300; // idem
		this.velocidad = velocidad;

		this.ancho = 0;
		this.alto = 0;
		this.angulo = 0;
		this.tamaño = 80;

		this.imgDerecha = Herramientas.cargarImagen("mikasaDer.png");
		this.imgIzquierda = Herramientas.cargarImagen("mikasaIzq.png");
	}

	private void mirarHaciaLaIzquierda(Entorno e) {
		e.dibujarImagen(imgIzquierda, x, y, alto);
	}

	public boolean chocaEntorno(Entorno entorno) {
		return x < tamaño / 1.30 || x > entorno.ancho() - tamaño / 1.30 || y < tamaño / 1.30
				|| y > entorno.alto() - tamaño / 1.30;// si lo divido por 2, se sale un poco más de la pantalla
	}

	public void dibujar(Entorno d) {
		d.dibujarImagen(imgDerecha, x, y, angulo);

	}

	public void moverHaciaIzquierda(Entorno e) {
		x -= velocidad;
		mirarHaciaLaIzquierda(e);
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

//	public double getY() {
//		return y;
//	}
//
//	public double getX() {
//		return x;
//	}
//
//	public double getaAlto() {
//		return alto;
//	}
//
//	public double getAncho() {
//		return ancho;
//	}

	// public boolean chocasteCon(Kyojines titan) {

	// }

	/*
	 * public int Vida() { int vida = 5; if }
	 */
}
