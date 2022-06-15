package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Proyectil {

	private double x;
	private double y;

	private double angulo;
	private double tamaño;
	private Image ImgProyectilDerecha;
	
	public Proyectil(double x, double y, double angulo) {
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.tamaño = 0.05;
		this.ImgProyectilDerecha = Herramientas.cargarImagen("disparo-derecha.png");
	}
	
	public void dibujarse(Entorno e) {
		e.dibujarImagen(ImgProyectilDerecha, x, y, angulo, tamaño);
	}
	
//	sacado del movimiento de la navecita

	
	//multiplicado *7 para que su velocidad aumente
	public void avanzar(Entorno e) {
		this.x += Math.cos(angulo)*7;
		this.y += Math.sin(angulo)*7;
//		dibujarse(e);
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

	
 }