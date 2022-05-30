package juego;

import java.awt.*;

import entorno.Herramientas;
import entorno.Entorno;

public class Kyojin {

	private double x,y;
	private double velocidad;	
	private double tamaño;
	private Image titan;
	private double angulo;


	public Kyojin (double x, double y, double velocidad, double tamaño,double angulo) {
		this.angulo=angulo;
		this.x = x;
		this.y = y;
		this.velocidad = 0.5;
		this.tamaño = tamaño;
		this.titan = Herramientas.cargarImagen("titan-bestia.png");
	}
	

	public void dibujar(Entorno a) {
		a.dibujarImagen(titan, x, y, angulo, tamaño);
	}

	public void mover() {
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}

	public boolean chocaEntorno(Entorno entorno) {
		return x < 0 || x > entorno.ancho() - tamaño / 2 || y < tamaño / 2 ||  y > entorno.alto() - tamaño / 2;
	}
	
	public boolean chocasteCon(Obstaculo o) {
		return	x - tamaño / 2 >= o.getX() - o.getAncho() / 2 && 
				x + tamaño / 2 <= o.getX() + o.getAncho() / 2 && 
				y - tamaño / 2 >= o.getY() - o.getAlto() / 2 &&
				y + tamaño / 2 <= o.getY() + o.getAlto() / 2;
	}

	public boolean dañasteAMikasa(Mikasa mikasa) {
		return	x - tamaño >= mikasa.getX() - mikasa.getAncho() / 2 && 
				x + tamaño <= mikasa.getX() + mikasa.getAncho() / 2 && 
				y - tamaño >= mikasa.getY() - mikasa.getAlto() / 2 &&
				y + tamaño <= mikasa.getY() + mikasa.getAlto() / 2;	
	}
	
	public void perseguirAMikasaDerSup(Mikasa mikasa) {
		x+=velocidad;
		y-=velocidad;
	}
	
	public void perseguirAMikasaDerInf(Mikasa mikasa) {
		x+=velocidad;
		y+=velocidad;
	}

	public void perseguirAMikasaIzqSup(Mikasa mikasa) {
		x-=velocidad;
		y-=velocidad;
	}
	
	public void perseguirAMikasaIzqInf(Mikasa mikasa) {
		x-=velocidad;
		y+=velocidad;
	}
	
	public void cambiarDeDireccion() {
		angulo -= Math.PI/2;
		
	}

	public void acelerar() {
		velocidad += 0.5;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	public double getAngulo() {
		return angulo;
	}
}
