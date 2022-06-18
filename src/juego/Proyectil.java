package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Proyectil {

<<<<<<< HEAD
	private double x, y, ancho, alto, angulo;
	private Image  ImgProyectil;
=======
	private double x;
	private double y;

	private double angulo;
	private double tamaño;
<<<<<<< HEAD
	private Image  ImgProyectilDerecha;
=======
<<<<<<< HEAD
	private Image  ImgProyectilDerecha;
=======
	private Image ImgProyectilDerecha;
>>>>>>> 997b262d672148193c709a5c8e56f88e02429a35
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
	
	public Proyectil(double x, double y, double angulo) {
		this.x = x;
		this.y = y;
		this.angulo = angulo;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
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

=======
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
		this.tamaño = 0.05;
		this.ImgProyectilDerecha = Herramientas.cargarImagen("disparo-derecha.png");
	}
	
<<<<<<< HEAD
	public void dibujar(Entorno e) {
		e.dibujarImagen(ImgProyectilDerecha, x, y, angulo, tamaño);
	}

	//multiplicado *7 para que su velocidad aumente
	public void mover(Entorno e) {
		this.x += Math.cos(angulo)*7;
		this.y += Math.sin(angulo)*7;
	}

=======
<<<<<<< HEAD
	public void dibujar(Entorno e) {
		e.dibujarImagen(ImgProyectilDerecha, x, y, angulo, tamaño);
	}

	//multiplicado *7 para que su velocidad aumente
	public void mover(Entorno e) {
		this.x += Math.cos(angulo)*7;
		this.y += Math.sin(angulo)*7;
	}

=======
	public void dibujarse(Entorno e) {
		e.dibujarImagen(ImgProyectilDerecha, x, y, angulo, tamaño);
	}
	
//	sacado del movimiento de la navecita

	
	//multiplicado *7 para que su velocidad aumente
	public void avanzar(Entorno e) {
		this.x += Math.cos(angulo)*7;
		this.y += Math.sin(angulo)*7;
//		dibujarse(e);
	}
	

	
>>>>>>> 997b262d672148193c709a5c8e56f88e02429a35
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
>>>>>>> 84d747720ecdabdcafe4cee1f78b4633e5dd8d2a
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
<<<<<<< HEAD
	
	public double getTamaño() {
		return this.tamaño;
	}
	
 }
=======
    
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
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
