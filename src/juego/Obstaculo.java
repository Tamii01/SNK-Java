package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo {

	private double x;
	private double y;
	private double ancho;
	private double alto;
	private double angulo;
	private double tamaño = 0.50; // fixme


	private Image casa;

	private Image casainvertida;
	private Image arbol;

	private Image casa1;
	private Image suero; //fixme


	public Obstaculo(double x, double y, String tipo) {
		this.x = x;
		this.y = y;
		this.angulo = 0;
		this.casainvertida = Herramientas.cargarImagen("casa-pixel-invertida.png");
		this.casa = Herramientas.cargarImagen("casa-pixel.png");
		this.arbol = Herramientas.cargarImagen("arbol-pixel.png");
	}


	public void generarObstaculo(Entorno e) {
		e.dibujarImagen(casainvertida, 150, 200, angulo, 0.20);
		e.dibujarImagen(arbol, 500, 230, angulo, 0.25);
	}
	// fixme
	public void obstaculos (Entorno z) {
		z.dibujarImagen(casa, 100, 300, angulo, 0.20);
		z.dibujarImagen(casa1, 400, 100, angulo, 0.20);
		z.dibujarImagen(arbol, 600, 400, angulo, 0.25);
		z.dibujarImagen(arbol, 480, 100, angulo, 0.25);
		z.dibujarImagen(arbol, 150, 200, angulo, 0.25);
		z.dibujarImagen(arbol, 280, 450, angulo, 0.25);
		z.dibujarImagen(suero, 450, 300, angulo, tamaño);

	}

	public void dibujarObstaculo (Entorno e) {
		e.dibujarImagen(casa, 600, 200, angulo, 0.20);
		e.dibujarImagen(arbol, 400, 400, angulo, 0.25);
	}

	public void dibujarCasaYArbol (Entorno e) {
		e.dibujarImagen(casainvertida, 450, 500, angulo, 0.20);
		e.dibujarImagen(arbol, 300, 630, angulo, 0.25);
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

	public double getAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}
}
