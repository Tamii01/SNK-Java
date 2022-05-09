package juego;

import java.awt.*;

import entorno.Herramientas;
import entorno.Entorno;

public class Kyojines {
	
	private double x;
	private double y;
	private int tamaño;
	private double velocidad;
	private Image titan;
	
	
	public void Titan(double x, double y, double velocidad) {
		
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.titan = Herramientas.cargarImagen("titanBestia.png");
		
	}
	
	public void dibujar(Entorno Titan) {
		Titan.dibujarImagen(titan, x, y, tamaño);
	}
	
	
}
