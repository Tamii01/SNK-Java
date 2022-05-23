package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	private Entorno entorno;

	private Mikasa mikasa;
	private Kyojin kyojin;
	private Disparo disparo;

	private Image fondo;
	private Obstaculo obstaculo;

	private int puntaje;
	private int vidas;
	
	public static boolean colision(double x1, double y1, double x2, double y2, double distancia) {
		return (x1 - x2)*(x1 - x2) + (y1 - y2) * (y1 - y2) < distancia * distancia;
	}

	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600); 

		mikasa = new Mikasa(390, 300, 5); //x, y, velocidad

		kyojin = new Kyojin(100, 510, 5, 0.18);  //x, y, velocidad, tamaño

		obstaculo = new Obstaculo(150,200);

		fondo = Herramientas.cargarImagen("grass-pixel.png");
		
		this.entorno.iniciar();

		puntaje = 0;
		vidas = 5;
		
	}

	public void tick() {
		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0, 2.5);

		mikasa.dibujar(entorno);
		kyojin.dibujar(entorno);
		kyojin.mover();

//		obstaculo.dibujarCasaYArbol(entorno);
//		obstaculo.dibujarObstaculo(entorno);
		obstaculo.generarObstaculo(entorno);

		entorno.cambiarFont("sans", 15, Color.WHITE);
		entorno.escribirTexto("Posicion en x de Mikasa: " + mikasa.getX(), 500, 100);
		entorno.escribirTexto("Posicion en y de Mikasa: " + mikasa.getY(), 500, 150);
		entorno.escribirTexto("Posicion en x del Kyojin: " + kyojin.getX(), 500, 200);
		entorno.escribirTexto("Posicion en y del Kyojin: " + kyojin.getY(), 500, 250);
		entorno.escribirTexto("Posicion en y del Kyojin: " + kyojin.getY(), 500, 250);
		entorno.escribirTexto("Angulo del Kyojin: " + kyojin.getAngulo(), 500, 300);
		entorno.escribirTexto("Hay colision " + mikasa.chocasteConObstaculo(obstaculo), 500, 350);
		
		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("puntaje: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		entorno.escribirTexto("Vidas: " + vidas, 320, 30);

		if (colision(mikasa.getX(), mikasa.getY(), obstaculo.getX(), obstaculo.getY(), 100)) {
			mikasa.chocasteConAlgo(obstaculo);
		}
		
		if (kyojin.chocaEntorno(entorno)) {
			kyojin.cambiarDeDireccion();
		}

		if (kyojin.dañasteAMikasa(mikasa)) {
			vidas = vidas - 1;			
		}
		
//		if (vidas == 0) {
//			mikasa = null;
//			if (mikasa == null) {
//				entorno.cambiarFont("sans", 20, Color.WHITE);
//				entorno.escribirTexto("Game Over!", 500, 400);
//			}
//		}
		
		if (entorno.estaPresionada('a') && (mikasa.chocasteConEntornoIzquierdo())) {
			mikasa.caminarHaciaIzquierda(entorno);
		}
		
		if (entorno.estaPresionada('w') && (mikasa.chocasteConEntornoSuperior())) {
			mikasa.caminarHaciaArriba(entorno);
		}

		if (entorno.estaPresionada('s') && (mikasa.chocasteConEntornoInferior())) {
			mikasa.caminarHaciaAbajo(entorno);
		}

		if (entorno.estaPresionada('d') && (mikasa.chocasteConEntornoDerecho())) {
			mikasa.caminarHaciaDerecha(entorno);
		}
		
		if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) {
			disparo.aLaDerecha(entorno);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
