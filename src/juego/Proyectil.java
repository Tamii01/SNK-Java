package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Proyectil {

	private double x;
	private double y;
	
	private double velocidad;
	private double angulo;
	private double tamaño;
	private Image proyectil; // img
	
	public Proyectil(double x, double y, double velocidad, double angulo) {
		this.x = x;
		this.y = y;
		this.velocidad = 2;
		this.angulo = 0;
		this.tamaño = 0.05;
		this.proyectil = Herramientas.cargarImagen("disparo.png"); //Cambiar nombre de la imagen}
		
	}

//	public void dibujarr(Entorno e) {
//		if (mikasa.getX() > 400 && mikasa.getY() > 600) {
//			e.dibujarImagen(proyectil, x, y, angulo, 0.05);
//			this.x--;
//			this.y--;
//		}
//		
//		if (mikasa.getX() < 400 && mikasa.getY() < 600) {
//			e.dibujarImagen(proyectil, x, y, angulo, 0.05);
//			this.x++;
//			this.y++;
//		}
//		
//		if (mikasa.getX() > 400 && mikasa.getY() < 600) {
//			e.dibujarImagen(proyectil, x, y, angulo, 0.05);
//			this.x--;
//			this.y++;
//		}
//		
//		if (mikasa.getX() < 400 && mikasa.getY() > 600) {
//			e.dibujarImagen(proyectil, x, y, angulo, 0.05);
//			this.x++;
//			this.y--;
//		}
//
//	}
	
	public void dispararDerSup(Entorno e) {
		e.dibujarImagen(proyectil, x, y, angulo, tamaño);
		x+=velocidad * Math.cos(angulo);
		y-=velocidad * Math.sin(angulo);
	}
	
	public void dispararDerInf(Entorno e) {
		e.dibujarImagen(proyectil, x, y, angulo, tamaño);
		x+=velocidad * Math.cos(angulo);
		y+=velocidad * Math.sin(angulo);
	}
	
	public void dispararIzqSup(Entorno e) {
		e.dibujarImagen(proyectil, x, y, angulo, tamaño);
		y-=velocidad * Math.cos(angulo);
		x-=velocidad * Math.sin(angulo);
	}
	
	public void dispararIzqInf(Entorno e) {
		e.dibujarImagen(proyectil, x, y, angulo, tamaño);
		x-=velocidad * Math.cos(angulo);
		y+=velocidad * Math.sin(angulo);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
 }