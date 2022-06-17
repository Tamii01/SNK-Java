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

<<<<<<< HEAD

=======
	// Se permite que los kyojines se superpongan
>>>>>>> 997b262d672148193c709a5c8e56f88e02429a35
	public Kyojin (double x, double y, double velocidad, double tamaño, double angulo) {
		this.angulo=angulo;
<<<<<<< HEAD
		this.x = x;
		this.y = y;
		this.velocidad = 0.5;
		this.tamaño = 0.15;
		this.ancho = 2;
		this.alto = 2;
=======
		this.velocidad = 0.5;
		this.tamaño = 0.15;
		this.ancho = 70;
		this.alto = 70;
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
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
<<<<<<< HEAD
				y - alto / 2 >= o.getY() - o.getAlto()  / 2 &&
				y + alto / 2 <= o.getY() + o.getAlto()  / 2;
=======
				y - alto  / 2 >= o.getY() - o.getAlto()  / 2 &&
				y + alto  / 2 <= o.getY() + o.getAlto()  / 2;
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
	}

	public boolean dañasteAMikasa(Mikasa mikasa) {
		return	x - ancho >= mikasa.getX() - mikasa.getAncho() / 2 && 
				x + ancho <= mikasa.getX() + mikasa.getAncho() / 2 && 
<<<<<<< HEAD
				y - alto >= mikasa.getY() - mikasa.getAlto()  / 2 &&
				y + alto <= mikasa.getY() + mikasa.getAlto()  / 2;	
	}

//	public boolean teDañaron(Proyectil disparo) {
//		return false;
//	}
//	
=======
				y - alto  >= mikasa.getY() - mikasa.getAlto()  / 2 &&
				y + alto  <= mikasa.getY() + mikasa.getAlto()  / 2;	
	}
	
	public boolean teDañaron(Proyectil disparo) {
		return	x - ancho >= disparo.getX() - disparo.getAncho() / 2 && 
				x + ancho <= disparo.getX() + disparo.getAncho() / 2 && 
				y - alto  >= disparo.getY() - disparo.getAlto()  / 2 &&
				y + alto  <= disparo.getY() + disparo.getAlto()  / 2;
	}
	
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
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
<<<<<<< HEAD

//	 estásDentroDelLímiteDerecho()
=======
	//	 estásDentroDelLímiteDerecho()
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
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
	
	public double getAncho() {
		return this.ancho;
	}

	public double getAlto() {
		return this.alto;
	}
	
	public double getAngulo() {
		return this.angulo;
	}
<<<<<<< HEAD

	public boolean teDañaron(Proyectil disparo) {
		// TODO Auto-generated method stub
		return false;
	}
	
=======
>>>>>>> 794f52c52a4d35c6bdda46b44718d896a8e510b5
}
