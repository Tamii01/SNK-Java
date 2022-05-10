package juego;

import java.awt.*;

import entorno.Herramientas;
import entorno.Entorno;

public class Kyojines {
	
	private double x;
	private double y;
	
	private double velocidad;
	private double angulo;	
	
	private double tama�o;
	private Image titan;

	
	
	public Kyojines (double x, double y, double velocidad) {
		
		this.angulo = -Math.PI / 180;
		this.x = 300;
		this.y = 300;
		this.velocidad = velocidad;
		this.titan = Herramientas.cargarImagen("titanBestia.png");
		this.tama�o = 80;
		
	}
	
	public void dibujar(Entorno Titan) {
		Titan.dibujarImagen(titan, x, y, angulo, 0.30);
	}

	public void mover () {
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}
	
	public boolean chocaEntorno(Entorno entorno) {
		return x < tama�o / 1.30 || x > entorno.ancho() - tama�o / 1.30 || y < tama�o / 1.30 ; // si lo divido por 2, se sale un poco m�s de la pantalla
	}
	
	public void cambiarDeDireccion() {
		angulo += Math.PI / 1;
	}
	
	public void acelerar() {
		velocidad += 0.2;
	}
	
	public boolean chocasteCon(Obstaculos arbol) {
		return x > arbol.getY() - arbol.getAncho() / 2 && x < arbol.getX() + arbol.getAncho() / 2 
				&& y + tama�o /2 > arbol.getY() - arbol.getaAlto() / 2;	
	}
}
