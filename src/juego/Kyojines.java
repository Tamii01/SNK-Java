package juego;

import java.awt.*;

import entorno.Herramientas;
import entorno.Entorno;

public class Kyojines {
	
	private double x;
	private double y;
	
	private double velocidad;
	private double angulo;	
	
	private double inclinacion;
	private Image titan;

	
	
	public Kyojines (double x, double y, double velocidad) {
		
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.titan = Herramientas.cargarImagen("titanBestia.png");
		this.inclinacion = 0;
		
	}
	
	public void dibujar(Entorno Titan) {
		Titan.dibujarImagen(titan, x, y, inclinacion, 0.30);
	}

	public void mover () {
		x ++;
		y ++;
	}
	
	public boolean chocaEntorno(Entorno entorno) {
		return x < inclinacion / 2 || x > entorno.ancho() - inclinacion / 2 || y < inclinacion / 2 || y > inclinacion / 2;  
	}
	
	public void cambiarDeDireccion() {
		angulo ++;
	}
	
	public void acelerar() {
		velocidad += 0.5;
	}
	
	public boolean chocasteCon(Mikasa mikasa) {
		return x > mikasa.getY() - mikasa.getAncho() / 2 && x < mikasa.getX() + mikasa.getAncho() / 2 && y + inclinacion /2 > mikasa.getY() - mikasa.getaAlto() / 2;	
	}
}
