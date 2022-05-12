package juego;

import java.awt.*;

import entorno.Herramientas;
import entorno.Entorno;

public class Kyojines {
	
	private double x;
	private double y;
	
	private double velocidad;
	private double angulo;	
	private double alto;
	private double ancho;
	
	
	private double tamaño;
	private Image titan;
	
	private Obstaculos arbol;
	private Mikasa mikasa;
	
	public Kyojines (double x, double y, double velocidad) {
		
		this.angulo = 180;
		this.x = 300;
		this.y = 300;
		this.velocidad = velocidad;
		this.titan = Herramientas.cargarImagen("titanBestia.png");
		this.tamaño = 80;
		
		
		
	}
	
	public void dibujar(Entorno Titan) {
		Titan.dibujarImagen(titan, x, y, angulo, 0.18); // el ultimo parametro pasado es el tamaño de la imagen
	}

	public void mover () {
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}
	
	public boolean chocaEntorno(Entorno entorno) {
		return x < tamaño / 1.30 || x > entorno.ancho() - tamaño / 1.30 || y < tamaño / 1.30 ||  y > entorno.alto() - tamaño / 1.30;// si lo divido por 2, se sale un poco más de la pantalla
	}
	
	public void cambiarDeDireccion() {
		angulo ++;
	}
	
	/*public int Puntaje(Mikasa mikasa) {
		int puntaje = 0;
		
		if (mikasa.chocaste)
	}*/
	
	public void acelerar() {
		velocidad += 0.5;
	}
	
	public double getY() {
		return y;
	}
	
	public double getX() {
		return x;
	}

	public double getaAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}

	public boolean chocasteCon(Obstaculos arbol) {
		return x > arbol.getY() - arbol.getAncho() / 2 && x < arbol.getX() + arbol.getAncho() / 2 
				&& y + tamaño /2 > arbol.getY() - arbol.getaAlto() / 2;	
	}
	

	/*public boolean chocasteCon(Mikasa mikasa) {
		return 0;	
	}
	
	/*public int Puntaje(Kyojines kyojin, Obstaculos arbol) {
		
		int puntaje = 0;
		
		switch(puntaje) {
		
		case arb1:
			if (kyojin.chocasteCon(arbol)) {
				puntaje = puntaje + 1;
			}
			
			return puntaje;
			
		
		}
	}*/
}
