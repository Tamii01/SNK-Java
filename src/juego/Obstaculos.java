package juego;

import java.awt.*;

import entorno.Entorno;

public class Obstaculos {

	private double x;
	private double y;
	
	private Image obst;

	public Obstaculos(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void dibujar (Entorno o) {
		o.dibujarImagen(obst, x, y, x);
	}
	
	public void chocasteCon() {
		
	}
}
