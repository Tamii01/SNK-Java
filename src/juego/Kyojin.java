package juego;

import java.awt.*;

import entorno.Herramientas;
import entorno.Entorno;

public class Kyojin {

	private double x,y;
	private double velocidad;	
	private double tamaño;
	private double ancho;
	private double alto;
	private Image ImgTitan;

	private double angulo;

	public Kyojin (double x, double y, double velocidad, double tamaño, double angulo) {
		this.angulo=angulo;
		this.x = x;
		this.y = y;
		this.velocidad = 0.5;
		this.tamaño = 0.15;
		this.ancho = 2;
		this.alto = 2;
		this.ImgTitan = Herramientas.cargarImagen("titan-bestia.png");
	}

	public void dibujar(Entorno e) {
		e.dibujarImagen(ImgTitan, x, y, angulo, tamaño);
	}

	public void mover() {
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}

	public boolean chocaEntorno(Entorno e) {
		return x < 0 || x > e.ancho() - tamaño / 2 || y < tamaño / 2 ||  y > e.alto() - tamaño / 2;
	}

	public boolean chocasteCon(Obstaculo o) {
		return	x - ancho / 2 >= o.getX() - o.getAncho() / 2 && 
				x + ancho / 2 <= o.getX() + o.getAncho() / 2 && 
				y - alto / 2 >= o.getY() - o.getAlto()  / 2 &&
				y + alto / 2 <= o.getY() + o.getAlto()  / 2;
	}

	public boolean dañasteAMikasa(Mikasa mikasa) {
		return	x - ancho >= mikasa.getX() - mikasa.getAncho() / 2 && 
				x + ancho <= mikasa.getX() + mikasa.getAncho() / 2 && 
				y - alto >= mikasa.getY() - mikasa.getAlto()  / 2 &&
				y + alto <= mikasa.getY() + mikasa.getAlto()  / 2;	
	}

//	public boolean teDañaron(Proyectil disparo) {
//		return false;
//	}
//	
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

//	 estásDentroDelLímiteDerecho()
	public boolean estasDentroDelLimiteIzquierdo() {
		return this.x > 20;							// compara la posicion de mikasa con el limite del entorno izquierdo
	}

	public boolean estasDentroDelLimiteDerecho() {
		return this.x < 780;						// compara la posicion de mikasa con el limite del entorno derecho
	}

	public boolean estasDentroDelLimiteSuperior() {
		return this.y > 29;							// compara la posicion de mikasa con el limite del entorno superior
	}

	public boolean estasDentroDelLimiteInferior() {
		return this.y < 580;						// compara la posicion de mikasa con el limite del entorno inferior
	}	

	public void cambiarDeDireccion() {
		angulo -= Math.PI/2;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getAngulo() {
		return this.angulo;
	}

	public boolean teDañaron(Proyectil disparo) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
