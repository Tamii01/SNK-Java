package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculos {

	private double x;
	private double y;
	private double ancho;
	private double alto;
	private double angulo;

	private Image arb1;
	private Image arb2;
	private Image casa1;

	public Obstaculos(double x, double y) {
		this.x = 600;
		this.y = 400;
		this.arb1 = Herramientas.cargarImagen("tree.png");
		this.arb2 = Herramientas.cargarImagen("tree.png");
		this.casa1 = Herramientas.cargarImagen("casa2.png");
		this.angulo = 0;
	}



	public void dibujar (Entorno o) {
		o.dibujarImagen(arb1, x, y, angulo, 0.50);
		o.dibujarImagen(arb2, 580, 40, angulo, 0.50);
		o.dibujarImagen(casa1, 300, 100, angulo, 0.50);
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
