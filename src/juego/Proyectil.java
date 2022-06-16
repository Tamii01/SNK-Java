package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Proyectil {

	private double x, y, ancho, alto, angulo;
	private Image  ImgProyectil;
	
	public Proyectil(double x, double y, double angulo) {
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.alto = 70;
		this.ancho = 70;
		this.ImgProyectil = Herramientas.cargarImagen("disparo-derecha.png");
	}
	
	public void dibujar(Entorno e) {
		e.dibujarImagen(this.ImgProyectil, this.getX(), this.getY(), angulo, 0.05);
	}
	//multiplicado *7 para que su velocidad aumente
	public void mover(Entorno e) {
		this.x += Math.cos(angulo)*7;
		this.y += Math.sin(angulo)*7;
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

    public double getAngulo() {
        return this.angulo;
    }

}