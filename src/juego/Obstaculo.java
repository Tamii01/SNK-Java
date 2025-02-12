package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo { 
	
	private int x;           
	private int y;          
	private int ancho;    
	private int alto;

	private Image casadearriba, casadelmedio, casadeabajo, arbolgrande, arbolpequeño;
	
	public Obstaculo(int x, int y, String tipo) {  
		this.x = x;
		this.y = y;
		this.ancho = 250;  
		this.alto = 250;                                                      
		this.casadearriba = Herramientas.cargarImagen("casa-de-arriba.png"); 
		this.casadelmedio = Herramientas.cargarImagen("casa-del-medio.png"); 
		this.casadeabajo = Herramientas.cargarImagen("casa-de-abajo.png"); 
		this.arbolpequeño = Herramientas.cargarImagen("arbol-pequeño.png"); 
		this.arbolgrande = Herramientas.cargarImagen("arbol-grande.png"); 
	}
	
	public void dibujar(Entorno e, String tipo) {
		if(tipo.equals("casaDeArriba")) {
			e.dibujarImagen(casadearriba, x, y, 0, 0.38);
		}
		
		if(tipo.equals("casaDelMedio")) {
			e.dibujarImagen(casadelmedio, x, y, 0, 0.38);
		}
		
		if(tipo.equals("casaDeAbajo")) {
			e.dibujarImagen(casadeabajo, x, y, 0, 0.45);
		}
		
		if(tipo.equals("arbolPequeño")) {
			e.dibujarImagen(arbolpequeño, x, y, 0, 1.5);
		}
		
		if(tipo.equals("arbolGrande")) {
			e.dibujarImagen(arbolgrande, x, y, 0, 1.5);
		}

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