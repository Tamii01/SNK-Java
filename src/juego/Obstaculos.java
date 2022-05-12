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
	private double tamaño = 0.50;

	private Image arb1;
	private Image arb2;
	private Image arb3;
	private Image arb4;
	private Image casa1;

	public Obstaculos(double x, double y) {
		this.x = 600;
		this.y = 400;
		this.arb1 = Herramientas.cargarImagen("tree.png");
		this.arb2 = Herramientas.cargarImagen("tree.png");
		this.arb3 = Herramientas.cargarImagen("tree.png");
		this.arb4 = Herramientas.cargarImagen("tree.png");
		this.casa1 = Herramientas.cargarImagen("casa2.png");
		this.angulo = 0;
	}



	public void casa1 (Entorno o) {
		o.dibujarImagen(casa1, 300, 100, angulo, tamaño);
	}


	public void arb1 (Entorno a) {
		a.dibujarImagen(arb1, x, y, angulo, tamaño);
		
	}
	
	public void arb2 (Entorno b) {
		b.dibujarImagen(arb2, 580, 100, angulo, tamaño);
	}

	public boolean chocasteCon1(Obstaculos arb1) {
		return x > arb1.getY() - arb1.getAncho() / 2 && x < arb1.getX() + arb1.getAncho() / 2 
				&& y + tamaño /2 > arb1.getY() - arb1.getaAlto() / 2;
	}
	
	
	public void arb3(Entorno c) {
		c.dibujarImagen(arb3, 80, 200, angulo, tamaño);
	}
	
	public void arb4(Entorno d) {
		d.dibujarImagen(arb4, 80, 200, angulo, tamaño);
		
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
