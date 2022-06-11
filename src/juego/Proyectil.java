package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Proyectil {

	private double x;
	private double y;

	private double angulo;
	private double tamaño;
	private Image ImgProyectilIzquierda, ImgProyectilDerecha;
	
	public Proyectil(double x, double y) {
		this.x = x;
		this.y = y;
		this.angulo = 0;
		this.tamaño = 0.05;
		this.ImgProyectilIzquierda = Herramientas.cargarImagen("disparo-derecha.png");
		this.ImgProyectilDerecha = Herramientas.cargarImagen("disparo-derecha.png");
	}
	
	public void dibujarIzquierda(Entorno e) {
		e.dibujarImagen(ImgProyectilIzquierda, x, y, angulo, tamaño);
	}
	
	public void dibujarDerecha(Entorno e) {
		e.dibujarImagen(ImgProyectilDerecha, x, y, angulo, tamaño);
	}
	
//	sacado del movimiento de la navecita
	public void girar (double modificador) {
		
		this.angulo = this.angulo + modificador;
		if(this.angulo < 0) {
			this.angulo +=2*Math.PI;
		}
		if(this.angulo > 2*Math.PI) {
			this.angulo -=2*Math.PI;
		}
	}
	
	//multiplicado *7 para que su velocidad aumente
	public void moverDerecha(Entorno e) {
		this.x += Math.cos(angulo)*7;
		this.y += Math.sin(angulo)*7;
		dibujarDerecha(e);
	}
	
	public void moverIzquierda(Entorno e) {
		this.x -= Math.cos(angulo)*7;
		this.y -= Math.sin(angulo)*7;
		dibujarIzquierda(e);
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