package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Suero {

	private double x;
	private double y;
	private double alto;
	private double ancho;
	private double tamaño;
	private Image ImgPotion;
	public Suero(double x, double y) {
		this.tamaño = 0.8;
		this.x = x;
		this.y = y;
		this.ancho = 150;
		this.alto = 150;
		this.ImgPotion = Herramientas.cargarImagen("potion.png");
	}
	
	public void dibujar(Entorno e){
		e.dibujarImagen(ImgPotion, x, y, 0, tamaño);
	}

	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getTamaño() {
		return this.tamaño;
	}
	
	public double getAlto() {
		return this.alto;
	}
		
	public double getAncho() {
		return this.ancho;
	}
	
}
