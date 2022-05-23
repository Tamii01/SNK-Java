package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	private Entorno entorno;

	private Mikasa mikasa;
<<<<<<< HEAD
	private Kyojin kyojin;
	private Disparo disparar;

	private Image fondo;
	private Obstaculo obstaculo;
=======
	private Kyojin kyojin; // fixme después Kyoijin[]

	private Image fondo;

	// private Obstaculo[] obstaculos; // fixme
	private Obstaculo arbolGrande;
	private Obstaculo casaChica;
	private Obstaculo arb3;
	private Obstaculo arb4;
	private Obstaculo casa;
	private Obstaculo casa1;
	private Obstaculo suero;
>>>>>>> 5b38da912e8a4e087e283515fc121bb4f5afa304

	private int puntaje;
	private int vidas;

	public Juego() {

		this.entorno = new Entorno(this, "Attack on Titan - Grupo 17", 800, 600);

		mikasa = new Mikasa(390, 300, 5); //x, y, velocidad

		kyojin = new Kyojin(100, 510, 5, 0.18);  //x, y, velocidad, tamaño

<<<<<<< HEAD
		obstaculo = new Obstaculo(300,500);
=======
		arbolGrande = new Obstaculo(100, 50, "arbol");
		casaChica   = new Obstaculo(700, 400, "casa");
		
//		arb3 = new Obstaculo(entorno.ancho(), entorno.alto());
//		arb4 = new Obstaculo(entorno.ancho(), entorno.alto());
//		casa = new Obstaculo(entorno.ancho(), entorno.alto());
//		casa1 = new Obstaculo(entorno.ancho(), entorno.alto());
//		suero = new Obstaculo(entorno.ancho(), entorno.alto());

		// fixme
//		Obstaculo[] obstaculos = { arb1, arb2, arb3, arb4, casa, casa1, suero };

		puntaje = 0;
		vidas = 5;
>>>>>>> 5b38da912e8a4e087e283515fc121bb4f5afa304

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

<<<<<<< HEAD
		obstaculo.dibujarCasaYArbol(entorno);
		obstaculo.dibujarObstaculo(entorno);
		obstaculo.generarObstaculo(entorno);

		entorno.cambiarFont("sans", 15, Color.WHITE);
		entorno.escribirTexto("Posicion en x de Mikasa: " + mikasa.getX(), 500, 100);
		entorno.escribirTexto("Posicion en y de Mikasa: " + mikasa.getY(), 500, 150);
		entorno.escribirTexto("Posicion en x del Kyojin: " + kyojin.getX(), 500, 200);
		entorno.escribirTexto("Posicion en y del Kyojin: " + kyojin.getY(), 500, 250);
		entorno.escribirTexto("Posicion en y del Kyojin: " + kyojin.getY(), 500, 250);
		entorno.escribirTexto("Angulo del Kyojin: " + kyojin.getAngulo(), 500, 300);
		
=======
//		for (Obstaculo o : obstaculos) {
//			o.dibujar(entorno);
//		}

>>>>>>> 5b38da912e8a4e087e283515fc121bb4f5afa304
		entorno.cambiarFont("sans", 24, Color.WHITE);
		entorno.escribirTexto("puntaje: " + puntaje, entorno.ancho() / 2 - 350, entorno.alto() - 35);
		entorno.escribirTexto("Vidas: " + vidas, 320, 30);

<<<<<<< HEAD
=======
		// ------------ COLISION -------------

>>>>>>> 5b38da912e8a4e087e283515fc121bb4f5afa304
		if (kyojin.chocaEntorno(entorno)) {
			kyojin.cambiarDeDireccion();
		}

<<<<<<< HEAD
		if (kyojin.dañasteAMikasa(mikasa)) {
			vidas = vidas - 1;			
		}												

		if (entorno.estaPresionada('a') && (mikasa.chocasteConEntornoIzquierdo())) {
			mikasa.caminarHaciaIzquierda(entorno);
		}

		if (entorno.estaPresionada('w') && (mikasa.chocasteConEntornoSuperior())) {
=======
//		if (kyojin.chocasteCon(arb1)) {
//			kyojin.cambiarDeDireccion();
//		}
//
//		if (kyojin.chocasteCon(arb2)) {
//			kyojin.cambiarDeDireccion();
//		}

//		if (kyojin.chocasteCon(casa)) {
//			kyojin.cambiarDeDireccion();
//		}
//
//		if (kyojin.dañasteAMikasa(mikasa)) {
//			vidas--;
//		}

//		if (vidas == 0) {
//			mikasa = null;
//		} 
//		
//		if (mikasa == null) {
//			then termina el juego (mostrar por pantalla game over)
//		}

		if (mikasa.chocaEntorno(entorno)) {
			mikasa.quedarParada();
		}
		// ----------- TECLAS -------------

		if (entorno.estaPresionada('a')) {
			mikasa.caminarHaciaIzquierda(entorno);
		}

		if (entorno.estaPresionada('w')) {
>>>>>>> 5b38da912e8a4e087e283515fc121bb4f5afa304
			mikasa.caminarHaciaArriba(entorno);
		}

		if (entorno.estaPresionada('s') && (mikasa.chocasteConEntornoInferior())) {
			mikasa.caminarHaciaAbajo(entorno);
		}

		if (entorno.estaPresionada('d') && (mikasa.chocasteConEntornoDerecho())) {
			mikasa.caminarHaciaDerecha(entorno);
		}

		if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) {
<<<<<<< HEAD
			disparar.aLaDerecha(entorno);
		}
=======

		}
//
//		if (mikasa.getX() == suero.getX() - 20 && mikasa.getY() == suero.getY() - 20) {
//			suero = null;
//		}

>>>>>>> 5b38da912e8a4e087e283515fc121bb4f5afa304
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
