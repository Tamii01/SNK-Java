package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo { 
	
	private int x;           
	private int y;          
	private int ancho;    
	private int alto;
<<<<<<< HEAD
	
=======

//	private double angulo;
>>>>>>> 997b262d672148193c709a5c8e56f88e02429a35
	private Image casadearriba, casadelmedio, casadeabajo, arbolgrande, arbolpequeño;
	
	public Obstaculo(int x, int y, String tipo) {  
		this.x = x;
		this.y = y;
		this.ancho = 250;  
		this.alto = 250;                                                       // ANOTACION VIEJA = ANOTACION NUEVA  
		this.casadearriba = Herramientas.cargarImagen("casa-de-arriba.png"); // casa invertida = casa de arriba 
		this.casadelmedio = Herramientas.cargarImagen("casa-del-medio.png"); // casa = casa del  medio
		this.casadeabajo = Herramientas.cargarImagen("casa-de-abajo.png");   // nueva casa agregada
		this.arbolpequeño = Herramientas.cargarImagen("arbol-pequeño.png");  // arbol = arbol pequeño
		this.arbolgrande = Herramientas.cargarImagen("arbol-grande.png");    // nuevo arbol agregado
	}
	
	public void casaDeArriba(Entorno e) {
		e.dibujarImagen(casadearriba, x, y, 0, 0.38);
	}
	
	public void casaDelMedio(Entorno e) {
		e.dibujarImagen(casadelmedio, x, y, 0, 0.38);
	}
	
	public void casaDeAbajo(Entorno e) {
		e.dibujarImagen(casadeabajo, x, y, 0, 0.45); // posición en X, posición en Y, ángulo, tamaño   
	}
	
	public void arbolPequeño(Entorno e) {
		e.dibujarImagen(arbolpequeño, x, y, 0, 1.5); 
	}
	
	public void arbolGrande(Entorno e) {
		e.dibujarImagen(arbolgrande, x, y, 0, 1.5);
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}
	

}