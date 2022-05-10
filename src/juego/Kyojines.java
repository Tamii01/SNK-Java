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
	
	private Obstaculos arb1;
	private Obstaculos arb2;

	
	
	public Kyojines (double x, double y, double velocidad) {
		
		this.angulo = 4;
		this.x = 300;
		this.y = 300;
		this.velocidad = velocidad;
		this.titan = Herramientas.cargarImagen("titanBestia.png");
		this.tama�o = 80;
		
	}
	
	public void dibujar(Entorno Titan) {
		Titan.dibujarImagen(titan, x, y, angulo, 0.18); // el ultimo parametro pasado es el tama�o de la imagen
	}

	public void mover () {
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}
	
	public boolean chocaEntorno(Entorno entorno) {
		return x < tama�o / 1.30 || x > entorno.ancho() - tama�o / 1.30 || y < tama�o / 1.30 ||  y > entorno.alto() - tama�o / 1.30;// si lo divido por 2, se sale un poco m�s de la pantalla
	}
	
	public void cambiarDeDireccion() {
		angulo ++;
	}
	
	public void acelerar() {
		velocidad += 0.5;
	}
	
	public boolean chocasteCon(Obstaculos arbol) {
		return x > arbol.getY() - arbol.getAncho() / 2 && x < arbol.getX() + arbol.getAncho() / 2 
				&& y + tama�o /2 > arbol.getY() - arbol.getaAlto() / 2;	
	}

	public boolean chocasteCon(Mikasa mikasa) {
		return x > mikasa.getY() - mikasa.getAncho() / 2 && x < mikasa.getX() + mikasa.getAncho() / 2 
				&& y + tama�o /2 > mikasa.getY() - mikasa.getaAlto() / 2;	
	}
}
