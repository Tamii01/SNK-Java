package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo1 {

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

	public Obstaculo1(double x, double y) {
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

	public void casa (Entorno z) {
		z.dibujarImagen(casa, 100, 300, angulo, 0.20);
	}
	
	public void casa1 (Entorno o) {
		o.dibujarImagen(casa1, 400, 100, angulo, 0.20);
	}

	public void arb1 (Entorno a) {
		a.dibujarImagen(arb1, 600, 400, angulo, 0.25);
			}
	
	public void arb2 (Entorno b) {
		b.dibujarImagen(arb2, 480, 100, angulo, 0.25);
	}
	
	public void arb3(Entorno c) {
		c.dibujarImagen(arb3, 150, 200, angulo, 0.25);
	}
	
	public void arb4(Entorno d) {
		d.dibujarImagen(arb4, 280, 450, angulo, 0.25);
		
	}
	
	public void suero(Entorno c) {
		c.dibujarImagen(suero, 450, 300, angulo, tamaño);
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
