package juego;

import java.awt.*;

import entorno.Herramientas;
import entorno.Entorno;

public class Kyojin {

	private double x;
	private double y;	
	private double velocidad;	
	private double tamaño;
	private Image titan;

	private double angulo;

	public Kyojin (double x, double y, double velocidad, double tamaño, double angulo) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.tamaño = tamaño;
		this.titan = Herramientas.cargarImagen("titan-bestia.png");
	}

	public void dibujar(Entorno e) {
		e.dibujarImagen(titan, x, y, angulo, tamaño);
	}

	public void mover() {
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}

	public boolean chocaEntorno(Entorno e) {
		return x < 0 || x > e.ancho() - tamaño / 2 || y < tamaño / 2 ||  y > e.alto() - tamaño / 2;
	}

	public boolean chocasteCon(Obstaculo o) {
		return	x - tamaño / 2 >= o.getX() - o.getAncho() / 2 && 
				x + tamaño / 2 <= o.getX() + o.getAncho() / 2 && 
				y - tamaño / 2 >= o.getY() - o.getAlto() / 2 &&
				y + tamaño / 2 <= o.getY() + o.getAlto() / 2;
	}

	public boolean dañasteAMikasa(Mikasa mikasa) {
		return	x - tamaño >= mikasa.getX() - mikasa.getAncho() / 2 && 
				x + tamaño <= mikasa.getX() + mikasa.getAncho() / 2 && 
				y - tamaño >= mikasa.getY() - mikasa.getAlto() / 2 &&
				y + tamaño <= mikasa.getY() + mikasa.getAlto() / 2;	
	}

	public void perseguirAMikasa(Mikasa mikasa) {
		if (this.x > mikasa.getX() && this.y > mikasa.getY()) {
			x+=velocidad;
			y-=velocidad;								
		}																	

		if (this.x < mikasa.getX() && this.y < mikasa.getY()) {					
			x+=velocidad;
			y+=velocidad;														
		}

		if (this.x < mikasa.getX() && this.y > mikasa.getY()) {
			x-=velocidad;
			y-=velocidad;
		}

		if (this.x > mikasa.getX() && this.y < mikasa.getY()) {
			x-=velocidad;
			y+=velocidad;
		}
	}

	public boolean chocasteConEntornoIzquierdo() {
		return this.x > 20;							// compara la posicion de mikasa con el limite del entorno izquierdo
	}

	public boolean chocasteConEntornoDerecho() {
		return this.x < 780;						// compara la posicion de mikasa con el limite del entorno derecho
	}

	public boolean chocasteConEntornoSuperior() {
		return this.y > 29;							// compara la posicion de mikasa con el limite del entorno superior
	}

	public boolean chocasteConEntornoInferior() {
		return this.y < 580;						// compara la posicion de mikasa con el limite del entorno inferior
	}	

	public void cambiarDeDireccion() {
		angulo += Math.PI / 2;
	}

	public void acelerar() {
		velocidad += 0.05;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getAngulo() {
		return angulo;
	}
}
