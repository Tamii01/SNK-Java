package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Proyectil {

	private double x;
	private double y;

	private double angulo;
	private double tamaño;
	private double ancho;
	private double alto;
	private Image ImgProyectilDerecha;
	
	public Proyectil(double x, double y, double angulo) {
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.tamaño = 0.05;
		this.ancho = 20;
		this.alto = 20;
		this.ImgProyectilDerecha = Herramientas.cargarImagen("disparo-derecha.png");
	}
	
	public void dibujarse(Entorno e) {
		e.dibujarImagen(ImgProyectilDerecha, x, y, angulo, tamaño);
	}
	
	public boolean colision(Kyojin kyojines) {
		return kyojines.getX() + kyojines.getAncho() + 20 / 2 > getX() - getAncho() / 2 && 
				kyojines.getX() - kyojines.getAncho() + 20 / 2 < getX() + getAncho() / 2 && 
				kyojines.getY() + kyojines.getAlto()  + 20 / 2 > getY() - getAlto()  / 2 && 
				kyojines.getY() - kyojines.getAlto()  + 20 / 2 < getY() + getAlto()  / 2;
	}
	
	//multiplicado *7 para que su velocidad aumente
	public void avanzar(Entorno e) {
		this.x += Math.cos(angulo)*7;
		this.y += Math.sin(angulo)*7;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getAncho() {
		return this.ancho;
	}
	
	public double getAlto() {
		return this.alto;
	}
 }