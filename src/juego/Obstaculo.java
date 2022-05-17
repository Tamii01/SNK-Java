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
	private double tamaño = 0.50;

	private Image arb1;
	private Image arb2;
	private Image arb3;
	private Image arb4;
	private Image casa;
	private Image casa1;
	private Image suero;

	public Obstaculo(double x, double y) {
		this.x = x;
		this.y = y;
		this.angulo = 0;
		this.arb1 = Herramientas.cargarImagen("arbol-pixel.png");
		this.arb2 = Herramientas.cargarImagen("arbol-pixel.png");
		this.arb3 = Herramientas.cargarImagen("arbol-pixel.png");
		this.arb4 = Herramientas.cargarImagen("arbol-pixel.png");
		this.casa = Herramientas.cargarImagen("casa-pixel.png");
		this.casa1 = Herramientas.cargarImagen("casa-pixel1.png");
		this.suero = Herramientas.cargarImagen("potion.png");
	}

	public void obstaculos (Entorno z) {
		z.dibujarImagen(casa, 100, 300, angulo, 0.20);
		z.dibujarImagen(casa1, 400, 100, angulo, 0.20);
		z.dibujarImagen(arb1, 600, 400, angulo, 0.25);
		z.dibujarImagen(arb2, 480, 100, angulo, 0.25);
		z.dibujarImagen(arb3, 150, 200, angulo, 0.25);
		z.dibujarImagen(arb4, 280, 450, angulo, 0.25);
		z.dibujarImagen(suero, 450, 300, angulo, tamaño);
	}
	
	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

	public double getaAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}
}
