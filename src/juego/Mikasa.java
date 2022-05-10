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
	private double angulo;
	
	private Image mikasaDer;
	/*private Image mikasaIzq;*/
	
	
	public Mikasa (double x, double y, double velocidad) {
		this.x = 390; //para que esté en el medio de la pantalla, tendría que ser 400, pero con 390 queda mas simetrico para mí, hehe.
		this.y = 300; //idem
		this.velocidad = velocidad;
		
		this.ancho = 0;
		this.alto = 0;
		this.angulo = 0;
		
		
		this.mikasaDer = Herramientas.cargarImagen("mikasaDer.png");
		/*this.mikasaIzq = Herramientas.cargarImagen("mikasaIzq.png");*/

	}

	public void dibujar(Entorno d) {
		d.dibujarImagen(mikasaDer, x, y, angulo);
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
	

}
