package juego;

import java.awt.*;

import entorno.Herramientas;
import entorno.Entorno;

public class Kyojin {

	private double x;
	private double y;

	private double velocidad;
	private double angulo;	
	private double alto;
	private double ancho;

	private double tamaño;
	private Image titan;


	public Kyojin (double x, double y, double velocidad, double tamaño) {
		this.tamaño = tamaño;
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.titan = Herramientas.cargarImagen("titan-bestia.png");
	}

	public void dibujar(Entorno a) {
		a.dibujarImagen(titan, x, y, angulo, tamaño);
	}

	public void mover () {
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}

	public boolean chocaEntorno(Entorno entorno) {
		return x < tamaño || x > entorno.ancho() - tamaño / 1.30 || y < tamaño / 1.30 ||  y > entorno.alto() - tamaño / 1.30;
	}

	public void cambiarDeDireccion() {
		angulo += Math.PI / 2;
	}

	public void acelerar() {
		velocidad += 0.5;
	}

	public boolean dañasteAMikasa(Mikasa mikasa) {
		return x == mikasa.getX() - mikasa.getTamaño() && x > mikasa.getY() + mikasa.getTamaño()
		&& y + tamaño > mikasa.getY() - mikasa.getaAltura();	
	}

	//	public boolean chocasteCon(Obstaculo o) {
	//		return x < o.getY() - o.getAncho() / 2 && x < o.getX() + o.getAncho() / 2 
	//				&& y + tamaño / 2 < o.getY() - o.getAlto() / 2;	
	//	}

	//	public boolean chocasteCon2(Obstaculo o) {
	//		return x > o.getY() - o.getAncho() / 2 && x < o.getX() + o.getAncho() / 2 
	//				&& y + tamaño /2 > o.getY() - o.getAlto() / 2;
	//	}

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

	public double getAngulo() {
		return angulo;
	}

	/*	public void perseguirA(Mikasa1 mikasa) {
	if (mikasa.getX() > 0) {
		x++;
	}
	if (mikasa.getX() < 0) {
		x++;
	}
	if (mikasa.getY() > 0) {
		y++;
	}
	if (mikasa.getY() < 0) {
		y++;
	}
}*/

	/*	public void quedarParado() {
	x -= velocidad * Math.cos(angulo);
	y -= velocidad * Math.sin(angulo);
}*/


}
