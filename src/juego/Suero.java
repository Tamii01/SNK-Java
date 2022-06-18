package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Suero {

	private double x;
	private double y;
	private double ancho, alto;
	private Image ImgPotion;
	
	// IDEA:
	//Lo que pensé para generar un nuevo suero cada tanto tiempo, mientras este sea null, 
	//es poner un suero en X lugar, luego se podría usar un contador y recorrerlo con un for
	//para simular el tiempo en que el suero queda en ese lugar antes de eliminarse y generarse en otra posicion.
	//si el contador llega a 0, se genera un nuevo suero en un lugar random. 
	//Cuando Mikasa pasa sobre el suero (cuando las pos. de cada uno son iguales) el suero se elimina (== null) y se genera uno nuevo en otro lado.
<<<<<<< HEAD
	public Suero(double x, double y, double alto, double ancho) {
		this.alto = alto;
		this.ancho = ancho;
=======
<<<<<<< HEAD
	public Suero(double x, double y, double alto, double ancho) {
		this.alto = alto;
		this.ancho = ancho;
=======
	public Suero(double x, double y) {
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
		this.x = x;
		this.y = y;
		this.ancho = 70;
		this.alto  = 70;
		this.ImgPotion = Herramientas.cargarImagen("potion.png");
	}
	
	public void dibujar(Entorno e){
<<<<<<< HEAD
		e.dibujarImagen(ImgPotion, x, y, 0, 2);
=======
<<<<<<< HEAD
		e.dibujarImagen(ImgPotion, x, y, 0, 2);
=======
		e.dibujarImagen(ImgPotion, x, y, 0, 0.8);
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
	}

	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getAncho() {
		return this.ancho;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
	}

	public double getAlto() {
		return this.alto;
<<<<<<< HEAD
=======
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
	}

	public double getAlto() {
		return this.alto;
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
	}
}
