package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculos {

	private double x;
	private double y;
	private double ancho;
	private double alto;
	private double inclinacion;
	
	private Image obst;

	public Obstaculos(double x, double y) {
		this.x = 90;
		this.y = 250;
		this.obst = Herramientas.cargarImagen("tree.png");
		this.inclinacion = 0;
	}
	


	public void dibujar (Entorno o) {
		o.dibujarImagen(obst, x, y, inclinacion);
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
