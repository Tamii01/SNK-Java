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
	private double tama�o;
	
	private Image mikasaDer;
	private Image mikasaIzq;
	
	
	public Mikasa (double x, double y, double velocidad) {
		this.x = 390; //para que est� en el medio de la pantalla, tendr�a que ser 400, pero con 390 queda mas simetrico para m�, hehe.
		this.y = 300; //idem
		this.velocidad = velocidad;
		
		this.ancho = 0;
		this.alto = 0;
		this.angulo = 0;
		this.tama�o = 80;
		
		
		this.mikasaDer = Herramientas.cargarImagen("mikasaDer.png");
		this.mikasaIzq = Herramientas.cargarImagen("mikasaIzq.png");

	}
	
	public void mikasaIzq(Entorno izq) {
		izq.dibujarImagen(mikasaIzq, x, y, alto);
	
	}
	
	public boolean chocaEntorno(Entorno entorno) {
		return x < tama�o / 1.30 || x > entorno.ancho() - tama�o / 1.30 || y < tama�o / 1.30 ||  y > entorno.alto() - tama�o / 1.30;// si lo divido por 2, se sale un poco m�s de la pantalla
	}

	public void dibujar(Entorno d) {
		d.dibujarImagen(mikasaDer, x, y, angulo);
	
		
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
	
	//public boolean chocasteCon(Kyojines titan) {

	//}
	
	/*public int Vida() {
		int vida = 5;
		if 
	}*/
}
