package juego;

import java.awt.*;

import entorno.Herramientas;
import entorno.Entorno;

public class Kyojin1 {

	private double x;
	private double y;

	private double velocidad;
	private double angulo;	
	private double alto;
	private double ancho;

	private double tamaño;
	private Image titan;


	public Kyojin1 (double x, double y, double velocidad) {

		this.angulo = 0;
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.titan = Herramientas.cargarImagen("titanBestia.png"); // titan-bestia.png
	}

	public void dibujar(Entorno a) {
		a.dibujarImagen(titan, x, y, angulo, 0.18); // el ultimo parametro pasado es el tamaÃ±o de la imagen
	}

	public void mover () {
		x += velocidad * Math.cos(angulo);
		y += velocidad * Math.sin(angulo);
	}

	public boolean chocaEntorno(Entorno entorno) {
		return x < tamaño / 1.30 || x > entorno.ancho() - tamaño / 1.30 || y < tamaño / 1.30 |  y > entorno.alto() - tamaño / 1.30;
	}

	public void cambiarDeDireccion() {
		angulo ++;
	}

	public void acelerar() {
		velocidad += 0.5;
	}

	public boolean chocasteCon1(Mikasa1 mikasa2) {
		return x > mikasa2.getY() - mikasa2.getAncho() / 2 && x < mikasa2.getX() + mikasa2.getAncho() / 2 
				&& y + tamaño /2 > mikasa2.getY() - mikasa2.getaAltura() / 2;	
	}

	public boolean chocasteCon(Obstaculo1 obstaculo) {
		return x > obstaculo.getY() - obstaculo.getAncho() / 2 && x < obstaculo.getX() + obstaculo.getAncho() / 2 
				&& y + tamaño /2 > obstaculo.getY() - obstaculo.getaAlto() / 2;	
	}

	public boolean chocasteCon2(Obstaculo1 obstaculo2) {
		return x > obstaculo2.getY() - obstaculo2.getAncho() / 2 && x < obstaculo2.getX() + obstaculo2.getAncho() / 2 
				&& y + tamaño /2 > obstaculo2.getY() - obstaculo2.getaAlto() / 2;	
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
