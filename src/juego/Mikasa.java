package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Mikasa {

	private double x;
	private double y;
	
	private double velocidad;
	
	private double ancho;
	private double alto;
	private double tama�o;
	private double angulo;
	
	private Image mikasaDer;
	/*private Image mikasaIzq;*/
	
	
	public Mikasa (double x, double y, double velocidad) {
		this.x = 390; //para que est� en el medio de la pantalla, tendr�a que ser 400, pero con 390 queda mas simetrico para m�, hehe.
		this.y = 300; //idem
		this.velocidad = velocidad;
		
		this.ancho = 0;
		this.alto = 0;
		this.tama�o = 50;
		this.angulo = -Math.PI / 4;
		
		this.mikasaDer = Herramientas.cargarImagen("mikasaDer.png");
		/*this.mikasaIzq = Herramientas.cargarImagen("mikasaIzq.png");*/

	}

	public void dibujar(Entorno d) {
		d.dibujarImagen(mikasaDer, x, y, alto);
		/*d.dibujarImagen(mikasaIzq, x, y, alto);*/
		
	}

	public void moverHaciaIzquierda() {
		x -= velocidad;
}
	
	public void moverHaciaDerecha() {
		x += velocidad;
		
	}
	
	public void moverHaciaArriba() {
		y -= velocidad;
	}
	
	public void moverHaciaAbajo() {
		y += velocidad;
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
	

	public boolean chocasteConElEntorno(Entorno entorno) {
		return x < tama�o / 2 || x > entorno.ancho() - tama�o / 2 || y < tama�o / 2;
	}
	
	public void cambiarDeDireccion() {
		angulo ++;
	}
	
}
