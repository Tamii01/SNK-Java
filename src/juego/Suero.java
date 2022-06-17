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
	public Suero(double x, double y, double alto, double ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.x = x;
		this.y = y;
		this.ImgPotion = Herramientas.cargarImagen("potion.png");
	}
	
	public void dibujar(Entorno e){
		e.dibujarImagen(ImgPotion, x, y, 0, 2);
	}

	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getAncho() {
		return this.ancho;
	}

	public double getAlto() {
		return this.alto;
	}
}
