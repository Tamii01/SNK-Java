package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo {


	private double x;
	private double y;
	private double anchoCasa;
	private double altoCasa;
	//	private double anchoArbol;
	//	private double altoArbol;
	private double angulo;
	private double tamaño;

	//	private Image casa;
	private Image casainvertida;
	//	private Image arbol;
	private Color color;

	public Obstaculo(double x, double y) {
		this.x = x;
		this.y = y; 
		this.tamaño = 0.18;
		this.anchoCasa = 200;
		this.altoCasa = 20; 
		this.angulo = 0;
		this.casainvertida = Herramientas.cargarImagen("casa-pixel-invertida.png");
		this.color = Color.green;
		//		this.casa = Herramientas.cargarImagen("casa-pixel.png");
		//		this.arbol = Herramientas.cargarImagen("arbol-pixel.png");
	}

	public void dibujar(Entorno o) {
		o.dibujarRectangulo(x, y, anchoCasa, altoCasa, angulo, color);
	}

	public void obstaculo (Entorno e) { //cambiar nombre
		e.dibujarImagen(casainvertida, x, y, angulo, tamaño);
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

	public double getAltoCasa() {
		return altoCasa;
	}

	public double getAnchoCasa() {
		return anchoCasa;
	}

	public void Comentados() { // solo para tener los metodos comentados más ordenados
		//		public void dibujarObstaculo (Entorno e) {
		////	e.dibujarImagen(casa, 600, 200, angulo, 0.20);
		////	e.dibujarImagen(arbol, 400, 400, angulo, 0.25);
		//}
		//
		//public void dibujarCasaYArbol (Entorno e) {
		////	e.dibujarImagen(casainvertida, 450, 500, angulo, 0.20);
		////	e.dibujarImagen(arbol, 300, 630, angulo, 0.25);
		//}

		//	
		//		public double getAltoArbol() {
		//			return altoArbol;
		//		}
		//	
		//		public double getAnchoArbol() {
		//			return anchoArbol;
		//		}

		//		public void generarObstaculo(Entorno e) { //cambiar nombre
		//			e.dibujarImagen(casainvertida, x, y, angulo, tamaño);
		//			e.dibujarImagen(arbol, 500, 230, angulo, 0.25);
		//		}

	}
}