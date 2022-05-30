package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo { 
	
	private int x;           
	private int y;          
	private int ancho;    
	private int alto;
	private int anchoArbolPequeño;

	private double angulo;
	private Image casadearriba, casadelmedio, casadeabajo, arbolgrande, arbolpequeño;
	
	public Obstaculo(int x, int y) {  
		this.x = x;
		this.y = y;
		this.ancho = 250;  
		this.alto = 250;  
		this.anchoArbolPequeño = 180;
		this.angulo = 0;                                                     // ANOTACION VIEJA = ANOTACION NUEVA  
		this.casadearriba = Herramientas.cargarImagen("casa-de-arriba.png"); // casa invertida = casa de arriba 
		this.casadelmedio = Herramientas.cargarImagen("casa-del-medio.png"); // casa = casa del  medio
		this.casadeabajo = Herramientas.cargarImagen("casa-de-abajo.png");   // nueva casa agregada
		this.arbolpequeño = Herramientas.cargarImagen("arbol-pequeño.png");  // arbol = arbol pequeño
		this.arbolgrande = Herramientas.cargarImagen("arbol-grande.png");    // nuevo arbol agregado
	}
	
	public void casaDeArriba(Entorno e) {
		e.dibujarImagen(casadearriba, x, y, angulo, 0.38);
	}
	
	public void casaDelMedio(Entorno e) {
		e.dibujarImagen(casadelmedio, x, y, angulo, 0.38);
	}
	
	public void casaDeAbajo(Entorno e) {
		e.dibujarImagen(casadeabajo, x, y, angulo, 0.45); // posición en X, posición en Y, ángulo, tamaño   
	}
	
	public void arbolPequeño(Entorno e) {
		e.dibujarImagen(arbolpequeño, x, y, angulo, 1.5); 
	}
	
	public void arbolGrande(Entorno e) {
		e.dibujarImagen(arbolgrande, x, y, angulo, 1.5);
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

	public double getAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}
	
	public double getAnchoArbolPequeño() {
		return anchoArbolPequeño;
	}
}